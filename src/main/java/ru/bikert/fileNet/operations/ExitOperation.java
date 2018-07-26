package ru.bikert.fileNet.operations;

import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;

import java.util.List;

public class ExitOperation extends Operation {

    public ExitOperation() {
        super(Constants.OperationNames.EXIT, "", Constants.OperationDescription.EXIT);
    }

    public void perform(List<String> arguments) {
       // DocumentFileNet.setExit(false);
    }
}
