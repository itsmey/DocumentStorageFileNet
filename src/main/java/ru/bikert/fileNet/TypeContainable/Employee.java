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
import com.filenet.api.core.*;
import com.filenet.api.property.PropertyFilter;
import ru.bikert.fileNet.fileNetConnect.Connect;


public class Employee {
    public  void EmployeeCreate() {
//        String strClassName = "Employee";
//        ObjectStore objObjectStore = Connect.getObjectStore();
//        String strTemplateName = "FullName";
//
//        //Factory.ClassDefinition.fetchInstance для извлечения объекта ClassDefinition, который определяет класс CustomObject.
//        ClassDefinition objClassDefCO = Factory.ClassDefinition.fetchInstance(objObjectStore, GuidConstants.Class_CustomObject, null);
//
//        ClassDefinition objClassDefCOSub = objClassDefCO.createSubclass();
//
//        LocalizedString objLocStrCD = Factory.LocalizedString.createInstance();
//        objLocStrCD.set_LocalizedText(strClassName);
//        objLocStrCD.set_LocaleName(objObjectStore.get_LocaleName());
//
//        objClassDefCOSub.set_DisplayNames(Factory.LocalizedString.createList());
//        objClassDefCOSub.get_DisplayNames().add(objLocStrCD);
//
//        objClassDefCOSub.save(RefreshMode.REFRESH);
//        System.out.println("New CustomObject subclass: " + objClassDefCOSub.get_Name());
//        System.out.println(objClassDefCOSub);
//
//        PropertyFilter pf = new PropertyFilter();
//        pf.addIncludeType(0, null, Boolean.TRUE, FilteredPropertyType.ANY, null);
//
//        PropertyTemplateString objPropTemplate = Factory.PropertyTemplateString.createInstance(objObjectStore);
//        objPropTemplate.set_Cardinality(Cardinality.SINGLE);
//        LocalizedString objLocStrPT = Factory.LocalizedString.createInstance();
//        objLocStrPT.set_LocalizedText(strTemplateName);
//        objLocStrPT.set_LocaleName(objObjectStore.get_LocaleName());
//        objPropTemplate.set_DisplayNames(Factory.LocalizedString.createList());
//        objPropTemplate.get_DisplayNames().add(objLocStrPT);
//        objPropTemplate.save(RefreshMode.REFRESH);
//        PropertyDefinitionString objPropDef = (PropertyDefinitionString) objPropTemplate.createClassProperty();
//        objPropDef.set_IsNameProperty(true);
//        PropertyDefinitionList objPropDefs = objClassDefCOSub.get_PropertyDefinitions();
//        objPropDefs.add(objPropDef);
//        objClassDefCOSub.save(RefreshMode.REFRESH);
//
//        System.out.println(objPropDef);
    }
}