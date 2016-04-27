package at.bibbox.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

/**
 * Portlet implementation class TestOrientDB
 */
public class TestOrientDB extends MVCPortlet {
 
	public void addPerson(ActionRequest request, ActionResponse response) throws Exception {
		/*
		// OPEN THE DATABASE
		ODatabaseDocumentTx db = ODatabaseDocumentPool.global().acquire("remote:localhost/petshop", "admin", "admin");
		try {
		  // YOUR CODE
		  ...
		} finally {
		  db.close();
		}
		
		for (ODocument animal : database.browseClass("Animal")) {
		  System.out.println( animal.field( "name" ) );
		  
		  long cars = database.countClass("Car");
		  
		  ----Asynchronous query
		  database.command(
  new OSQLAsynchQuery<ODocument>("select * from animal where name = 'Gipsy'",
    new OCommandResultListener() {
      resultCount = 0;
      @Override
      public boolean result(Object iRecord) {
        resultCount++;
        ODocument doc = (ODocument) iRecord;
        // DO SOMETHING WITH THE DOCUMENT

        return resultCount > 20 ? false : true;
      }

      @Override
      public void end() {
      }
    })).execute();
		  
		*/
		
		// OPEN THE DATABASE
		ODatabaseDocumentTx db = new ODatabaseDocumentTx("remote:192.168.99.100:2425/Test").open("root", "000D41401EE741D8EB1AC495A4B7AEE1E3BF3D93B1A0070736231D17687B3A7D");

		// CREATE A NEW DOCUMENT AND FILL IT
		ODocument doc = new ODocument("Patient");
		doc.field( "name", "Luke2" );
		doc.field( "surname", "Skywalker" );
		doc.field( "city", new ODocument("City").field("name","Rome").field("country", "Italy") );

		// SAVE THE DOCUMENT
		doc.save();

		db.close();
	}
}
