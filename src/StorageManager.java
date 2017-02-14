import java.util.ArrayList;

public class StorageManager {
    private StoreCapable storage;

    public void addStorage(StoreCapable storage)
    {
        this.storage = storage;
    }

    public void addCDProduct(String name, int price, int tracks)
    {
        storage.storeCDProduct(name, price, tracks);

    }

    public void addBookProduct(String name, int price, int size)
    {
        storage.storeBookProduct(name, price, size);
    }

    public String listProducts()
    {
        String result = "";
        ArrayList<Product> products = storage.getAllProduct();

        for(Product product: products)
        {
            String productString = "";
            if(product instanceof CDProduct)
            {
                productString += product.getName() + " -- "
                            + product.getPrice() + " -- "
                            + ((CDProduct) product).getNumOfTracks() + "\n";
            }
            else if(product instanceof BookProduct)
            {
                productString += product.getName() + " -- "
                            + product.getPrice() + " -- "
                            + ((BookProduct) product).getPageSize() + "\n";
            }
            result += productString;
        }

        return result;
    }

    public int getTotalProductPrice()
    {
        int result = 0;
        ArrayList<Product> products = storage.getAllProduct();

        for (Product product: products)
        {
            result += product.getPrice();
        }

        return result;
    }
}
