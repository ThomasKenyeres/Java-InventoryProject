import java.util.ArrayList;

/**
 * Created by k on 2017.02.05..
 */
public class PersistentStore extends Store implements StoreCapable {
    public void storeProduct(Product product) {
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    @Override
    public void storeCDProduct(String name, int price, int size) {

    }

    @Override
    public void storeBookProduct(String name, int price, int size) {

    }
}
