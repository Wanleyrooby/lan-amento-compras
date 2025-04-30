package entities;

public class Purchase implements Comparable<Purchase> {

    private String description;
    private double price;

    public Purchase() {
    }

    public Purchase(String name, double price) {
        this.description = name;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchase: " +
                "description= " + description +
                ", price=" + price;
    }

    @Override
    public int compareTo(Purchase otherPurchase) {
        return Double.valueOf(this.price).compareTo(Double.valueOf(otherPurchase.price));
    }
}
