package us.kardol.xml;

import java.io.StringReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.InputSource;

/**
 *
 * @author misterclipping
 */
public class JaxbParserTest {
    /**
     * Test of parse method, of class JaxbParser.
     */
    @Test
    public void testParse() {
        System.out.println("Testing JaxBParser.getAuthor()");
        String xml = "<?xml version=\"1.0\" ?><ItemLookupResponse xmlns=\"http://webservices.amazon.com/AWSECommerceService/2011-08-01\"><OperationRequest><HTTPHeaders><Header Name=\"UserAgent\" Value=\"Java/1.8.0_65\"></Header></HTTPHeaders><RequestId>58c56d1a-060c-49f8-a888-99c8ed60fc03</RequestId><Arguments><Argument Name=\"AWSAccessKeyId\" Value=\"AKIAJC2Z4J3HP2R6C2EA\"></Argument><Argument Name=\"AssociateTag\" Value=\"kardolus-20\"></Argument><Argument Name=\"IdType\" Value=\"ISBN\"></Argument><Argument Name=\"ItemId\" Value=\"076243631X\"></Argument><Argument Name=\"Operation\" Value=\"ItemLookup\"></Argument><Argument Name=\"ResponseGroup\" Value=\"Small\"></Argument><Argument Name=\"SearchIndex\" Value=\"All\"></Argument><Argument Name=\"Service\" Value=\"AWSECommerceService\"></Argument><Argument Name=\"Timestamp\" Value=\"2015-12-14T00:34:16Z\"></Argument><Argument Name=\"Signature\" Value=\"8Nn498MiQQg0otAnnYiLUgfta4ZGDfMv8Metxz7m1Tw=\"></Argument></Arguments><RequestProcessingTime>0.1007820000000000</RequestProcessingTime></OperationRequest><Items><Request><IsValid>True</IsValid><ItemLookupRequest><IdType>ISBN</IdType><ItemId>076243631X</ItemId><ResponseGroup>Small</ResponseGroup><SearchIndex>All</SearchIndex><VariationPage>All</VariationPage></ItemLookupRequest></Request><Item><ASIN>076243631X</ASIN><DetailPageURL>http://www.amazon.com/The-Mammoth-Book-Tattoos-Hardy/dp/076243631X%3FSubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D076243631X</DetailPageURL><ItemLinks><ItemLink><Description>Technical Details</Description><URL>http://www.amazon.com/The-Mammoth-Book-Tattoos-Hardy/dp/tech-data/076243631X%3FSubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink><ItemLink><Description>Add To Baby Registry</Description><URL>http://www.amazon.com/gp/registry/baby/add-item.html%3Fasin.0%3D076243631X%26SubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink><ItemLink><Description>Add To Wedding Registry</Description><URL>http://www.amazon.com/gp/registry/wedding/add-item.html%3Fasin.0%3D076243631X%26SubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink><ItemLink><Description>Add To Wishlist</Description><URL>http://www.amazon.com/gp/registry/wishlist/add-item.html%3Fasin.0%3D076243631X%26SubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink><ItemLink><Description>Tell A Friend</Description><URL>http://www.amazon.com/gp/pdp/taf/076243631X%3FSubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink><ItemLink><Description>All Customer Reviews</Description><URL>http://www.amazon.com/review/product/076243631X%3FSubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink><ItemLink><Description>All Offers</Description><URL>http://www.amazon.com/gp/offer-listing/076243631X%3FSubscriptionId%3DAKIAJC2Z4J3HP2R6C2EA%26tag%3Dkardolus-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D386001%26creativeASIN%3D076243631X</URL></ItemLink></ItemLinks><ItemAttributes><Author>Lal Hardy</Author><Manufacturer>Running Press</Manufacturer><ProductGroup>Book</ProductGroup><Title>The Mammoth Book of Tattoos</Title></ItemAttributes></Item></Items></ItemLookupResponse>";
        // Actual String response from Amazon's Ecommerce Service
        
        JaxbParser jbp = new JaxbParser();
        
        System.out.print("Test 1. ");
        assertEquals(jbp.getAuthor(new InputSource(new StringReader(xml))), "Lal Hardy");
        System.out.println(" ... ok");
    }
    
}
