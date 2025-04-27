package toc.y2025.mid.c.test2;

public class DigitalProduct extends Product {

    public DigitalProduct(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int getPrice() {
        return (int)(getBasePrice() * 1.1);  // 10% 부가세 추가
    }

    @Override
    public String getInfo() {
        return "상품명: " + getName() + ", 가격: " + getPrice();
    }
}
