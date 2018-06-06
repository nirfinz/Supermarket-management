package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

import AllClasses.*;

@SuppressWarnings("serial")
public class AddProductDialog extends JDialog {
	
	public static final String TITLE = "Add a Product Dialog";
	
	public AddProductDialog (SuperMarket market,SuperMarketPanel marketP){
		super((JFrame)null,true);
		setTitle(TITLE);
		AddProductPanel addProductPanel = new AddProductPanel(market);
		add(addProductPanel);
		setSize(AddProductPanel.PANEL_WIDTH+10,AddProductPanel.FEILDS_HEIGHT+200);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
}
