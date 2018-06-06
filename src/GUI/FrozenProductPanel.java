package GUI;

import AllClasses.Date;
import AllClasses.FrozenProduct;
import AllClasses.Product;
import AllClasses.SaleInfo;

@SuppressWarnings("serial")
public class FrozenProductPanel extends FridgeProductPanel {

	
	public FrozenProductPanel(String title) {
		super(title);
	}

	public Product createProduct(String theName, String barCode, Date expD, SaleInfo saleData, int priceToStore,int priceToCustomer, int amount) throws Exception {
		FrozenProduct  prod = new FrozenProduct(theName, barCode, expD, saleData, priceToStore, priceToCustomer, amount,getTemprature() );
		return prod;
	}

}
