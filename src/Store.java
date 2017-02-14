import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;


public abstract class Store implements StoreCapable
{
    private String fileName = "Products.xml";

    private void saveToXml(Product product)
    {
        try
        {
            File file = new File(fileName);

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("products");
            doc.appendChild(rootElement);

            Element prod = doc.createElement("product");
            rootElement.appendChild(prod);

            Attr type = doc.createAttribute("type");

            Attr name = doc.createAttribute("name");
            prod.setAttribute("name", product.getName());

            Attr price = doc.createAttribute("price");
            prod.setAttribute("price", Integer.toString(product.getPrice()));

            if(product instanceof CDProduct)
            {
                prod.setAttribute("type", "cd");

                Attr tracks = doc.createAttribute("tracks");
                prod.setAttribute("tracks", Integer.toString(((CDProduct) product).getNumOfTracks()));
            }
            else if(product instanceof BookProduct)
            {
                prod.setAttribute("type", "book");

                Attr pages = doc.createAttribute("pages");
                prod.setAttribute("pages", Integer.toString(((BookProduct) product).getPageSize()));
            }

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

    protected abstract void storeProduct(Product product);

    protected Product createProduct(String type, String name, int price, int size)
    {
        if(type == "cd")
        {
            Product product = new CDProduct(name, price, size);
        }
        else if(type == "book")
        {
            Product product = new BookProduct(name, price, size);
        }
        return null;
    }

    public ArrayList<Product> loadProducts()
    {
        ArrayList resultProducts = new ArrayList<Product>();

        try {
            File file = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList productNodeList = document.getElementsByTagName("product");

            for(int i = 0; i < productNodeList.getLength(); i++){

                Node productNode = productNodeList.item(i);

                Element productElement = (Element) productNode;

                //System.out.println(productElement.getAttribute("type"));

                String pType = productElement.getAttribute("type");
                if(pType == "cd")
                {
                    String cdName = productElement.getAttribute("name");
                    int cdPrice = Integer.valueOf(productElement.getAttribute("name"));
                    int cdSize = Integer.valueOf(productElement.getAttribute("name"));

                    resultProducts.add(new CDProduct(cdName, cdPrice, cdSize));
                }
                else if(pType == "book")
                {
                    String bookName = productElement.getAttribute("name");
                    int bookPrice = Integer.valueOf(productElement.getAttribute("name"));
                    int bookSize = Integer.valueOf(productElement.getAttribute("name"));

                    resultProducts.add(new BookProduct(bookName, bookPrice, bookSize));
                }



                System.out.println("\n");
            }



        }
        catch (Exception e){

        }
        return resultProducts;
    }

    public void store(Product product)
    {
        saveToXml(product);
        loadProducts();
    }
}
