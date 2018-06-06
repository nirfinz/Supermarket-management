package AllClasses;

public class MemberCustomer extends Customer implements OnMonthable {
	
	private String 	iDCard;
	private int 	years;
	private float	totalBuy;
	
	public MemberCustomer(String name, int age, boolean male, String iDCard,
			int years, float totalBuy) throws Exception {
		super(name, age, male);
		this.iDCard = iDCard;
		ValidNumbers.IsPositive(years,"Years not valid");
		this.years = years;
		ValidNumbers.IsPositive((int)totalBuy,"TotalBuy not valid");
		this.totalBuy = totalBuy;
	}

	@Override
	public String toString() {
		return super.toString() +  " iDCard=" + iDCard + ", years=" + years
				+ ", totalBuy=" + totalBuy;
	}

	public boolean buy(String prodName){
		if (!super.buy(prodName))
			return false;
		
		Product prd = superIn.getProductByName(prodName);
		
		totalBuy += prd.getPriceToCustomer();
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberCustomer other = (MemberCustomer) obj;
		if (iDCard == null) {
			if (other.iDCard != null)
				return false;
		} else if (!iDCard.equals(other.iDCard))
			return false;
		return true;
	}

	public void incYears() {
		years++;
	}

	@Override
	public void onMonth() {
		totalBuy = 0;
		System.out.println(name + " did not get the time to used my monthly coupons");
	}
	
	
}
