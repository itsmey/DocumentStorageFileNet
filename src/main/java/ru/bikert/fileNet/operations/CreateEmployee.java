package ru.bikert.fileNet.operations;


import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import com.filenet.api.property.Properties;

import com.filenet.apiimpl.core.DocumentImpl;
import ru.bikert.fileNet.fileNetConnect.Connect;

public class CreateEmployee {
//    private static ObjectStore os = Connect.getObjectStore();
//
//
//    public void create(String fullName){
//        CustomObject myObject = Factory.CustomObject.createInstance(os,"Employee");
//        Properties props = myObject.getProperties();
//        props.putValue("FullName",fullName);
//        myObject.save(RefreshMode.REFRESH);
//        System.out.println("Customobject " + myObject.get_Name() + " created");
//
//        //Saving the Custome Object into folder
//        String folder= "/Программа адаптации/cотрудники/";
//        com.filenet.api.core.Folder folderOj= Factory.Folder.fetchInstance(os,folder, null);
//        ReferentialContainmentRelationship rel = folderOj.file(myObject,AutoUniqueName.AUTO_UNIQUE,null,DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
//        rel.save(RefreshMode.REFRESH);
//    }
}
