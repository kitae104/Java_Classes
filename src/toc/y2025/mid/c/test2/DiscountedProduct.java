package toc.y2025.mid.c.test2;

public class DiscountedProduct extends Product {
    private int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name, basePrice);
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return getBasePrice() - (getBasePrice() * discountPercent / 100);
    }

    @Override
    public String getInfo() {
        return "상품명: " + getName() + ", 할인율: " + discountPercent + "%, 최종가: " + getPrice();
    }
}
