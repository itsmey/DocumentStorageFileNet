package ru.bikert.fileNet.operations;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;

import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;
import java.util.List;

public class PrintCurrentOperation extends Operation {

    public PrintCurrentOperation() {
        super(Constants.OperationNames.CURRENT_PRINT, "", Constants.OperationDescription.CURRENT_PRINT);
    }

    public void perform(List<String> arguments) {
        ObjectStore objStore = Connect.getObjectStore();
        String path = DocumentFileNet.getPath();
        Folder folderOj= Factory.Folder.fetchInstance(objStore, path, null);
        DocumentSet documents = folderOj.get_ContainedDocuments();
        Iterator itDoc = documents.iterator();
        while(itDoc.hasNext()) {
            Document retrieveDoc = (Document) itDoc.next();
            String name = retrieveDoc.get_Name();
            System.out.println("Document: " + name);
        }
        FolderSet subFolders= folderOj.get_SubFolders();
        Iterator it = subFolders.iterator();
        while(it.hasNext()){
            Folder subFolder= (Folder) it.next();
            String name = (subFolder).get_FolderName();
            System.out.println(name);
        }
    }
}
