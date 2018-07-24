package ru.bikert.fileNet;

import javax.inject.Named;

@Named
public class HelpUI {
    String nameDirectory = DocumentFileNet.getCurrentFolder().get_PathName();
    String nameEmployee = DocumentFileNet.getCurrentEmployee().getProperties().get("FullName").getStringValue();

    public String getNameDirectory() {
        return nameDirectory;
    }

    public void setNameDirectory(String nameDirectory) {
        this.nameDirectory = nameDirectory;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
}
