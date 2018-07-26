package ru.bikert.fileNet.TypeContainable;

import com.filenet.api.admin.*;
import com.filenet.api.collection.PropertyDefinitionList;
import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.FilteredPropertyType;
import com.filenet.api.constants.GuidConstants;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Property;
import com.filenet.api.property.PropertyFilter;
import com.filenet.apiimpl.core.PropertyDefinitionObjectImpl;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.awt.*;
import java.awt.Choice;
import java.util.Date;


public class APDocument {

    private static String strClassName = "APDocument";
   // private static ObjectStore objObjectStore = Connect.getObjectStore();
    private static Choice documentStatus = new Choice();
    private static Employee Responsible;
    private static Date dateApproval;
    private static Long numberDocument;


    private void setDocumentStatus(){
        documentStatus.add("На ознакомлении");
        documentStatus.add("На утверждении");
        documentStatus.add("Утвержден");
    }
//    public static void createAPDocument(){
//        ClassDefinition classDefinition = Factory.ClassDefinition.fetchInstance(objObjectStore, GuidConstants.Class_Document, null);
//        ClassDefinition classDefinitionSub = classDefinition.createSubclass();
//
//        LocalizedString localizedString = Factory.LocalizedString.createInstance();
//        localizedString.set_LocalizedText(strClassName);
//        localizedString.set_LocaleName(objObjectStore.get_Name());
//
//        classDefinitionSub.set_DisplayNames(Factory.LocalizedString.createList());
//        classDefinitionSub.get_DisplayNames().add(localizedString);
//
//        classDefinitionSub.save(RefreshMode.REFRESH);
//        System.out.println("New CustomObject subclass: " + classDefinitionSub.get_Name());
//        System.out.println(classDefinitionSub);
//    }
//    public static void addProperty(){
//        ClassDefinition myClass = APDocument.getFolder();
//
//        PropertyFilter pf = new PropertyFilter();
//        pf.addIncludeType(0, null, Boolean.TRUE, FilteredPropertyType.ANY, null);
//
//        PropertyTemplateObject newProperty = Factory.PropertyTemplateObject.createInstance(objObjectStore);
//        newProperty.set_Cardinality(Cardinality.SINGLE);
//
//        LocalizedString objLocStrPT = Factory.LocalizedString.createInstance();
//
//        objLocStrPT.set_LocalizedText("Responsible");
//        objLocStrPT.set_LocaleName(objObjectStore.get_LocaleName());
//
//        newProperty.set_DisplayNames(Factory.LocalizedString.createList());
//        newProperty.get_DisplayNames().add(objLocStrPT);
//        newProperty.save(RefreshMode.REFRESH);
//
//        PropertyDefinitionObjectImpl objPropDef = (PropertyDefinitionObjectImpl) newProperty.createClassProperty();
//        objPropDef.set_IsNameProperty(true);
//        PropertyDefinitionList objPropDefs = myClass.get_PropertyDefinitions();
//        objPropDefs.add(objPropDef);
//        myClass.save(RefreshMode.REFRESH);
//
//        System.out.println(objPropDef);
//
//    }
//    public static ClassDefinition getFolder(){
//        ClassDefinition myClass = Factory.ClassDefinition.fetchInstance(objObjectStore,"{40B1B664-0000-C111-957A-7F0D9B0DBB87}", null);
//        System.out.println(myClass.get_Name());
//        return myClass;
//    }
}
