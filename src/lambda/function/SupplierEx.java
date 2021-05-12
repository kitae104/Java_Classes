package lambda.function;

import java.util.function.IntSupplier;

public class SupplierEx {

	public static void main(String[] args) {

		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random() * 6) + 1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("수 : " + num);
	}

}
