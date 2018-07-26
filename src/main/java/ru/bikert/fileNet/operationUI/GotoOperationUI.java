package ru.bikert.fileNet.operationUI;

import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.fileNetConnect.Connect;
import ru.bikert.fileNet.operations.OperationHelper;
import ru.bikert.fileNet.operations.PrintCurrentOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GotoOperationUI extends OperationUI {

    public GotoOperationUI() {
        super("", "");
    }

    public Folder perform (String nameFolder) {
        String path = DocumentFileNet.getPath() + "/" + nameFolder;
        if(OperationHelper.folder(nameFolder, DocumentFileNet.getCurrentFolder())){
            Folder f = Factory.Folder.fetchInstance(getOS(),path, null);
            DocumentFileNet.setCurrentFolder(f);
            return f;
        }
        return null;
    }

    @Override
    public JSONObject perform(HttpServletRequest req) throws Exception {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = Helper.getBody(request);
        Folder f = Factory.Folder.fetchInstance(getOS(),path, null);
        DocumentFileNet.setCurrentFolder(f);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        PrintDocumentOperationUI printCurrentOperation = new PrintDocumentOperationUI();
        printCurrentOperation.perform(request);
        for (Document d:printCurrentOperation.documentsSet) {
            writer.append("<li class=\"document\">"+d.get_Name()+"</li>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Folder f = Factory.Folder.fetchInstance(Connect.getObjectStore(),req.getParameter("path"), null);
        //DocumentFileNet.setCurrentFolder(f);
        req.setAttribute("date", req.getParameter("path"));
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
