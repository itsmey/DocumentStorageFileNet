package ru.bikert.fileNet.operations;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.constants.ReservationType;
import com.filenet.api.core.*;
import ru.bikert.fileNet.fileNetConnect.Connect;

import java.io.File;
import java.io.FileInputStream;

public class AddContent {

    public void setDoc(String pathContent, String pathDocument, String name ) {
    Document doc=OperationHelper.get_Document(name, pathDocument);
    if (!doc.get_IsReserved()){
        // Check out the Document object and save it.
        doc.checkout(ReservationType.EXCLUSIVE, null, doc.getClassName(), doc.getProperties());
        doc.save(RefreshMode.REFRESH);
    }


        // Get the Reservation object from the Document object.
       Document reservation = (Document) doc.get_Reservation();

        // Specify internal and external files to be added as content.
        File internalFile = new File(pathContent);
    // Add content to the Reservation object.
    try {
            // First, add a ContentTransfer object.
            ContentTransfer ctObject = Factory.ContentTransfer.createInstance();
            FileInputStream fileIS = new FileInputStream(internalFile.getAbsolutePath());
            ContentElementList contentList = Factory.ContentTransfer.createList();
            ctObject.setCaptureSource(fileIS);
            // Add ContentTransfer object to list.
            contentList.add(ctObject);

            reservation.set_ContentElements(contentList);
            reservation.save(RefreshMode.REFRESH);
        }
    catch (Exception e)
        {
            System.out.println(e.getMessage() );
        }
    // Check in Reservation object as major version.
    reservation.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
    reservation.save(RefreshMode.REFRESH);
    }
}
