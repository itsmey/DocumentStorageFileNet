package ru.bikert.fileNet.operations;

import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.bikert.fileNet.DocumentFileNet;
import ru.bikert.fileNet.Operation;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.util.List;

public class DocumentCreateOperation extends Operation {
    private static Logger logger = LoggerFactory.getLogger(DocumentCreateOperation.class);
    private static ObjectStore os = Connect.getObjectStore();
    public DocumentCreateOperation() {
        super(Constants.OperationNames.DOC_CREATE, " <name> <Comment>", Constants.OperationDescription.DOC_CREATE);
    }

    @Override
    public void perform(List<String> arguments) {
                Document doc = Factory.Document.createInstance(os, null);
                doc.getProperties().putValue("DocumentTitle", arguments.get(0));
                doc.save(RefreshMode.NO_REFRESH);
                // получаем папку-контейнер
                Folder container = Factory.Folder.getInstance(os, null, DocumentFileNet.getPath());
                // создаём инстанс DynamicReferentialContainmentRelationship
//                DynamicReferentialContainmentRelationship drcr = Factory.DynamicReferentialContainmentRelationship.createInstance(os, null);
                // назначаем свойства Head и Tail
//                drcr.set_Head(doc);
//                drcr.set_Tail(container);
//                drcr.set_ContainmentName("containment " + arguments.get(0));
                ReferentialContainmentRelationship drcr = container.file(
                        doc,
                        AutoUniqueName.NOT_AUTO_UNIQUE,
                        arguments.get(0),
                        DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
                drcr.save(RefreshMode.NO_REFRESH);
    }
}
