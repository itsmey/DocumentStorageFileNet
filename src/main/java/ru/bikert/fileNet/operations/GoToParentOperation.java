package ru.bikert.fileNet.operations;

import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.io.IOException;
import java.util.List;

public class GoToParentOperation extends Operation {

    public GoToParentOperation() {
        super(Constants.OperationNames.GO_TO_PARENT, "", Constants.OperationDescription.GO_TO_PARENT);
    }

    public void perform(List<String> arguments) {
        if ((DocumentFileNet.getCurrentFolder().get_PathName()).equals("/")) {
            System.out.println(Constants.OperationErrors.NOT_A_PARENT);
            return;
        }
        String path = DocumentFileNet.getCurrentFolder().get_Parent().get_PathName();
        Folder f = Factory.Folder.fetchInstance(Connect.getObjectStore(),path, null);

        DocumentFileNet.setCurrentFolder(f);
        System.out.println(f);

    }
}
