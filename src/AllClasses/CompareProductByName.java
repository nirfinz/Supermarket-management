package AllClasses;

import java.util.Comparator;

public class CompareProductByName implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		return p1.getName().compareTo(p2.getName());
	}

}
