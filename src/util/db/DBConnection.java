package util.db;

import util.xml.XMLParse;

public class DBConnection {
	
	public DBConnection() {
//		XMLParse.xmlParseMap
	}
	protected void connection() {
		 try {
			 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@오라클서버주소:포트번호:아이디";
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
