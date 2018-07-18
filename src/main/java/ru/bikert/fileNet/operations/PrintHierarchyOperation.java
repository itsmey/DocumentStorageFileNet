package ru.bikert.fileNet.operations;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.core.*;

import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;
import java.util.List;

public class PrintHierarchyOperation extends Operation {
    private static ObjectStore objStore;

    public PrintHierarchyOperation() {
        super(Constants.OperationNames.PRINT, " ", Constants.OperationDescription.PRINT);
    }

    public void perform(List<String> arguments) {
        objStore = Connect.getObjectStore();
        String folder = DocumentFileNet.getPath();

        String i = " ";
        getHierarchy(folder, i);
    }

    private static void getHierarchy(String path, String i){
        try {
            Folder folderOj= Factory.Folder.fetchInstance(objStore, path, null);
            FolderSet subFolders= folderOj.get_SubFolders();
            Iterator it = subFolders.iterator();
            while(it.hasNext()){
                Folder subFolder= (Folder) it.next();
                String name = (subFolder).get_FolderName();
                System.out.println(i + name);

                if(subFolder.getProperties().getBooleanValue("IsHiddenContainer"))
                    System.out.println("Folder "+ name + " is hidden");
                if(!subFolder.get_SubFolders().isEmpty()){
                    i+=" ";
                    getHierarchy(subFolder.get_PathName(), i);
                }
            }
            DocumentSet documents = folderOj.get_ContainedDocuments();
            Iterator itDoc = documents.iterator();
            while(itDoc.hasNext()) {
                Document retrieveDoc = (Document) itDoc.next();
                String name = retrieveDoc.get_Name();
                System.out.println(i + "Document: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
