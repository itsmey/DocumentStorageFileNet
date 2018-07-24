package ru.bikert.fileNet;

import com.filenet.api.core.Folder;
import ru.bikert.fileNet.operations.PrintHierarchyOperation;

import javax.inject.Named;
import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class MainWebApp extends HttpServlet {

    private String folder;
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        }
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                DocumentFileNet.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            folder = DocumentFileNet.getCurrentFolder().get_PathName();
            Operation operation = new PrintHierarchyOperation();
            operation.perform(new ArrayList<>());

            req.setAttribute("folder", folder);
            getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);
        }
    }