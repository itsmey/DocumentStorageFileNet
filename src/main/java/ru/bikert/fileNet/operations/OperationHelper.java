package ru.bikert.fileNet.operations;

import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;

public class OperationHelper {

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
}
