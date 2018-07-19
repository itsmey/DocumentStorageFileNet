package ru.bikert.fileNet.TypeContainable;

import com.filenet.api.core.Document;

import java.awt.*;
import java.util.Date;


public abstract class APDocument implements Document {

    Choice documentStatus = new Choice();
    Employee Responsible;
    Date dateApproval;
    Long numberDocument;


    private void setDocumentStatus(){
        documentStatus.add("На ознакомлении");
        documentStatus.add("На утверждении");
        documentStatus.add("Утвержден");
    }
}
