package models;

public class Trade {
    double entryPrice, sizeInUsdt, leverage, liqPriceInUsdt;
    Side side;

    public Trade() {
    }

    public Trade(double entryPrice, double sizeInUsdt, double leverage, double liqPriceInUsdt, Side side) {
        this.side = side;
        this.entryPrice = entryPrice;
        this.sizeInUsdt = sizeInUsdt;
        this.leverage = leverage;
        this.liqPriceInUsdt = liqPriceInUsdt;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public double getSizeInUsdt() {
        return sizeInUsdt;
    }

    public void setSizeInUsdt(double sizeInUsdt) {
        this.sizeInUsdt = sizeInUsdt;
    }

    public double getLeverage() {
        return leverage;
    }

    public void setLeverage(double leverage) {
        this.leverage = leverage;
    }

    public double getLiqPriceInUsdt() {
        return liqPriceInUsdt;
    }

    public void setLiqPriceInUsdt(double liqPriceInUsdt) {
        this.liqPriceInUsdt = liqPriceInUsdt;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}
