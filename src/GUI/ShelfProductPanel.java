package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.Location;
import AllClasses.Product;
import AllClasses.SaleInfo;
import AllClasses.ShelfProduct;
import AllClasses.ValidNumbers;
import AllClasses.ShelfProduct.packageType;

@SuppressWarnings("serial")
public class ShelfProductPanel extends BasePanel implements ActionListener{

	public static final int R_WIDTH = 100;
	public static final int R_HEIGHT = 20;

	private	packageType type;
	private JRadioButton[] buttons;
	private JFormattedTextField col;
	private JFormattedTextField row;
	
	
	public ShelfProductPanel(String title) {
		super(title);
		packageType[] types = packageType.values();
		buttons = new JRadioButton[types.length];
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JRadioButton(types[i].name());
			buttons[i].setActionCommand(types[i].name());
			buttons[i].addActionListener(this);
		}
		buttons[0].setSelected(true);
		type = types[0];
		ButtonGroup group = new ButtonGroup();
		for(int i = 0; i < buttons.length; i++)
			group.add(buttons[i]);

		JPanel radioPanel = new JPanel(new GridLayout(1,buttons.length));
		for(int i = 0; i < buttons.length; i++)
			radioPanel.add(buttons[i]);
		radioPanel.setSize(new Dimension(R_WIDTH,R_HEIGHT));
		add(radioPanel, BorderLayout.LINE_START);

		row =  FormattedTextHelper.createIntegerText(0,Integer.MAX_VALUE,R_WIDTH,R_HEIGHT);
		col =  FormattedTextHelper.createIntegerText(0,Integer.MAX_VALUE,R_WIDTH,R_HEIGHT);

		JLabel labelRow = new JLabel("Row:");
		JLabel labelCol = new JLabel("Col:");

		add(labelRow);
		add(row);
		add(labelCol);
		add(col);
		add(radioPanel);


		layout.putConstraint(SpringLayout.WEST, labelRow, 5,SpringLayout.WEST,this );
		layout.putConstraint(SpringLayout.WEST, row, 5,SpringLayout.EAST,labelRow );
		layout.putConstraint(SpringLayout.WEST, labelCol, 5,SpringLayout.EAST,row );
		layout.putConstraint(SpringLayout.WEST, col, 5,SpringLayout.EAST,labelCol );
		layout.putConstraint(SpringLayout.NORTH,radioPanel, 5,SpringLayout.SOUTH,labelRow );
	}
	
	public void clean() {
		buttons[0].setSelected(true);
		type = packageType.values()[0];
		if(row!= null)
			row.setText(null);
		
		if(col!= null)
			col.setText(null);
	}

	public Product createProduct(String theName, String barCode, Date expD, SaleInfo saleData, int priceToStore,int priceToCustomer, int amount) throws Exception {
		String sRow = row.getText();
		String sCol = col.getText();
		ValidNumbers.checkString(sRow,"Row must be given");
		ValidNumbers.checkString(sCol,"Col must be given");
		
		int col = Integer.parseInt(sCol);
		int row = Integer.parseInt(sRow);

		Location location = new Location(row, col);

		ShelfProduct prod = new ShelfProduct(theName, barCode, expD, saleData, 
				priceToStore, priceToCustomer, amount, location, type);

		return prod;
	}

	
	public void actionPerformed(ActionEvent e) {
		type = packageType.valueOf(e.getActionCommand());
	}
	
	public packageType getType() {
		return type;
	}

}
