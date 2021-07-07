package project2;

public class Configuration {

    private int xLength;

    private int yLength;

    private int goldAmount;

    public Configuration() {
        this.xLength = 40;
        this.yLength = 10;
        this.goldAmount = 1;
    }

    public Configuration(int xLength, int yLength, int goldAmount) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.goldAmount = goldAmount;
    }

    public int getxLength() {
        return xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public int getGoldAmount() {
        return goldAmount;
    }
}
