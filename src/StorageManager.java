public class StorageManager {
    private StoreCapable storage;

    public void addStorage(StoreCapable storage)
    {
        System.out.println("StorageManager.addStorage");
        this.storage = storage;
    }

    public void addCDProduct(String name, int price, int tracks)
    {
        System.out.println("StorageManager.addCDProduct");
        storage.storeCDProduct(name, price, tracks);

    }

    public void addBookProduct(String name, int price, int size)
    {
        System.out.println("StorageManager.addBookProduct");
        storage.storeBookProduct(name, price, size);
    }

    public String listProducts()
    {
        System.out.println("StorageManager.listProducts");
        return null;
    }

    public int getTotalProductPrice()
    {
        System.out.println("StorageManager.getTotalProductPrice");
        return 0;
    }
}
