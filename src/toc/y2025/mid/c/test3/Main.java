package toc.y2025.mid.c.test3;

import java.util.Vector;

import toc.y2025.mid.c.test2.DigitalProduct;
import toc.y2025.mid.c.test2.DiscountedProduct;
import toc.y2025.mid.c.test2.Product;

public class Main {
	public static void main(String[] args) {
        Vector<Product> products = new Vector<>();

        products.add(new Product("일반 상품", 10000));
        products.add(new DigitalProduct("디지털 상품", 20000));
        products.add(new DiscountedProduct("할인 상품", 30000, 20));

        for (Product p : products) {
            System.out.println(p.getInfo());
            System.out.println("가격: " + p.getPrice());
            System.out.println();
        }
    }
}
