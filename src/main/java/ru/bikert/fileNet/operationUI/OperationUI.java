package ru.bikert.fileNet.operationUI;

import com.filenet.api.core.ObjectStore;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.fileNetConnect.Connect;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class OperationUI extends HttpServlet {

    private String title;
    private String key;
    private ObjectStore objectStore;
    private Connect conn;

    public OperationUI(String title, String key) {
        this.title = title;
        this.key = key;

    }

    public abstract JSONObject perform (HttpServletRequest req) throws Exception;

    public String getTitle() {
        return title;
    }

    public String getKey() { return key; }

    public ObjectStore getOS(){
        try {
            conn = new Connect();
            conn.connect();
            objectStore = conn.getObjectStore();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectStore;
    }
}
