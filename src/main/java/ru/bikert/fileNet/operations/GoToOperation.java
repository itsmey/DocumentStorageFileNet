package ru.bikert.fileNet.operations;

import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;

import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Iterator;
import java.util.List;

public class GoToOperation extends Operation {

    public GoToOperation() {
        super(Constants.OperationNames.DOTO, "<name>", Constants.OperationDescription.GO_TO_PARENT);
    }

    @Override
    public void perform(List<String> arguments) {
        String path = DocumentFileNet.getPath() + "/" +arguments.get(0);
            if(OperationHelper.folder(arguments.get(0), DocumentFileNet.getCurrentFolder())){
                Folder f = Factory.Folder.fetchInstance(Connect.getObjectStore(),path, null);
                DocumentFileNet.setCurrentFolder(f);
                System.out.println(f);
                return;
            }
        System.out.println(Constants.OperationErrors.NOT_A_PARENT);
    }
}
