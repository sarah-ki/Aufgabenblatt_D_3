package vier.aufgabenblatt;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;
// Name Sarah Franke
// MN 17617
//Datum der Erstellung: November
//Datum der Letzten Aenderung: 01/06/2021

public class MyContentHandler implements ContentHandler {
    private ArrayList<String> alleTitel = new ArrayList<String>();
    private String currentValue;
    public boolean itemlayer=false;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }



    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (localName.equals("item")) {
           // System.out.println("item start");
            itemlayer=true;
        }
        if (localName.equals("channel")) {
           // System.out.println("channel start");

        }

    }

    /**
     * Findet sich ein close-Titeltag inerhalb eines Item elementes, so wird der Inhalt des tags ausgegeben
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("item")) {
          //  System.out.println("item end");
            itemlayer=false;
        }
        if (localName.equals("title")&&(itemlayer==true)) {
            System.out.println(currentValue);
        }

    }

    /**
     *
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
       //        System.out.println("Start of Document!");
    }
    @Override
    public void endDocument() throws SAXException {
        //System.out.println("End of Document!");
    }
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }
    @Override
    public void setDocumentLocator(Locator locator) {

    }
    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }
    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
