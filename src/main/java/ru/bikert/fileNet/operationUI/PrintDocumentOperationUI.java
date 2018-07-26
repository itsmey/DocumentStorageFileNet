package ru.bikert.fileNet.operationUI;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
        writer.append(perform(request).toJSONString());
        perform(request);
    }

    @Override
    public JSONObject perform(HttpServletRequest req) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        ObjectStore objStore = getOS();
        JSONObject result = new JSONObject();
        String path = DocumentFileNet.getPath();
        Folder folderOj= Factory.Folder.fetchInstance(objStore, path, null);
        result.put("parent", folderOj.get_FolderName());
        result.put("path", folderOj.get_PathName());
        JSONArray children = new JSONArray();
        DocumentSet documents = folderOj.get_ContainedDocuments();
        Iterator itDoc = documents.iterator();
        while(itDoc.hasNext()) {
            Document retrieveDoc = (Document) itDoc.next();
            IndependentObject employee = (IndependentObject)retrieveDoc.getProperties().get(UIConstants.PropertyFileNet.Responsible).getObjectValue();
            JSONObject child = new JSONObject();
            if (employee != null){
                employee.getProperties().get("FullName").getStringValue();
                child.put(UIConstants.PropertyFileNet.Responsible, employee.getProperties().get("FullName").getStringValue());
            }

            child.put("name", retrieveDoc.get_Name());
            child.put("class", retrieveDoc.getClassName());
            child.put(UIConstants.PropertyFileNet.dateApproval, dateFormat.format(retrieveDoc.getProperties().get(UIConstants.PropertyFileNet.dateApproval).getDateTimeValue()));
            child.put(UIConstants.PropertyFileNet.documentStatus, retrieveDoc.getProperties().get(UIConstants.PropertyFileNet.documentStatus).getStringValue());
            child.put(UIConstants.PropertyFileNet.numberDocument, retrieveDoc.getProperties().get(UIConstants.PropertyFileNet.numberDocument).getFloat64Value());
            children.add(child);
            documentsSet.add(retrieveDoc);
        }
        result.put("children", children);
        return result;
    }
}
