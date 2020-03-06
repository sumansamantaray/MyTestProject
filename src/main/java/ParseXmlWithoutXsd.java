import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXmlWithoutXsd {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
		            .newInstance();
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		    Document document = docBuilder.parse(new File("./src/main/resources/Address_Mod.xml"));

		    NodeList nodeList = document.getElementsByTagName("*");
		    for (int i = 0; i < nodeList.getLength(); i++) {
		        Node node = nodeList.item(i);
		        if (node.getNodeType() == Node.ELEMENT_NODE) {
		            // do something with the current element
		        	Element eElement = (Element) node;
		            System.out.println(node.getNodeName());
		            System.out.println(node.getNodeValue());
		            System.out.println(eElement.getElementsByTagName("SANO").item(0).getTextContent());
		        }
		    }
		} catch(ParserConfigurationException | SAXException | IOException parseExp) {
			
		}
		 
	}

}
