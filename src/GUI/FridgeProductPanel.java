package GUI;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.FridgeProduct;
import AllClasses.Product;
import AllClasses.SaleInfo;

@SuppressWarnings("serial")
public class FridgeProductPanel extends BasePanel {

	private JTextField	tempratureText;
	
	public FridgeProductPanel(String title) {
		super(title);
		tempratureText = new JTextField(10);
		JLabel tempLable = new JLabel("Temperature:"); 
		add(tempLable);
		add(tempratureText);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		layout.putConstraint(SpringLayout.WEST, tempLable, 0,SpringLayout.WEST,this );
		layout.putConstraint(SpringLayout.WEST, tempratureText, 5,SpringLayout.EAST,tempLable );
	}
	
	
	public void clean() {
		if(tempratureText != null)
			tempratureText.setText(null);
	}

	public Product createProduct(String theName, String barCode, Date expD, SaleInfo saleData, int priceToStore,int priceToCustomer, int amount) throws Exception {
		FridgeProduct  prod = new FridgeProduct(theName, barCode, expD, saleData, priceToStore, priceToCustomer, amount, getTemprature());
		return prod;
	}
	
	public int getTemprature() throws Exception{
		if(tempratureText == null)
			return 0;
		String temp = tempratureText.getText();
		if(temp == null || temp.isEmpty())
			throw new Exception("Temp must be given");
	
		return Integer.parseInt(tempratureText.getText());
	}

}
