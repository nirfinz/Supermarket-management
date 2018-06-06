package AllClasses;

public class FridgeProduct extends Product {

	private int	temprature;
	public final static int MAX_TEMP = 4; 

		
	public FridgeProduct(String name, String barcode, Date expDate,
			SaleInfo saleData, float priceToStore, float priceToCustomer,
			int amount, int temprature) throws Exception {
		super(name, barcode, expDate, saleData, priceToStore, priceToCustomer,
				amount);
		setTemprature(temprature);
	}

	
	public int getTemprature() {
		return temprature;
	}


	public void setTemprature(int temprature) throws Exception {
		if(temprature > MAX_TEMP)
			throw new Exception("Temprature for fridge product must be less than " + MAX_TEMP);
		this.temprature = temprature;
	}


	@Override
	public String toString() {
		return super.toString() + " Temperature= " + temprature+"\n";
	}

	public void electricFault(){
		System.out.println(name+ " Need to check the generator");
	}
	
}
