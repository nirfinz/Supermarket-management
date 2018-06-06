package AllClasses;

public class Customer implements Cloneable,Comparable<Customer>{
	protected String 	name;
	private boolean		male;
	private int 		age;
	protected SuperMarket superIn;
	private int			iD;
	
	public static final int ID_START = 1000;
	private static int IDGen=ID_START;

	public Customer(String name,int age, boolean male) throws Exception {
		this.name = name;
		setAge(age);
		this.male = male;
		iD = IDGen++;
	}

	@Override
	protected Customer clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Customer)super.clone();
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName()+" " +name + " ID " + iD + " of age " + age);
		if (male)
			sb.append(" is male ");
		else
			sb.append(" is female ");
		if (superIn!=null)
			sb.append("I am in store " + superIn.getName());
		else
			sb.append("I am  currently out of the store");
		return sb.toString();
	}
	
	public void doBirthDay(){
		age++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iD;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (iD != other.iD)
			return false;
		return true;
	}

	@Override
	public int compareTo(Customer arg0) {
		return iD-arg0.iD;
	}
	
	
		public void setSuperIn(SuperMarket superIn) {
		this.superIn = superIn;
	}
	
	public boolean buy(String prodName){
		if (superIn == null)
			return false;
		
		return  superIn.buy(prodName);
		
	}

	private void setAge(int age) throws Exception {
		ValidNumbers.IsPositiveNoZero(age,"Age must be > 0");
		this.age = age;
	}
}
