package ru.bikert.fileNet.operationUI;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.core.*;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Printer;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

public class PrintHierarchyOperation extends OperationUI {
    private  ObjectStore objStore;

    public PrintHierarchyOperation() {
        super("", "");
    }

    public void printHierarchy(Printer printer){
        objStore = getOS();
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

    @Override
    public JSONObject perform(HttpServletRequest req) throws Exception {
        return null;
    }
}
