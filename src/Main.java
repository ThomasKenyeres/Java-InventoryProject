public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Starting app...");
        StorageManager manager = new StorageManager();
        StoreCapable sc = new PersistentStore();
        manager.addStorage(sc);


    }

}
