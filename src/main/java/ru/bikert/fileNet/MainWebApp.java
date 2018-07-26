package ru.bikert.fileNet;

import com.filenet.api.core.Folder;
import ru.bikert.fileNet.operationUI.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainWebApp extends HttpServlet {

    private static List<OperationUI> operationUI = new ArrayList<>();

    private String folder;
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            OperationUI o = new GotoOperationUI();
            try {
                o.perform(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                DocumentFileNet documentFileNet = new DocumentFileNet();
                documentFileNet.start();
                Folder rootFolder = documentFileNet.rootFolder;

            operationUI.clear();
            operationUI.add(new CreateOperationUI());
            operationUI.add(new DeliteOperationUI());
            operationUI.add(new EditOperationUI());

            folder = rootFolder.get_PathName();

            req.setAttribute("folder", folder);
            getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static List<OperationUI> getOperationUI(){return operationUI;}
    }