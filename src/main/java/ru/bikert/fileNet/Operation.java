package ru.bikert.fileNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class Operation {
    private String title;
    private String description;
    private String argumentsNameOperationHelper;
    private static BufferedReader bufferedReader = null;

    public abstract void perform (List<String> arguments);

    public Operation(String title, String argumentsNameOperationHelper, String description) {
        this.title = title;
        this.argumentsNameOperationHelper = argumentsNameOperationHelper;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " " + argumentsNameOperationHelper + ": " + description +" \n";
    }

    static void closeReader() throws IOException {
        if (bufferedReader != null)
            bufferedReader.close();
    }

}
