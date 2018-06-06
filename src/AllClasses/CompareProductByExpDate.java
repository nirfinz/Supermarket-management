package AllClasses;

import java.util.Comparator;

public class CompareProductByExpDate implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		if(p1.getExpDate() == null)
			return -1;
		if(p2.getExpDate() == null)
			return 1;
		return p1.getExpDate().compareTo(p2.getExpDate());
	}
}
