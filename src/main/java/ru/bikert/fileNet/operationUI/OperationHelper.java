package ru.bikert.fileNet.operationUI;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OperationHelper {
    private static List<String> documentStatus = new LinkedList<String>();

    public static Boolean folder(String name, Folder currentFolder){
        Iterator it = currentFolder.get_SubFolders().iterator();
        while (it.hasNext()){
            Folder folder = (Folder) it.next();
            if(folder.get_FolderName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public static Folder get_Folder(String name){
        Iterator it = DocumentFileNet.getCurrentFolder().get_SubFolders().iterator();
        while (it.hasNext()){
            Folder folder = (Folder) it.next();
            if(folder.get_FolderName().equals(name)){
                return folder;
            }
        }
        return null;
    }

    public static Document get_Document(String name, String path){
        Connect connect = new Connect();
        try {
            connect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Folder folderOj= Factory.Folder.fetchInstance(connect.getObjectStore(), path, null);
        DocumentSet documents = folderOj.get_ContainedDocuments();
        Iterator itDoc = documents.iterator();
        while(itDoc.hasNext()) {
            Document document = (Document) itDoc.next();
           if (document.get_Name().equals(name))
            return document;
        }
        System.out.println("Document not filed");
        return null;
    }

    public static long get_EAN13 (){
        return 469000000 + ((int)(Math.random() * 100000));
    }

    public static String get_DocumentStatus(int i){
        documentStatus.add("На ознакомлении");
        documentStatus.add("На утверждении");
        documentStatus.add("Утвержден");
        return documentStatus.get(i);
    }

}
