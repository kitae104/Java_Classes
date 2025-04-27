package toc.y2025.mid.c.test2;

public class Main {
	public static void main(String[] args) {
        Product[] products = new Product[] {
            new Product("일반 상품", 10000),
            new DigitalProduct("디지털 상품", 20000),
            new DiscountedProduct("할인 상품", 30000, 20)
        };

        for (Product p : products) {
            System.out.println(p.getInfo());
            System.out.println("가격: " + p.getPrice());
            System.out.println();
        }
    }
}
