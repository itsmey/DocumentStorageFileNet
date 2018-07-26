package ru.bikert.fileNet.operations;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.core.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.Printer;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;
import java.util.List;

public class PrintHierarchyOperation extends Operation {
    private static ObjectStore objStore;

    public PrintHierarchyOperation() {
        super(Constants.OperationNames.PRINT, " ", Constants.OperationDescription.PRINT);
    }

    public void perform(List<String> arguments) {
    }
    public static void printHierarchy(Printer printer){
        Connect conn = new Connect();
        try {
            conn.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        objStore = conn.getObjectStore();
        String path = DocumentFileNet.rootFolder.get_PathName();
        printHierarchy(path, objStore, printer);
    }

    public static void printHierarchy(String path, ObjectStore objectStore, Printer printer) {
        printer.printOpenUlTag();

        try {
            Folder folderOj= Factory.Folder.fetchInstance(objectStore, path, null);
            FolderSet subFolders= folderOj.get_SubFolders();
            Iterator it = subFolders.iterator();
            while(it.hasNext()){
                Folder subFolder= (Folder) it.next();
                String name = (subFolder).get_FolderName();
                printer.printString("<li onclick=\"goTo('"+ subFolder.get_PathName() +"');\">");
                printer.printString(name);
                if(!subFolder.get_SubFolders().isEmpty() || !subFolder.get_ContainedDocuments().isEmpty()){
                    printHierarchy(subFolder.get_PathName(),objectStore, printer);
                }
                printer.printCloseLiTag();

            }
            DocumentSet documents = folderOj.get_ContainedDocuments();
            Iterator itDoc = documents.iterator();
            while(itDoc.hasNext()) {
                Document retrieveDoc = (Document) itDoc.next();
                String name = retrieveDoc.get_Name();
                printer.printOpenLiTag();
                printer.printString(name);
                printer.printCloseLiTag();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printer.printCloseUlTag();
    }
}
