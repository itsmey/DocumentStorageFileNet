package ru.bikert.fileNet.operations;

import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import java.util.List;

public class HelpOperation extends Operation {

    public HelpOperation() {
        super(Constants.OperationNames.HELP, "", "");
    }

    @Override
    public void perform(List<String> arguments){
        for (Operation s:DocumentFileNet.getOperation()) {
            System.out.println(s.getTitle());
        }

    }
}
