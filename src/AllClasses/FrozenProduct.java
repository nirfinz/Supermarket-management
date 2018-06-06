package AllClasses;

public class FrozenProduct extends FridgeProduct {

	
	
	public FrozenProduct(String name, String barcode, Date expDate,
			SaleInfo saleData, float priceToStore, float priceToCustomer,
			int amount, int temprature) throws Exception {
		super(name, barcode, expDate, saleData, priceToStore, priceToCustomer, amount,
				temprature);
	}

	public void setTemprature(int temprature) throws Exception {
		if(temprature > 0)
			throw new Exception("Temprature for frozen product must be less than 0");
		super.setTemprature(temprature);
	}
	
	//no need for toString same as father
	
	public String checkExpDate(){
		return name + " For frozen it is a waste of checking";
	}
	
	
	public void electricFault(){
		super.electricFault();
		System.out.println("This is a big problem");
	}
	
}
