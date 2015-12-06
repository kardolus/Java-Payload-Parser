package us.kardol.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Guillermo Kardolus
 */
public class LowLevelParser {
    public String parse(String xml, String element){
        String result = "";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        
        fact.setNamespaceAware(true);
        try {
            DocumentBuilder builder = fact.newDocumentBuilder();
            Document doc = builder.parse(bais);
            NodeList parent = doc.getElementsByTagName(element);
            for (int i = 0; i < parent.getLength(); i++) {
                Element e = (Element) parent.item(i);
                NodeList nodes = e.getChildNodes();
                for (int j = 0; j < nodes.getLength(); j++) {
                    Node child = nodes.item(j);
                    if (child.getNodeType() == Node.TEXT_NODE)
                        result = child.getNodeValue();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(LowLevelParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
