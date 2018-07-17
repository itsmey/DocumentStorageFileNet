package ru.bikert.fileNet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


public abstract class Operation {
    private int code;
    private String title;
    private String description;
    private String argumentsNameOperationHelper;

    protected static BufferedReader bufferedReader = null;

    public abstract void perform (List<String> arguments) throws  IOException;

    public Operation(String title, String argumentsNameOperationHelper, String description) {
        this.title = title;
        this.argumentsNameOperationHelper = argumentsNameOperationHelper;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " " + argumentsNameOperationHelper + ": " + description +" \n";
    }

    public static void closeReader() throws IOException {
        if (bufferedReader != null)
            bufferedReader.close();
    }

}
