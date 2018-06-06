package GUI;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.FruitVegProduct;
import AllClasses.Product;
import AllClasses.SaleInfo;

@SuppressWarnings("serial")
public class FruitVegProductPanel extends BasePanel {

	private JCheckBox buttonPackage;
	
	public FruitVegProductPanel(String title) {
		super(title);
		buttonPackage = new JCheckBox();
		JLabel packageLable = new JLabel("In package?");
		add(packageLable);
		add(buttonPackage);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		layout.putConstraint(SpringLayout.WEST, packageLable, 0,SpringLayout.WEST,this );
		layout.putConstraint(SpringLayout.WEST, buttonPackage, 5,SpringLayout.EAST,packageLable );
	}
	
	public void clean() {
		if(buttonPackage!= null)
			buttonPackage.setSelected(false);
	}
	
	public Product createProduct(String theName, String barCode, Date expD, SaleInfo saleData, int priceToStore,int priceToCustomer, int amount) throws Exception {
		FruitVegProduct  prod = new FruitVegProduct(theName, barCode, expD, saleData,priceToStore, priceToCustomer, amount, buttonPackage.isSelected());
		return prod;
	}

}
