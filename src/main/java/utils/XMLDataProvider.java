package utils;

import org.testng.log4testng.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nykytchuk on 15/11/2016.
 */
public class XMLDataProvider {
    private static final Logger log = Logger.getLogger(XMLDataProvider.class);
    private static final String DataFilePath = "src/test/TestResources/testData.xml";
    public static Object[][] xmlParser(String dataName){
        List<Object[]> data = new ArrayList<Object[]>();

        try{
            File xmlDataFile = new File(DataFilePath);

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlDataFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(dataName);

            for(int i = 0; i<nodeList.getLength();i++){
                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    List<Object> testData = new ArrayList<Object>();
                    testData.add(element.getElementsByTagName("login").item(0).getTextContent());
                    testData.add(element.getElementsByTagName("password").item(0).getTextContent());
                    testData.add(element.getElementsByTagName("expectedResult").item(0).getTextContent());
                    data.add(testData.toArray());

                }
            }
        }
        catch (Exception e){
            log.error("Reading XML file error!",e);
        }

        Object[][] objectArray = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            objectArray[i] = data.get(i);
        }

        return objectArray;
    }

}
