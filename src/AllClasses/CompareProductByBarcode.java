package AllClasses;

import java.util.Comparator;

public class CompareProductByBarcode implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		return p1.getBarcode().compareTo(p2.getBarcode());
	}

}
