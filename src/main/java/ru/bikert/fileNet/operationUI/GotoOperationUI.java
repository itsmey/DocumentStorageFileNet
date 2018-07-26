package ru.bikert.fileNet.operationUI;

import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.DocumentFileNet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        String path = Helper.getBody(req);
        Folder f = Factory.Folder.fetchInstance(getOS(),path, null);
        DocumentFileNet.setCurrentFolder(f);
        PrintDocumentOperationUI printCurrentOperation = new PrintDocumentOperationUI();
        return printCurrentOperation.perform(req);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JSONObject result = perform(request);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append(result.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
