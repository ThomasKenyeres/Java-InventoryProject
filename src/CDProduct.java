/**
 * Created by k on 2017.02.05..
 */
public class CDProduct extends Product {
    public int numOfTracks;

    public CDProduct(String name, int price, int numOfTracks) {
        super(name, price);
        this.numOfTracks = numOfTracks;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }
}
