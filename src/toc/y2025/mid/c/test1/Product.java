package toc.y2025.mid.c.test1;

public class Product {
    private String name;
    private int price;
    private double taxRate;

    public Product(String name, int price, double taxRate) {
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    public double getFinalPrice() {
        return price * (1 + taxRate / 100);
    }

    public void printReceipt() {
        System.out.printf("상품: %s / 정가: %d / 세금 포함: %.1f\n", 
                          name, price, getFinalPrice());
    }
    
}
