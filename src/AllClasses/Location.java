package AllClasses;

public class Location implements Cloneable{
	private int row;
	private int col;
	
	public Location(int row, int col) throws Exception {
		setRow(row);
		setCol(col);
	}
	

	public Location clone() throws CloneNotSupportedException{
		return (Location)super.clone();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) throws Exception {
		ValidNumbers.IsPositive(row,"row must be positive" );
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) throws Exception {
		ValidNumbers.IsPositive(col,"col must be positive" );
		this.col = col;
	}

	@Override
	public String toString() {
		return "Location row=" + row + ", col=" + col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
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
		Location other = (Location) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}
