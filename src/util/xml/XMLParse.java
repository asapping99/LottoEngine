package util.xml;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class XMLParse {
	
	private static String xmlFilePath = "config";
	public static HashMap xmlParseMap = null;
	
	public static void execute() {
		try {
			domParse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void domParse() throws Exception {
		File[] files = new File(xmlFilePath).listFiles();
		for(int i = 0; i < files.length; i++) {
			File xmlFile = new File(files[i].getPath());
						
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
			DocumentBuilder builder = factory.newDocumentBuilder();   
			Document doc = builder.parse(xmlFile);   
			doc.getDocumentElement().normalize();
			
			putParseMapByXML(doc);
		}
	}
	
	protected static void putParseMapByXML(Document doc) throws Exception {
		Field[] fileds = XMLConstant.class.getFields();
		for(int i = 0; i < fileds.length; i++) {
			Field f = fileds[i];
			String prefix = XMLConstant.PREFIX_TAG + "_";
			if(prefix.indexOf((String)f.get(f.getName())) < 0) {
				NodeList list = doc.getElementsByTagName((String)f.get(f.getName()));
				for(int j = 0; j < list.getLength(); j++) {
					NamedNodeMap map = list.item(j).getAttributes();
					xmlParseMap.put(list.item(j).getNodeName(), map);
				}				
			}
		}
	}
	
	protected static void test() {
		System.out.println("테스트 입니다.");
	}
}
