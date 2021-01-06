package vier.aufgabenblatt;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
// Name Sarah Franke
// MN 17617
//Datum der Erstellung: November
//Datum der Letzten Aenderung: 01/06/2021

/**
 * Hausaufgabe Aufgabenblatt D Nr. 3
 */
public class Main {

    public static void main(String[] args) {
        /**
         * öffnet die gegebene Verbindung des links und schriebt Inhalt in Dokument
         */
        try
        {
            URL url = new URL("http://feeds.feedburner.com/blogspot/rkEL");
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
            File myfile = new File("xmlfile.xml");
            BufferedWriter writer = new BufferedWriter(new FileWriter(myfile));
            String line = "";
            while ((line = input.readLine()) != null){
                writer.write(line+"\n");
              //  System.out.println(line);
            }
            writer.flush();
            writer.close();
        }

        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        /**
         * XML SAX Parser wird initialisiert und auf das Dokument xmlfile.xml angewandt
         */
        try {

            // XMLReader erzeugen
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Pfad zur XML Datei
            FileReader reader = new FileReader("xmlfile.xml");
            InputSource inputSource = new InputSource(reader);

            // PersonenContentHandler wird übergeben
            xmlReader.setContentHandler(new MyContentHandler());

            // Parsen wird gestartet
            xmlReader.parse(inputSource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    }

