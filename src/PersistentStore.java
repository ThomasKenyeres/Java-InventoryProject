import java.util.ArrayList;

public class PersistentStore extends Store
{
    private ArrayList<Product> products = new ArrayList<Product>();

    public void storeProduct(Product product)
    {
        System.out.println("PersistentStore.storeProduct");
        products.add(product);
    }

    @Override
    public ArrayList<Product> getAllProduct()
    {
        System.out.println("PersistentStore.getAllProduct");
        return products;
    }

    @Override
    public void storeCDProduct(String name, int price, int size)
    {
        System.out.println("PersistentStore.storeCDProduct");
        storeProduct(new CDProduct(name, price, size));
    }

    @Override
    public void storeBookProduct(String name, int price, int size)
    {
        System.out.println("PersistentStore.storeBookProduct");
        storeProduct(new BookProduct(name, price, size));
    }
}
