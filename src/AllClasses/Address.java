package AllClasses;

public class Address implements Cloneable{
	private String street;
	private String city;
	private int	number;
	
	public Address(String city,String street,int number) throws Exception {
		this.street = street;
		this.city = city;
		setNumber(number);
	}
	
	

	public Address clone() throws CloneNotSupportedException{
		return (Address)super.clone();
	}
	
	public void updateAddress(Address other) {
		street = other.street;
		city = other.city;
		number = other.number;
	
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws Exception {
		ValidNumbers.IsPositiveNoZero(number,"Street num must be grater then zero" );
		this.number = number;
	}
	
	public String toString() {
		return "Address: " + street + " " + number + " " + city;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + number;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (number != other.number)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	
}
