public class Main
{
    public static void main(String[] args)
    {
        StorageManager manager = new StorageManager();
        StoreCapable sc = new PersistentStore();
        manager.addStorage(sc);

        manager.addBookProduct("Big Cook Book", 5000, 45);
        manager.addCDProduct("Michael Jackson - Thriller 1982", 10000, 9);

        System.out.println(manager.listProducts());
        System.out.println(manager.getTotalProductPrice());

    }

}
