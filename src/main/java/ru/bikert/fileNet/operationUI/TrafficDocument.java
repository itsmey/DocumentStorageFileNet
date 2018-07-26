package ru.bikert.fileNet.operationUI;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.IndependentObject;
import ru.bikert.fileNet.DocumentFileNet;

public class TrafficDocument {
    public void trafficStatus(Document doc) {
        if (utensils(doc)) {
            String docStatus = doc.getProperties().get(UIConstants.PropertyFileNet.documentStatus).getStringValue();
            if (docStatus.equals("На ознакомлении")) {
                doc.getProperties().putValue(UIConstants.PropertyFileNet.documentStatus, "На утверждении");
            } else if (docStatus.equals("На утверждении")) {
                doc.getProperties().putValue(UIConstants.PropertyFileNet.documentStatus, "Утвержден");
            } else System.out.println("error!!! Document status is " + docStatus);
            doc.save(RefreshMode.NO_REFRESH);
        } else System.out.println("Error Employee is ");
    }

    public Boolean utensils(Document doc){
        IndependentObject independentObject = (IndependentObject) doc.getProperties().get(UIConstants.PropertyFileNet.Responsible).getEngineObjectValue();
        if (independentObject.getProperties().get("FullName").getStringValue().equals(DocumentFileNet.getCurrentEmployee().getProperties().get("FullName").getStringValue())){
            System.out.println("Employee is " + independentObject.getProperties().get("FullName").getStringValue());
            return true;
        }
        System.out.println("Error Employee is " + independentObject.getProperties().get("FullName").getStringValue());
        return false;
    }


}
