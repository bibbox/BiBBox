package at.bibbox.test;

import java.util.List;

import com.orientechnologies.orient.core.command.OCommandResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLNonBlockingQuery;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

public class TestGetData {
	public String getPatients() {
		ODatabaseDocumentTx db = new ODatabaseDocumentTx("remote:192.168.99.100:2425/Test").open("root", "000D41401EE741D8EB1AC495A4B7AEE1E3BF3D93B1A0070736231D17687B3A7D");
		db.command(new OSQLNonBlockingQuery<Object>("SELECT FROM Patient WHERE outE('Belongs_To').size() = 0", new OCommandResultListener() {

			int resultCount = 0;
			
			@Override
			public void end() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean result(Object arg0) {
				resultCount++;
		        ODocument doc = (ODocument) arg0;
		        // DO SOMETHING WITH THE DOCUMENT
		        for(String fieldnames : doc.fieldNames()) {
		        	System.out.print(fieldnames + ": " + doc.field(fieldnames).toString() + ", ");
		        }
		        System.out.println("callback "+resultCount+" invoked");
		        return resultCount > 20 ? false : true;
			}
			
		})).execute();
		
		/*Future future = db.command(new OSQLNonBlockingQuery<Object>("select * from animal where name = 'Gipsy'",
			    new OCommandResultListener() {
			      resultCount = 0;
			      @Override
			      public boolean result(Object iRecord) {
			        resultCount++;
			        ODocument doc = (ODocument) iRecord;
			        // DO SOMETHING WITH THE DOCUMENT

			        System.out.println("callback "+resultCount+" invoked");
			        return resultCount > 20 ? false : true;
			      }

			      @Override
			      public void end() {
			      }
			    })).execute();

			System.out.println("query executed");

			future.get();*/
			return "";
	}
	
	public List<ODocument> getPatients2() {
		ODatabaseDocumentTx db = new ODatabaseDocumentTx("remote:192.168.99.100:2425/Test").open("root", "000D41401EE741D8EB1AC495A4B7AEE1E3BF3D93B1A0070736231D17687B3A7D");
		List<ODocument> result = db.query(new OSQLSynchQuery<ODocument>("SELECT FROM Patient WHERE outE('Belongs_To').size() = 0"));
		return result;
	}
}
