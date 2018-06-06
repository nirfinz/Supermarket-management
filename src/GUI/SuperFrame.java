package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import AllClasses.SuperMarket;



@SuppressWarnings("serial")
public class SuperFrame extends JFrame {
	
public final static  String TITLE = "Manage Products in market ";
	
	public SuperFrame (SuperMarket s) throws Exception{
		super(TITLE + s.getName());
		JPanel mainPanel = new SuperMarketPanel(s);
		
		add(mainPanel);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
		setVisible(true);
	}
}
