package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import AllClasses.*;

@SuppressWarnings("serial")
public abstract class BasePanel extends JPanel {
	
public final static int PANEL_HEIGHT = 80;
	
	public BasePanel(String title){
		super(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createTitledBorder(title));
		setPreferredSize(new Dimension(AddProductPanel.PANEL_WIDTH-5,PANEL_HEIGHT));
	}

	public abstract void clean();

	public abstract Product createProduct(String theName, String barCode, Date expD,
			SaleInfo saleData, int priceToStore, int priceToCustomer,
			int amount) throws Exception;
}
