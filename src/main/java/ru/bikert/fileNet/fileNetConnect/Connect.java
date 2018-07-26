package ru.bikert.fileNet.fileNetConnect;

import com.filenet.api.core.*;
import com.filenet.api.util.UserContext;

import javax.security.auth.Subject;


public class Connect {

    private ObjectStore objectStore;
    private UserContext userContext;
    private Subject subject;

    public void connect() throws Exception {
        Connection conn = Factory.Connection.getConnection(ConstantConnect.URL);
        userContext = UserContext.get();
        subject = UserContext.createSubject(conn, ConstantConnect.login, ConstantConnect.password, null); //optionalJAASStanzaName - A string containing the JAAS configuration stanza name. Can be null, in which case the stanza name defaults to "FileNetP8".

        userContext.pushSubject(subject);

        Domain domain = Factory.Domain.getInstance(conn, null);

        objectStore = Factory.ObjectStore.fetchInstance(domain,
                    ConstantConnect.objectStoreName, null);

    }

    public ObjectStore getObjectStore(){
        return this.objectStore;
    }
    public UserContext getUserContext() {
        return this.userContext;
    }

}
