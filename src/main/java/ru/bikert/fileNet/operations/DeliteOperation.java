package ru.bikert.fileNet.operations;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.List;

public class DeliteOperation {

//    public DeliteOperation() {
//        super(Constants.OperationNames.DELETE, "name", Constants.OperationDescription.DELETE);
//    }

//    public void perform(List<String> arguments) {
//        String path = DocumentFileNet.getCurrentFolder().get_PathName() + "/" + arguments.get(0);
//        if(OperationHelper.folder(arguments.get(0), DocumentFileNet.getCurrentFolder())){
//            Folder f = Factory.Folder.fetchInstance(Connect.getObjectStore(),path, null);
//            f.delete();
//            f.save(RefreshMode.NO_REFRESH);
//            System.out.println(f.get_PathName()+"is Delited");
//        } else System.out.println(Constants.OperationErrors.NOT_A_PARENT);
//
//    }
}
