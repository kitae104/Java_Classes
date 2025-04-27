package toc.y2025.mid.c.test2;

public class Product {
	private String name;
    private int basePrice;

    public Product(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getPrice() {
        return basePrice;
    }

    public String getInfo() {
        return "상품명: " + name + ", 가격: " + basePrice;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
    
    
}
