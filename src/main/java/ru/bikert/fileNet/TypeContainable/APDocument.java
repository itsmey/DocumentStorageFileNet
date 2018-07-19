package ru.bikert.fileNet.TypeContainable;

import com.filenet.api.admin.ClassDefinition;
import com.filenet.api.admin.LocalizedString;
import com.filenet.api.admin.PropertyDefinitionString;
import com.filenet.api.admin.PropertyTemplateString;
import com.filenet.api.collection.PropertyDefinitionList;
import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.FilteredPropertyType;
import com.filenet.api.constants.GuidConstants;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.PropertyFilter;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.awt.*;
import java.util.Date;


public class APDocument {

    String strClassName = "APDocument";
    ObjectStore objObjectStore = Connect.getObjectStore();
    Choice documentStatus = new Choice();
    Employee Responsible;
    Date dateApproval;
    Long numberDocument;


    private void setDocumentStatus(){
        documentStatus.add("На ознакомлении");
        documentStatus.add("На утверждении");
        documentStatus.add("Утвержден");
    }
    public void createAPDocument(){
        ClassDefinition classDefinition = Factory.ClassDefinition.fetchInstance(objObjectStore, GuidConstants.Class_Document, null);
        ClassDefinition classDefinitionSub = classDefinition.createSubclass();

        LocalizedString localizedString = Factory.LocalizedString.createInstance();
        localizedString.set_LocalizedText(strClassName);
        localizedString.set_LocaleName(objObjectStore.get_Name());

        classDefinitionSub.set_DisplayNames(Factory.LocalizedString.createList());
        classDefinitionSub.get_DisplayNames().add(localizedString);

        classDefinitionSub.save(RefreshMode.REFRESH);
        System.out.println("New CustomObject subclass: " + classDefinitionSub.get_Name());
        System.out.println(classDefinitionSub);

        PropertyFilter pf = new PropertyFilter();
        pf.addIncludeType(0, null, Boolean.TRUE, FilteredPropertyType.ANY, null);

    }
}
