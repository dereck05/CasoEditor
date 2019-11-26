/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author naty9
 */
public class XMLImp implements IArchivo{
    public XMLImp(){}


    @Override
    public void guardar(String text, String filename) {
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write("<text>\n"+text+"\n<//text>");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(XMLImp.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Override
    public String leer(String filename) {
        ArrayList<String> rolev = new ArrayList<String>();
        String text = null;
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(filename);
            Element doc = dom.getDocumentElement();
            text = getTextValue(text, doc, "text");
            if (text != null) {
                if (!text.isEmpty())
                    rolev.add(text);
            }

        }catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Texto xml:" + text);
        return text; 
    }
    
    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }
}

