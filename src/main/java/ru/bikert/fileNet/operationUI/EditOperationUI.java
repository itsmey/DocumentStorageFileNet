package ru.bikert.fileNet.operationUI;
import javax.servlet.http.HttpServletRequest;

public class EditOperationUI extends OperationUI {


    public EditOperationUI() {
        super(UIConstants.NameOperation.EDIT, UIConstants.KeyOperation.EDIT);
    }

    @Override
    public void perform(HttpServletRequest req) {
        String name = req.getParameter("name");
    }
}
