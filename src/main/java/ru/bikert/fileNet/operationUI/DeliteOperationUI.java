package ru.bikert.fileNet.operationUI;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.fileNetConnect.Connect;
import ru.bikert.fileNet.operations.OperationHelper;

import javax.servlet.http.HttpServletRequest;

public class DeliteOperationUI extends OperationUI {

    public DeliteOperationUI() {
        super(UIConstants.NameOperation.DELETE, UIConstants.KeyOperation.DELETE);
    }

    @Override
    public void perform(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        String path = DocumentFileNet.getCurrentFolder().get_PathName() + "/" + name;
        if(OperationHelper.folder(name, DocumentFileNet.getCurrentFolder())){
            Folder f = Factory.Folder.fetchInstance(getOS(),path, null);
            f.delete();
            f.save(RefreshMode.NO_REFRESH);
        }
    }
}
