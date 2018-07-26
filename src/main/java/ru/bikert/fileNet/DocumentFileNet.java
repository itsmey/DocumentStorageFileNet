package ru.bikert.fileNet;

import com.filenet.api.core.Folder;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.exception.EngineRuntimeException;

import ru.bikert.fileNet.fileNetConnect.Connect;
import ru.bikert.fileNet.operationUI.GotoOperationUI;
import ru.bikert.fileNet.operations.*;


import java.util.ArrayList;
import java.util.List;

public class DocumentFileNet {

    private static List<Operation> operations = new ArrayList<Operation>();

    private static List<String> arguments = new ArrayList<String>();
    private static ObjectStore os;
    private static Folder currentFolder;
    public  static Folder rootFolder;
    private Connect fileNet;

    private static IndependentObject currentEmployee;

    public void start() throws Exception {

        try {
            fileNet = new Connect();
            fileNet.connect();
            os = fileNet.getObjectStore();
            currentFolder = os.get_RootFolder();
            rootFolder = myFolder();

           // ReplaceEmployee.retrieving();
           // ReplaceEmployee.replace();
           // TrafficDocument trafficDocument = new TrafficDocument();
           // trafficDocument.trafficStatus(OperationHelper.get_Document("Order6","/Программа адаптации/приказы" ));
           // AddContent addContent = new AddContent();
           // addContent.setDoc("C:\\Users\\ebikert\\Documents\\work\\System_events_Filenet.docx", "/Программа адаптации/приказы", "Order6");
           // RetrievingDocumentContent.retrievingContent("/Программа адаптации/приказы/Order6");

        } catch (EngineRuntimeException ex) {
            System.out.println(ex.toString());
            throw new Exception(ex.getExceptionCode().toString());
        } finally {
            fileNet.getUserContext().popSubject();
            Operation.closeReader();
        }
    }

    public static Folder getCurrentFolder() {
        return currentFolder;
    }

    public static List<Operation> getOperation(){
        return operations;
    }

    public static String getPath() {
        return currentFolder.get_PathName();
    }

    public static void setCurrentFolder(Folder currentFolder) {
        DocumentFileNet.currentFolder = currentFolder;
    }

    public static void setCurrentEmployee(IndependentObject currentEmployee) { DocumentFileNet.currentEmployee = currentEmployee; }

    public static IndependentObject getCurrentEmployee() { return currentEmployee; }


    public Folder myFolder(){
        Folder folder = OperationHelper.get_Folder("Программа адаптации");
        if(folder == null){
            new FolderCreateOperation().createRootFolder("Программа адаптации");
            folder = OperationHelper.get_Folder("Программа адаптации");
        }
        String[] name = {"приказы", "договоры", "заявления", "cотрудники"};
        for (String s: name) {
            if(!OperationHelper.folder(s,currentFolder)){
                new FolderCreateOperation().createRootFolder(s);
            }
        }
        return folder;
    }

}
