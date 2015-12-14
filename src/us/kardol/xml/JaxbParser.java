package us.kardol.xml;

import AWSECommerceService.Item;
import AWSECommerceService.ItemAttributes;
import AWSECommerceService.ItemLookupResponse;
import AWSECommerceService.Items;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.xml.sax.InputSource;

/**
 * @author Guillermo Kardolus
 * This class uses unmarshalling to parse an XML element from a given string. 
 * Then as a test, it finds the author from the provided xml.
 */
public class JaxbParser {
    public String getAuthor(InputSource xml){
        try {
            JAXBContext ctx = JAXBContext.newInstance(ItemLookupResponse.class);
            Unmarshaller um = ctx.createUnmarshaller();
            ItemLookupResponse response = (ItemLookupResponse) um.unmarshal(xml);
            List<Items> itemsList = response.getItems(); // list of lists                
            for (Items items : itemsList) {         // outer list                   
              List<Item> list = items.getItem();  // inner list                     
              for (Item item : list) {            // items in inner list
                ItemAttributes attributes = item.getItemAttributes();
                List<String> authors = attributes.getAuthor(); // could be several
                return authors.get(0); // Get the first author                
              }
            }
        } catch (JAXBException ex) {
            Logger.getLogger(JaxbParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
