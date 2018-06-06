package AllClasses;

public class Date implements Cloneable,Comparable<Date>{

	final static int MAX_MONTH = 12;
	
	//We Assume that Feb always has 29 days (simple)
	final static int DAY_MONTH_LIMIT[] = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) throws Exception {
		setDate(day,month,year);
	}
	
	@Override
	protected Date clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Date)super.clone();
	}
	
	@Override
	public String toString() {
		return day + "/" + month + "/"+ year;
	}
	
	public boolean setDate(int d,int m, int y) throws Exception{
		if(d<=0 || m<=0 || y<= 0)
			throw new Exception("Invalid date");
		
		if(d > DAY_MONTH_LIMIT[m-1])
			throw new Exception("Invalid date");
		
		day = d;
		month = m;
		year = y;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Date d) {
		if(year > d.year)
			return 1;
		if(year < d.year)
			return -1;
		if(month > d.month)
			return 1;
		if(month<d.month)
			return -1;
		if(day > d.day)
			return 1;
		if(day < d.day)
			return -1;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	
}
