package ru.bikert.fileNet.operations;

import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.Date;
import java.util.List;

public class CreateOrderOperation extends Operation {
    private static ObjectStore os = Connect.getObjectStore();
    public CreateOrderOperation() {
        super(Constants.OperationNames.ORDER_CREATE, "", Constants.OperationDescription.ORDER_CREATE);
    }

    public void perform(List<String> arguments) {
        String path = OperationHelper.get_Folder(Constants.FolderNames.ORDER).get_PathName();
        Document doc = Factory.Document.createInstance(os, "{B094B764-0000-C11F-A7FA-6B075B90C1B8}");

        doc.getProperties().putValue(Constants.PropertyFileNet.dateApproval, new Date());
        doc.getProperties().putValue(Constants.PropertyFileNet.documentStatus, "yf endth;ltybb");
        doc.getProperties().putValue(Constants.PropertyFileNet.numberDocument, 22.5);
        doc.getProperties().putValue(Constants.PropertyFileNet.Responsible, DocumentFileNet.getCurrentEmployee());

        doc.save(RefreshMode.NO_REFRESH);
        Folder container = Factory.Folder.getInstance(os, OperationHelper.get_Folder(Constants.FolderNames.ORDER).getClassName(), path);
        ReferentialContainmentRelationship drcr = container.file(
                doc,
                AutoUniqueName.NOT_AUTO_UNIQUE,
                arguments.get(0),
                DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
        drcr.save(RefreshMode.NO_REFRESH);
    }

}
