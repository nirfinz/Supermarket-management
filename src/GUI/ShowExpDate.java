package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

import AllClasses.*;

@SuppressWarnings("serial")
public class ShowExpDate extends JDialog {

	public static final String TITLE = "Periodical Dialog"; 
	public ShowExpDate (SuperMarket market){
		super((JFrame)null,true);
		setTitle(TITLE);
		ShowExpDatePanel expDatePanel = new ShowExpDatePanel(market);
		
		add(expDatePanel);
		pack();
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
}
