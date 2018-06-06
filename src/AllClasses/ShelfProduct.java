package AllClasses;

public class ShelfProduct extends NonFridgeProduct implements OnMonthable {

	public enum packageType {Glass,Cardboard,Plastic};
	private Location	location;
	private	packageType	type;
	
	
	public ShelfProduct(String name, String barcode, Date expDate,
			SaleInfo saleData, float priceToStore, float priceToCustomer,
			int amount, Location location,packageType type) throws Exception {
		super(name, barcode, expDate, saleData, priceToStore, priceToCustomer,
				amount);
		this.location = location.clone();
		this.type = type;
	}

	protected ShelfProduct clone() throws CloneNotSupportedException {
		ShelfProduct temp = (ShelfProduct)super.clone();
		temp.location = location.clone();
		return temp;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " " + location+ " package " + type +"\n";
	}
	
	public void maintenance(){
		System.out.println(name + " Need to clean the dust");
	}

	@Override
	public void onMonth() {
		System.out.println(name + " I am being turned");
		
	}
	
}
