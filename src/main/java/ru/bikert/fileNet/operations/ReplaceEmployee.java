package ru.bikert.fileNet.operations;

import com.filenet.api.collection.ReferentialContainmentRelationshipSet;
import com.filenet.api.core.*;
import com.filenet.apiimpl.core.ReferentialContainmentRelationshipImpl;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.TypeContainable.Employee;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReplaceEmployee  {

//    private static List<IndependentObject> employee = new ArrayList<IndependentObject>();
//
//    public ReplaceEmployee() {
//        super("replace", "", "Replace Employee random");
//    }
//
//    public static void retrieving(){
//
//        Folder folderOj= Factory.Folder.fetchInstance(Connect.getObjectStore(), "/Программа адаптации/cотрудники", null);
//        ReferentialContainmentRelationshipSet relationship = folderOj.get_Containees();
//        if (relationship.isEmpty()){
//            createEmployee();
//            relationship = folderOj.get_Containees();
//        }
//        Iterator iterator = relationship.iterator();
//        while (iterator.hasNext()){
//            ReferentialContainmentRelationship o = (ReferentialContainmentRelationship) iterator.next();
//            setEmployee(o.get_Head());
//        }
//
//    }
//
//    public static void replace(){
//        //DocumentFileNet.setCurrentEmployee(employee.get((int)(Math.random() * employee.size())));
//        DocumentFileNet.setCurrentEmployee(employee.get(2));
//    }
//
//    public static void setEmployee( IndependentObject employee) {
//        ReplaceEmployee.employee.add(employee);
//    }
//
//    public void perform(List<String> arguments) {
//        DocumentFileNet.setCurrentEmployee(employee.get((int) Math.random() * employee.size()));
//    }
//
//    public static void createEmployee(){
//        String[] nameEmloyee = {"Senior", "Junior", "Middle"};
//        for (String s:nameEmloyee) {
//            CreateEmployee createEmployee = new CreateEmployee();
//            createEmployee.create(s);
//        }
//    }
}
