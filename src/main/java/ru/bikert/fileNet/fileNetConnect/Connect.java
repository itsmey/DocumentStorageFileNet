package ru.bikert.fileNet.fileNetConnect;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.util.UserContext;

import javax.security.auth.Subject;


public class Connect {

    private UserContext userContext;
    private Subject subject;
    private ObjectStore objectStore;

    public void connect() throws Exception {
        Connection conn = Factory.Connection.getConnection(ConstantConnect.URL);
        userContext = UserContext.get();
        subject = UserContext.createSubject(conn, ConstantConnect.login, ConstantConnect.password, null); //optionalJAASStanzaName - A string containing the JAAS configuration stanza name. Can be null, in which case the stanza name defaults to "FileNetP8".

        userContext.pushSubject(subject);

        try {
            Domain domain = Factory.Domain.getInstance(conn, null);

            objectStore = Factory.ObjectStore.fetchInstance(domain,
                    ConstantConnect.objectStoreName, null);

            Object folder = objectStore.get_RootFolder();

            System.out.println(objectStore.get_DatabaseSchemaName() +"   "+  objectStore.get_SchemaVersion());
            System.out.println(objectStore.getConnection().getURI());


        } catch (EngineRuntimeException ex) {
            throw new Exception(ex.getExceptionCode().toString());
        } finally {
            userContext.popSubject();
        }
    }

}
