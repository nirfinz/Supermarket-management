package AllClasses;

public class SaleInfo implements Cloneable{
	
	private Date	startSale;
	private Date	endSale;
	private float 	prec;
	
	public SaleInfo(Date startSale, Date endSale, float prec) throws Exception {
		this.startSale = startSale;
		this.endSale = endSale;
		setPrec(prec);
	}
	
	@Override
	protected SaleInfo clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (SaleInfo)super.clone();
	}
		
	public void updateSaleInfo(SaleInfo other){
		this.startSale = other.startSale;
		this.endSale = other.endSale;
		this.prec = other.prec;
	}

	public float getPrec() {
		return prec;
	}

	public void setPrec(float prec) throws Exception {
		if(prec < 0 || prec  > 100)
			throw new Exception("invalid sale precentage");
		this.prec = prec;
	}

	@Override
	public String toString() {
		return "SaleInfo From:" + startSale + " to:" + endSale+ " " + prec;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleInfo other = (SaleInfo) obj;
		if (endSale == null) {
			if (other.endSale != null)
				return false;
		} else if (!endSale.equals(other.endSale))
			return false;
		if (startSale == null) {
			if (other.startSale != null)
				return false;
		} else if (!startSale.equals(other.startSale))
			return false;
		return true;
	}

		

}
