package Discounts;

public class Product {
    private int price;
    private int discountPrice;

    public Product(String part){
        String[] parts = part.split(":");
        price = Integer.parseInt(parts[1]);
        discountPrice = Integer.parseInt(parts[0]);
    }

    public int getDiscoutnPercent() {
        return 100 * (price - discountPrice) / price;
    }

    public int getDiscount() {
        return price - discountPrice;
    }

    public String toString() {
        return String.format("%d%% %d/%d", getDiscoutnPercent(), discountPrice, price);
    }
}
