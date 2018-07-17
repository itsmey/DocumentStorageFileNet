package ru.bikert.fileNet;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.collection.PageIterator;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.apiimpl.core.SubSetImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bikert.fileNet.fileNetConnect.Connect;
import ru.bikert.fileNet.operations.DocumentCreateOperation;
import ru.bikert.fileNet.operations.FolderCreateOperation;
import ru.bikert.fileNet.operations.GoToOperation;
import ru.bikert.fileNet.operations.HelpOperation;
import sun.security.pkcs11.wrapper.Constants;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DocumentFileNet {

    private static Logger logger = LoggerFactory.getLogger(DocumentFileNet.class);
    private static List<Operation> operations = new ArrayList<Operation>();
    private static boolean exit = true;
    private static String input;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<String> arguments = new ArrayList<String>();
    private static FolderSet folders;
    private static ObjectStore os;
    private static Folder currentFolder;
    private static String path = "/";




    public static void main(String[] args) throws Exception {

        try {
            Connect fileNet = new Connect();
            fileNet.connect();
            os = Connect.getObjectStore();
            currentFolder = os.get_RootFolder();


            operations.add(new FolderCreateOperation());
            operations.add(new DocumentCreateOperation());
            operations.add(new HelpOperation());
            operations.add(new GoToOperation());

            //System.out.println(os.get_RootFolder().get_PathName());
            DocumentSet documentSet = currentFolder.get_ContainedDocuments();
           // System.out.println(documentSet.pageIterator().getElementCount());
//            while (documentSet.pageIterator().nextPage()){
//                System.out.println(documentSet.pageIterator().getPageSize());
//            }

            new HelpOperation().perform(arguments);
            while (exit) {
                System.out.println("go...");
                System.out.println(currentFolder.get_PathName());
                input = bufferedReader.readLine();
                String[] line = input.split("\\s");
                for (int i = 1; i < line.length; i++) {
                    arguments.add(line[i]);
                }
                for (Operation op : operations) {
                    if (op.getTitle().equals(line[0])) {
                        System.out.println("perform " + op.getTitle() + " with arguments " + arguments);
                        op.perform(arguments);
                        arguments.clear();
                    }
                }
            }
        } catch (EngineRuntimeException ex) {
            System.out.println(ex.toString());
            throw new Exception(ex.getExceptionCode().toString());
        } finally {
            Connect.getUserContext().popSubject();
        }
    }
    public static Folder getCurrentFolder() {
        return currentFolder;
    }
    public static List<Operation> getOperation(){
        return operations;
    }
    public static String getPath() {
        return path;
    }
    public static void setCurrentFolder(Folder currentFolder) {
        DocumentFileNet.currentFolder = currentFolder;
    }
}
