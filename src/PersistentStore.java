import java.util.ArrayList;

public class PersistentStore extends Store
{
    private ArrayList<Product> products = new ArrayList<Product>();

    public void storeProduct(Product product)
    {
        products.add(product);
        store(product);
    }

    @Override
    public ArrayList<Product> getAllProduct()
    {
        return products;
    }

    @Override
    public void storeCDProduct(String name, int price, int size)
    {
        storeProduct(new CDProduct(name, price, size));
    }

    @Override
    public void storeBookProduct(String name, int price, int size)
    {
        storeProduct(new BookProduct(name, price, size));
    }
}
