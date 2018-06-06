package AllClasses;

public abstract class NonFridgeProduct extends Product {

	public NonFridgeProduct(String name, String barcode, Date expDate,
			SaleInfo saleData, float priceToStore, float priceToCustomer,
			int amount) throws Exception {
		super(name, barcode, expDate, saleData, priceToStore, priceToCustomer, amount);
	}
	
	//no need for toString same as father
	public abstract void maintenance();
}
