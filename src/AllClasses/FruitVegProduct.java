package AllClasses;

public class FruitVegProduct extends NonFridgeProduct {

	private boolean bPackage;

	public FruitVegProduct(String name, String barcode, Date expDate,
			SaleInfo saleData, float priceToStore, float priceToCustomer,
			int amount, boolean bPackage) throws Exception {
		super(name, barcode, expDate, saleData, priceToStore, priceToCustomer,
				amount);
		this.bPackage = bPackage;
	}

	@Override
	public String toString() {
		return super.toString() + " In Package= " + bPackage+"\n";
	}
	
	public void maintenance(){
		if(bPackage)
			System.out.println(name + " Need to check the package");
		else
			System.out.println(name + " See if need to throw away");
	}
	
}
