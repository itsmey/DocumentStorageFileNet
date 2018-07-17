package ru.bikert.fileNet.operations;

import java.text.SimpleDateFormat;

    interface Constants {
        String REGEXP_SPLIT_ARGS = ".*\\w.*";
        String INDENT = " ";
        String TAB = "  ";
        String CURRENT_FOLDER = "You are in folder: ";
        String FOLDER_IS = "Folder is ";
        String DOCUMENT_IS = "Document is ";
        String EMPTY_STRING = "[Пустой]";
        String DATE_CREATE = " date create: " ;
        String DOCUMENT_COMMENT = " Comment: ";
        SimpleDateFormat FORMAT_NEW = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        interface OperationNames {
            String HELP = "help";
            String GO_TO_PARENT = "up";
            String DOTO = "goto";
            String FOLDER_CREATE = "create_f";
            String DOC_CREATE = "create_d";
            String DELETE = "delete";
            String EXIT = "exit";
            String PRINT = "print";
            String CURRENT_PRINT = "print_c";
        }
        interface OperationDescription{
            String HELP = "help";
            String GO_TO_PARENT = "go to parent";
            String DOTO = "go to folder";
            String FOLDER_CREATE = "create folder";
            String DOC_CREATE = "create document";
            String DELETE = "delete";
            String EXIT = "exit";
            String PRINT = "print hierarchy";
            String CURRENT_PRINT = "print current";
        }
        interface OperationErrors {
            String NO_NAME = "No containable with such name!";
            String NOT_A_PARENT = "Not a Parent";
            String NO_CHILDREN = "No Children";
            String NULL_NAME = "Name is Null";
            String EXITS_NAME = "This name is exists";

        }
}
