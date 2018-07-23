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

public class CreateContractOperation extends Operation {

    private static ObjectStore os = Connect.getObjectStore();

    public CreateContractOperation() {
        super(Constants.OperationNames.CONTRACT_CREATE, "", Constants.OperationDescription.CONTRACT_CREATE);
    }

    public void perform(List<String> arguments) {
            String name = "Contract" + (int)(Math.random() * 100);
            String counterpartyName = "counterparty 1";
            String path = OperationHelper.get_Folder(Constants.FolderNames.CONTRACT).get_PathName();
            Document doc = Factory.Document.createInstance(os, "Contract");

            doc.getProperties().putValue(Constants.PropertyFileNet.dateApproval, new Date());
            doc.getProperties().putValue(Constants.PropertyFileNet.documentStatus, OperationHelper.get_DocumentStatus(0));
            doc.getProperties().putValue(Constants.PropertyFileNet.numberDocument, OperationHelper.get_EAN13());
            doc.getProperties().putValue(Constants.PropertyFileNet.Responsible,DocumentFileNet.getCurrentEmployee());
            doc.getProperties().putValue(Constants.PropertyFileNet.Counterparty, counterpartyName);
            doc.getProperties().putValue("DocumentTitle", name);

            doc.save(RefreshMode.NO_REFRESH);
            Folder container = Factory.Folder.getInstance(os, OperationHelper.get_Folder(Constants.FolderNames.ORDER).getClassName(), path);
            ReferentialContainmentRelationship drcr = container.file(
                    doc,
                    AutoUniqueName.NOT_AUTO_UNIQUE,
                    name,
                    DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
            drcr.save(RefreshMode.NO_REFRESH);
            System.out.println(name + "is create");
    }
}
