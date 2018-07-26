package ru.bikert.fileNet.operationUI;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;

public class EditOperationUI extends OperationUI {


    public EditOperationUI() {
        super(UIConstants.NameOperation.EDIT, UIConstants.KeyOperation.EDIT);
    }

    @Override
    public JSONObject perform(HttpServletRequest req) {
        String name = req.getParameter("name");
        return new JSONObject();
    }
}
