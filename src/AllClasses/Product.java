package AllClasses;

public abstract class Product implements Cloneable{

	protected String 	name;
	private String 		barcode;
	private Date		expDate;
	private SaleInfo	saleData;
	private float		priceToStore;
	private float		priceToCustomer;
	private int 		amount;
	
	
	
	
	public Product(String name, String barcode, Date expDate,
			SaleInfo saleData, float priceToStore, float priceToCustomer,
			int amount) throws Exception {
		this.name = name;
		this.barcode = barcode;
		if(expDate!= null)
			this.expDate = expDate.clone();
		if(saleData!= null)
			this.saleData = saleData.clone();
		setPriceToStore(priceToStore);
		setPriceToCustomer(priceToCustomer);
		setAmount(amount);
	}

	@Override
	protected Product clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Product temp =  (Product)super.clone();
		if(expDate!= null)
			temp.expDate = expDate.clone();
		if(saleData!= null)
			temp.saleData = saleData.clone();
		return temp;
	}
	
	public float getPriceToStore() {
		return priceToStore;
	}


	public void setPriceToStore(float priceToStore) throws Exception {
		ValidNumbers.IsPositiveNoZero((int)priceToStore,"price must be grater than zero");
		this.priceToStore = priceToStore;
	}


	public float getPriceToCustomer() {
		
		if(saleData != null)
			return priceToCustomer*((100F-saleData.getPrec())/100.0F);
		else
			return priceToCustomer;
	}


	public void setPriceToCustomer(float priceToCustomer) throws Exception {
		ValidNumbers.IsPositiveNoZero((int)priceToCustomer,"price must be grater than zero");
		this.priceToCustomer = priceToCustomer;
	}


	public int getAmount() {
		return amount;
	}


	public String getBarcode() {
		return barcode;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setAmount(int amount) throws Exception {
		ValidNumbers.IsPositive(amount,"amount must be grater than zero");
		this.amount = amount;
	}
	
	//delta can be negative in case a customer bought the product
	public boolean updateAmount(int delta){
		if ( (amount + delta) < 0)
			return false;
		
		amount += delta;
		return true;
	}
	
	public void startSale(SaleInfo info) throws CloneNotSupportedException{
		if(info!= null)
			this.saleData = info.clone();
	}
	
	public void endSale(){
		this.saleData = null;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName() + " "+ name + ", barcode=" + barcode + ", expDate="
				+ expDate);
		if(saleData!= null)
			sb.append(" "+saleData);
		else
			sb.append(" Not on Sale");
		sb.append(", priceToStore="+ priceToStore + ", priceToCustomer=" + priceToCustomer
				+ ", amount=" + amount);
		return sb.toString();
	}


	
	public String getName() {
		return name;
	}
	
	public String checkExpDate(){
		if(expDate == null)
			return name + " no exp date";
		else
			return name + " ,It is about time to check its exp date";
	}
		
}
















