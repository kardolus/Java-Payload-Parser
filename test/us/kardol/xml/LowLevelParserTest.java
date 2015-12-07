package us.kardol.xml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author misterclipping
 */
public class LowLevelParserTest {
    LowLevelParser llp = null;
    
    public LowLevelParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        llp = new LowLevelParser();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class LowLevelParser.
     */
    @Test
    public void testParse() {
        System.out.println("Testing LowLevelParser.parse()");
        // Copied mock response from Amazon
        String xml =   "<Item>\n" +
                            "  <ASIN>076243631X</ASIN>\n" +
                            "  <DetailPageURL>\n" +
                            "    http://www.amazon.com/Mammoth-Book-Tattoos-Lal-Hardy/dp/076243631X%3FAWSAccessKeyId%3D[Your_AWSAccessKeyId]%26tag%3D[Your_AssociateTag]%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D076243631X\n" +
                            "  </DetailPageURL>\n" +
                            "  <SalesRank>7483</SalesRank>\n" +
                            "  <ItemAttributes>\n" +
                            "    <Author>Lal Hardy</Author>\n" +
                            "    <Binding>Paperback</Binding>\n" +
                            "    <DeweyDecimalNumber>391.65</DeweyDecimalNumber>\n" +
                            "    <EAN>9780762436316</EAN>\n" +
                            "    <Feature>ISBN13: 9780762436316</Feature>\n" +
                            "    <Feature>Condition: New</Feature>\n" +
                            "    <ISBN>076243631X</ISBN>\n" +
                            "    <Manufacturer>Running Press</Manufacturer>\n" +
                            "    <NumberOfItems>1</NumberOfItems>\n" +
                            "    <NumberOfPages>512</NumberOfPages>\n" +
                            "    <ProductGroup>Book</ProductGroup>\n" +
                            "    <PublicationDate>2009-03-10</PublicationDate>\n" +
                            "    <Publisher>Running Press</Publisher>\n" +
                            "    <Studio>Running Press</Studio>\n" +
                            "    <Title>The Mammoth Book of Tattoos</Title>\n" +
                            "  </ItemAttributes>\n" +
                            "</Item>";
        System.out.print("Test 1. ");
        assertEquals(llp.parse(xml, "Author"), "Lal Hardy");
        System.out.println(" ... ok");
        System.out.print("Test 2. ");
        assertEquals(llp.parse(xml, "PublicationDate"), "2009-03-10");
        System.out.println(" ... ok");
        System.out.print("Test 3. ");
        assertEquals(llp.parse(xml, "NumberOfPages"), "512");
        System.out.println(" ... ok");
        System.out.print("Test 4. ");
        assertEquals(llp.parse(xml, "DeweyDecimalNumber"), "391.65");
        System.out.println(" ... ok");
        System.out.print("Test 5. ");
        assertEquals(llp.parse(xml, "studio"), null); // case sensitive 
        System.out.println(" ... ok"); 
    }
    
}
