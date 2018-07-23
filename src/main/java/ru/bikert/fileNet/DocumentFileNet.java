package ru.bikert.fileNet;

import com.filenet.api.core.Folder;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.exception.EngineRuntimeException;

import com.filenet.api.property.Property;
import com.filenet.apiimpl.core.ReferentialContainmentRelationshipImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.bikert.fileNet.TypeContainable.APDocument;
import ru.bikert.fileNet.fileNetConnect.Connect;
import ru.bikert.fileNet.operations.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DocumentFileNet {

    private static Logger logger = LoggerFactory.getLogger(DocumentFileNet.class);
    private static List<Operation> operations = new ArrayList<Operation>();

    private static boolean exit = true;
    private static String input;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<String> arguments = new ArrayList<String>();
    private static ObjectStore os;
    private static Folder currentFolder;



    private static IndependentObject currentEmployee;




    public static void main(String[] args) throws Exception {

        try {
            Connect fileNet = new Connect();
            fileNet.connect();
            os = Connect.getObjectStore();
            currentFolder = os.get_RootFolder();
            myRootFolder();

            ReplaceEmployee.retrieving();
            ReplaceEmployee.replace();
           // TrafficDocument trafficDocument = new TrafficDocument();
           // trafficDocument.trafficStatus(OperationHelper.get_Document("Order6","/Программа адаптации/приказы" ));
           // AddContent addContent = new AddContent();
           // addContent.setDoc("C:\\Users\\ebikert\\Documents\\work\\System_events_Filenet.docx", "/Программа адаптации/приказы", "Order6");
            RetrievingDocumentContent.retrievingContent("/Программа адаптации/приказы/Order6");


            operations.add(new FolderCreateOperation());
            operations.add(new DocumentCreateOperation());
            operations.add(new HelpOperation());
            operations.add(new GoToOperation());
            operations.add(new PrintHierarchyOperation());
            operations.add(new GoToParentOperation());
            operations.add(new PrintCurrentOperation());
            operations.add(new DeliteOperation());
            operations.add(new ExitOperation());
            operations.add(new CreateOrderOperation());

            new HelpOperation().perform(arguments);

            while (exit) {
                System.out.println("\n" + currentFolder.get_PathName());
                System.out.println(currentEmployee.getProperties().get("FullName").getStringValue());

                input = bufferedReader.readLine();
                String[] line = input.split("\\s");
                for (int i = 1; i < line.length; i++) {
                    arguments.add(line[i]);
                }
                for (Operation op : operations) {
                    if (op.getTitle().equals(line[0])) {
                        System.out.println("perform " + op.getTitle() + " with arguments " + arguments);
                        op.perform(arguments);
                    }
                }
                arguments.clear();
            }

        } catch (EngineRuntimeException ex) {
            System.out.println(ex.toString());
            throw new Exception(ex.getExceptionCode().toString());
        } finally {
            Connect.getUserContext().popSubject();
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

    public static void setExit(boolean exit) { DocumentFileNet.exit = exit; }

    public static void setCurrentEmployee(IndependentObject currentEmployee) { DocumentFileNet.currentEmployee = currentEmployee; }

    public static IndependentObject getCurrentEmployee() { return currentEmployee; }


    private static void myRootFolder(){
        if(!OperationHelper.folder("Программа адаптации", os.get_RootFolder())){
            new FolderCreateOperation().createRootFolder("Программа адаптации");
        }
        arguments.add("Программа адаптации");
        new GoToOperation().perform(arguments);
        arguments.clear();
        String[] name = {"приказы", "договоры", "заявления", "cотрудники"};
        for (String s: name) {
            if(!OperationHelper.folder(s,currentFolder)){
                new FolderCreateOperation().createRootFolder(s);
            }
        }

    }

}
