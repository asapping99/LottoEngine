package util.db;

import util.xml.XMLParse;

public class DBConnection {
	
	public DBConnection() {
//		XMLParse.xmlParseMap
	}
	protected void connection() {
		 try {
			 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@����Ŭ�����ּ�:��Ʈ��ȣ:���̵�";
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
