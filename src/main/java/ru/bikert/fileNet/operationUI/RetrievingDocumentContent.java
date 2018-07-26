package ru.bikert.fileNet.operationUI;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.constants.PropertyNames;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.property.FilterElement;
import com.filenet.api.property.Properties;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import org.json.simple.JSONObject;
import ru.bikert.fileNet.fileNetConnect.Connect;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.stream.Stream;


public class RetrievingDocumentContent extends OperationUI{

    public RetrievingDocumentContent() {
        super(UIConstants.NameOperation.EDIT, UIConstants.NameOperation.EDIT);
    }

    public void retrievingContent(String path){
        try{
            PropertyFilter pf = new PropertyFilter();
            pf.addIncludeProperty(new FilterElement(null, null, null, PropertyNames.CONTENT_SIZE, null) );
            pf.addIncludeProperty(new FilterElement(null, null, null, PropertyNames.CONTENT_ELEMENTS, null) );
            pf.addIncludeProperty(new FilterElement(null,null,null,PropertyNames.NAME,null));
            Document doc=Factory.Document.fetchInstance(getOS(), path, pf );

                    System.out.println("Doc Title :: "+ doc.get_Name());
                    ContentElementList docContentList = doc.get_ContentElements();
                    Iterator iter = docContentList.iterator();
                    String filepath = "C:\\Users\\ebikert\\IdeaProjects\\DocumentStorageFileNet\\Dowonload\\";
                    FileOutputStream fos = new FileOutputStream(filepath+doc.get_Name());
                    while (iter.hasNext() )
                    {
                        ContentTransfer ct = (ContentTransfer) iter.next();
                        // Print element sequence number and content type of the element.
                        System.out.println("\nElement Sequence number: " + ct.get_ElementSequenceNumber().intValue() + "\n" +"Content type: " + ct.get_ContentType() + "\n");
                        InputStream stream = ct.accessContentStream();
                        byte[] buffer = new byte[4096000];
                        int bytesRead = 0;
                        while ((bytesRead = stream.read(buffer)) != -1) {
                            System.out.print(".");
                            fos.write(buffer,0,bytesRead);
                        }
                        System.out.println("done!");
                        fos.close();
                        stream.close();
                    }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public JSONObject perform(HttpServletRequest req) throws Exception {
        return null;
    }
}
