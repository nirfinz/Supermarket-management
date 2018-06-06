package GUI;

import javax.swing.table.AbstractTableModel;
import AllClasses.*;

@SuppressWarnings("serial")
public class MyTableModel extends AbstractTableModel {
	
	public final static String[] COLS_NAME =  {"Barcode","Name","Exp Date"};
	private SuperMarket market;
	
	
	 public MyTableModel(SuperMarket market) {
		this.market = market;
	}
	
	
	public int getColumnCount() {
		return COLS_NAME.length;
	}

	
	public int getRowCount() {
		return market.getProdCount();
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product p = market.getProductVector().elementAt(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getBarcode();
		case 1:
			return p.getName();
		case 2:
			return (p.getExpDate()!= null )? p.getExpDate():"None";
		default:
			return null;
		}
	}
	
	public String getColumnName(int column) {
		return COLS_NAME[column];
	}

}
