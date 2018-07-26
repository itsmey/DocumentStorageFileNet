package ru.bikert.fileNet.operationUI;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.fileNetConnect.Connect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintDocumentOperationUI extends OperationUI {
    public List<Document> documentsSet = new ArrayList<>();


    public PrintDocumentOperationUI() {
        super("", "");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        perform(request);
        for (Document d: documentsSet) {
            writer.append("<li class=\"document\">"+d.get_Name()+"</li>");
        }

    }

    @Override
    public JSONObject perform(HttpServletRequest req) {
        ObjectStore objStore = getOS();
        String path = DocumentFileNet.getPath();
        Folder folderOj= Factory.Folder.fetchInstance(objStore, path, null);
        DocumentSet documents = folderOj.get_ContainedDocuments();
        Iterator itDoc = documents.iterator();
        while(itDoc.hasNext()) {
            Document retrieveDoc = (Document) itDoc.next();
            String name = retrieveDoc.get_Name();
            documentsSet.add(retrieveDoc);
            System.out.println("APDocument: " + name);
        }
        return null;
    }
}
