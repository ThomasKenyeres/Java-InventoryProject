public interface StoreCapable {
    ArrayList<Product> getAllProduct();

    void storeCDProduct(String name, int price, int size);

    void storeBookProduct(String name, int price, int size);

}
