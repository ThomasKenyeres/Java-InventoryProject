/**
 * Created by k on 2017.02.05..
 */
public class BookProduct extends Product {
    public int pageSize;

    public BookProduct(String name, int price, int pageSize) {
        super(name, price);
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
