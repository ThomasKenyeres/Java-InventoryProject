import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import java.util.ArrayList;

/**
 * Created by k on 2017.02.04..
 */
public abstract class Store implements  StoreCapable
{
    private String fileName = "Products.xml";

    private void saveToXml(Product product)
    {
        try
        {
            File file = new File("products.xml");

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("products");
            doc.appendChild(rootElement);

            Element prod = doc.createElement("product");
            rootElement.appendChild(prod);


            Attr name = doc.createAttribute("name");
            prod.setAttribute("name", product.getName());

            Attr price = doc.createAttribute("price");
            prod.setAttribute("price", Integer.toString(product.getPrice()));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);



        }
        catch(Exception e)
        {
            System.out.println("Exception");
        }

    }

    protected void storeProduct(Product product)
    {
    }

    protected void createProduct(String type, String name, int price, int size)
    {
    }

    public ArrayList<Product> loadProducts()
    {
        return null;
    }

    public void store(Product product)
    {
        saveToXml(product);
        storeProduct(product);
    }
}
