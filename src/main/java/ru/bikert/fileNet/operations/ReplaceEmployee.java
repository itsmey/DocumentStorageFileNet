package ru.bikert.fileNet.operations;

import com.filenet.api.collection.ReferentialContainmentRelationshipSet;
import com.filenet.api.core.*;
import com.filenet.apiimpl.core.ReferentialContainmentRelationshipImpl;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReplaceEmployee extends Operation {

    private static List< ReferentialContainmentRelationshipImpl> employee = new ArrayList< ReferentialContainmentRelationshipImpl>();

    public ReplaceEmployee() {
        super("replace", "", "Replace Employee random");
    }

    public static void retrieving(){

        Folder folderOj= Factory.Folder.fetchInstance(Connect.getObjectStore(), "/Программа адаптации/cотрудники", null);
        ReferentialContainmentRelationshipSet relationship = folderOj.get_Containees();
        if (relationship.isEmpty()){
            createEmployee();
            relationship = folderOj.get_Containees();
        }
        Iterator iterator = relationship.iterator();
        while (iterator.hasNext()){
            ReferentialContainmentRelationshipImpl o = (ReferentialContainmentRelationshipImpl) iterator.next();
            setEmployee(o);
        }

    }

    public static void replace(){
        DocumentFileNet.setCurrentEmplouee(employee.get((int) Math.random() * employee.size()));
    }

    public static void setEmployee( ReferentialContainmentRelationshipImpl employee) {
        ReplaceEmployee.employee.add(employee);
    }

    public void perform(List<String> arguments) {
        DocumentFileNet.setCurrentEmplouee(employee.get((int) Math.random() * employee.size()));
    }

    public static void createEmployee(){
        String[] nameEmloyee = {"Senior", "Junior", "Middle"};
        for (String s:nameEmloyee) {
            CreateEmployee createEmployee = new CreateEmployee();
            createEmployee.create(s);
        }
    }
}
