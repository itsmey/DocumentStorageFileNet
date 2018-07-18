package ru.bikert.fileNet.operations;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.io.IOException;
import java.util.List;

public class FolderCreateOperation extends Operation {

    ObjectStore os = Connect.getObjectStore();

    public FolderCreateOperation() {
        super(Constants.OperationNames.FOLDER_CREATE, "<name>", Constants.OperationDescription.FOLDER_CREATE);
    }

    public void perform(List<String> arguments) {
        System.out.println(FolderCreateOperation.class);
        if (arguments.size() > 0) {
            Folder newFolder = Factory.Folder.createInstance(os, null);
            newFolder.set_Parent(DocumentFileNet.getCurrentFolder());
            newFolder.set_FolderName(arguments.get(0));
            newFolder.save(RefreshMode.NO_REFRESH);
            System.out.println("Folder is create");
        } else System.out.println(Constants.OperationErrors.NULL_NAME);
    }
}
