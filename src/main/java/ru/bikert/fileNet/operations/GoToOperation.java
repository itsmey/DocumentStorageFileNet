package ru.bikert.fileNet.operations;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.List;

public class GoToOperation extends Operation {

    public GoToOperation() {
        super(Constants.OperationNames.DOTO, "<name>", Constants.OperationDescription.GO_TO_PARENT);
    }

    @Override
    public void perform(List<String> arguments) {
        String path = DocumentFileNet.getPath() + arguments.get(0);
        Folder f = Factory.Folder.fetchInstance(Connect.getObjectStore(),path, null);

        DocumentFileNet.setCurrentFolder(f);
        System.out.println(f);

    }
}
