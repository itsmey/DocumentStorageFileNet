package ru.bikert.fileNet.operationUI;

import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class CreateOperationUI extends OperationUI{

    public CreateOperationUI() {
        super(UIConstants.NameOperation.СREATE, UIConstants.NameOperation.СREATE);
    }

    @Override
    public JSONObject perform(HttpServletRequest req) {
        ObjectStore objStore = getOS();
        Folder folder = DocumentFileNet.getCurrentFolder();
        switch (folder.get_FolderName()){
            case UIConstants.DocumentClass.ORDER:
                orderCreate(folder, req , objStore);
            case UIConstants.DocumentClass.CONTRACT:
                contractCreate(folder, req, objStore);
            case UIConstants.DocumentClass.STATEMENTS:
                statementsCreate(folder, req,objStore);
        }
        return null;
    }
    private void orderCreate(Folder folder, HttpServletRequest req, ObjectStore os){

        String name = req.getParameter("name");
        String path = folder.get_PathName();
        Document doc = Factory.Document.createInstance(os, UIConstants.DocumentClass.ORDER);
        doc = setProperty(name,doc);
        doc.save(RefreshMode.NO_REFRESH);

        Folder container = Factory.Folder.getInstance(os, OperationHelper.get_Folder(UIConstants.FolderNames.ORDER).getClassName(), path);
        ReferentialContainmentRelationship drcr = container.file(
                doc,
                AutoUniqueName.AUTO_UNIQUE,
                name,
                DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
        drcr.save(RefreshMode.NO_REFRESH);
    }

    private void contractCreate(Folder folder, HttpServletRequest req, ObjectStore objStore){
        String name = req.getParameter("name");
        String counterpartName = "counterparty 1";
        String path = folder.get_PathName();
        Document doc = Factory.Document.createInstance(objStore, UIConstants.DocumentClass.CONTRACT);
        doc = setProperty(name,doc);
        doc.getProperties().putValue(UIConstants.PropertyFileNet.Counterparty, counterpartName);
        doc.save(RefreshMode.NO_REFRESH);

        Folder container = Factory.Folder.getInstance(objStore, OperationHelper.get_Folder(UIConstants.FolderNames.CONTRACT).getClassName(), path);
        ReferentialContainmentRelationship drcr = container.file(
                doc,
                AutoUniqueName.AUTO_UNIQUE,
                name,
                DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
        drcr.save(RefreshMode.NO_REFRESH);
    }

    private void statementsCreate(Folder folder, HttpServletRequest req, ObjectStore objStore){
        String name = req.getParameter("name");
        String path = folder.get_PathName();
        Document doc = Factory.Document.createInstance(objStore, UIConstants.DocumentClass.STATEMENTS);
        doc = setProperty(name,doc);
        doc.getProperties().putValue(UIConstants.PropertyFileNet.receiptDate, new Date());
        doc.save(RefreshMode.NO_REFRESH);

        Folder container = Factory.Folder.getInstance(objStore, OperationHelper.get_Folder(UIConstants.FolderNames.STATEMENTS).getClassName(), path);
        ReferentialContainmentRelationship drcr = container.file(
                doc,
                AutoUniqueName.AUTO_UNIQUE,
                name,
                DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
        drcr.save(RefreshMode.NO_REFRESH);
    }
    private Document setProperty(String name, Document doc){
        doc.getProperties().putValue(UIConstants.PropertyFileNet.dateApproval, new Date());
        doc.getProperties().putValue(UIConstants.PropertyFileNet.documentStatus, OperationHelper.get_DocumentStatus(0));
        doc.getProperties().putValue(UIConstants.PropertyFileNet.numberDocument, OperationHelper.get_EAN13());
        doc.getProperties().putValue(UIConstants.PropertyFileNet.Responsible,DocumentFileNet.getCurrentEmployee());
        doc.getProperties().putValue(UIConstants.PropertyFileNet.DocumentTitle, name);
        return doc;
    }

}
