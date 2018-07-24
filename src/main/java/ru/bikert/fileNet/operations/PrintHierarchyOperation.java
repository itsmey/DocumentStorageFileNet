package ru.bikert.fileNet.operations;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.core.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;
import java.util.List;

public class PrintHierarchyOperation extends Operation {
    private static ObjectStore objStore;

    public static JSONObject getObj() {
        return obj;
    }

    private static JSONObject obj = new JSONObject();

    public PrintHierarchyOperation() {
        super(Constants.OperationNames.PRINT, " ", Constants.OperationDescription.PRINT);
    }

    public void perform(List<String> arguments) {
        objStore = Connect.getObjectStore();
        String folder = DocumentFileNet.getPath();

        String i = " ";
        getHierarchy(folder, i, obj);
    }


    private static void getHierarchy(String path, String i, JSONObject obj){
        try {

            Folder folderOj= Factory.Folder.fetchInstance(objStore, path, null);
            FolderSet subFolders= folderOj.get_SubFolders();
            Iterator it = subFolders.iterator();
            while(it.hasNext()){
                Folder subFolder= (Folder) it.next();
                String name = (subFolder).get_FolderName();
                System.out.println(i + name);
                obj.put("NameFolder", name);
                if(subFolder.getProperties().getBooleanValue("IsHiddenContainer"))
                    System.out.println("Folder "+ name + " is hidden");
                if(!subFolder.get_SubFolders().isEmpty()){
                    JSONArray folderParent = new JSONArray();
                    JSONObject object = new JSONObject();
                    i+=" ";
                    getHierarchy(subFolder.get_PathName(), i, object);
                    folderParent.add(object);
                }

            }
            DocumentSet documents = folderOj.get_ContainedDocuments();
            Iterator itDoc = documents.iterator();
            JSONArray doc = new JSONArray();
            while(itDoc.hasNext()) {
                Document retrieveDoc = (Document) itDoc.next();
                String name = retrieveDoc.get_Name();
                doc.add("DocParrent: " + name);
                System.out.println(i + "APDocument: " + name);
            }
            obj.put("DocParents", doc);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
