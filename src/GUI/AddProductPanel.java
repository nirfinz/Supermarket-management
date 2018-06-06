package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.Product;
import AllClasses.SaleInfo;
import AllClasses.SuperMarket;
import AllClasses.ValidNumbers;


@SuppressWarnings("serial")
public class AddProductPanel extends JPanel {
	
	public final static int PANEL_WIDTH = 350;
	public final static int LENGTH_TEXTFIELD = 20;
	public final static int PRICE_WIDTH = 100;
	public final static int PRICE_HEIGHT = 20;
	public final static int MIN_VALUE = 0;
	public final static int SALE_HEIGHT= 125;
	public final static int EXP_DATE_HEIGHT= 80;
	public final static int FEILDS_HEIGHT= SALE_HEIGHT+EXP_DATE_HEIGHT+130;
	public final static int MAX_PERCENT = 100;
	public final static int PERCENT_WIDTH = 30;
	
	public enum productType {Shelf,FruitVeg,Fridge,Frozen};
	
	private JComboBox<productType> productList;
	private JTextField productName;
	private JTextField barcode;
	private JCheckBox buttonExpDate;
	private DatePanel expDate;
	private JCheckBox buttonSale;
	private DatePanel startSale;
	private DatePanel endSale;
	private JFormattedTextField percent;
	private JFormattedTextField priceMarket;
	private JFormattedTextField priceCustomer;
	private JFormattedTextField amount;
	private BasePanel productPanel = null;
	private JPanel productComboBox;
	private JPanel allTheFields;
	private BasePanel [] panelArr = new BasePanel[4];
	private JButton add;
	private SpringLayout mLayout;
	private SuperMarket market;
	
	public AddProductPanel (SuperMarket market){
		this.market = market;
		mLayout = new SpringLayout();
		setLayout(mLayout);
		setPreferredSize(new Dimension(PANEL_WIDTH, 1200));
		createPanelCombo();
		createAllTheFields();
		
		panelArr[0] = new ShelfProductPanel("Shelf");
		panelArr[1] = new FruitVegProductPanel("Fruit and Vegetable");
		panelArr[2] = new FridgeProductPanel("Fridge");
		panelArr[3] = new FrozenProductPanel("Frozen");
		
		for(int i = 1; i < panelArr.length; i++)
			panelArr[i].setVisible(false);

		productPanel = panelArr[0];
		
		createAddButton();
		
		add(productComboBox); 
		add(allTheFields);
		add(productPanel);
		add(add);
		
		mLayout.putConstraint(SpringLayout.WEST, productComboBox, 5,SpringLayout.WEST,this );
		mLayout.putConstraint(SpringLayout.NORTH, allTheFields, 15,SpringLayout.SOUTH,productComboBox );
		mLayout.putConstraint(SpringLayout.WEST,productPanel,5,SpringLayout.WEST,this);			
		mLayout.putConstraint(SpringLayout.NORTH,productPanel, 5,SpringLayout.SOUTH,allTheFields );
		mLayout.putConstraint(SpringLayout.NORTH,add, 5,SpringLayout.SOUTH,productPanel );
		mLayout.putConstraint(SpringLayout.WEST,add, PANEL_WIDTH/2-20,SpringLayout.WEST,this);


	}

	public void createAllTheFields() {
		
		allTheFields = new JPanel();
		SpringLayout layout = new SpringLayout();
		allTheFields.setLayout(layout);
		allTheFields.setPreferredSize(new Dimension(PANEL_WIDTH,FEILDS_HEIGHT));
		
		JLabel labelName = new JLabel("Product Name:");
		productName = new JTextField(LENGTH_TEXTFIELD);
		JLabel labeBarcode = new JLabel("Barcode:");
		barcode = new JTextField(LENGTH_TEXTFIELD);
		
		JPanel expDatePanle = createExpDatePanel();
		JPanel salePanle = createSalePanel();
		
		priceMarket =  FormattedTextHelper.createIntegerText(MIN_VALUE,Integer.MAX_VALUE,PRICE_WIDTH,PRICE_HEIGHT);
		priceCustomer =  FormattedTextHelper.createIntegerText(MIN_VALUE,Integer.MAX_VALUE,PRICE_WIDTH,PRICE_HEIGHT);
		amount =  FormattedTextHelper.createIntegerText(MIN_VALUE,Integer.MAX_VALUE,PRICE_WIDTH,PRICE_HEIGHT);


		JLabel labelPriceMarket = new JLabel("Price to Market:");
		JLabel labelPriceCustomer = new JLabel("Price to Customer:");
		JLabel labelAmount = new JLabel("Amount:");

		allTheFields.add(labelName);
		allTheFields.add(productName);
		allTheFields.add(labeBarcode);
		allTheFields.add(barcode);
		allTheFields.add(expDatePanle);
		allTheFields.add(salePanle);
		allTheFields.add(labelPriceMarket);
		allTheFields.add(priceMarket);
		allTheFields.add(labelPriceCustomer);
		allTheFields.add(priceCustomer);
		allTheFields.add(labelAmount);
		allTheFields.add(amount);
		
		layout.putConstraint(SpringLayout.WEST, labelName, 5,SpringLayout.WEST,allTheFields );
		layout.putConstraint(SpringLayout.WEST, productName, 5,SpringLayout.EAST,labelName );
		layout.putConstraint(SpringLayout.NORTH,labeBarcode, 5,SpringLayout.SOUTH,productName );
		layout.putConstraint(SpringLayout.WEST, labeBarcode, 5,SpringLayout.WEST,allTheFields);
		layout.putConstraint(SpringLayout.NORTH,barcode, 5,SpringLayout.SOUTH,productName );
		layout.putConstraint(SpringLayout.WEST,barcode, 5,SpringLayout.EAST,labelName );
		layout.putConstraint(SpringLayout.WEST, expDatePanle, 5,SpringLayout.WEST,allTheFields );
		layout.putConstraint(SpringLayout.NORTH,expDatePanle, 5,SpringLayout.SOUTH,barcode );
		layout.putConstraint(SpringLayout.WEST, salePanle, 5,SpringLayout.WEST,allTheFields );
		layout.putConstraint(SpringLayout.NORTH,salePanle, 5,SpringLayout.SOUTH,expDatePanle );
		layout.putConstraint(SpringLayout.WEST, labelPriceMarket,5,SpringLayout.WEST,allTheFields );
		layout.putConstraint(SpringLayout.NORTH,labelPriceMarket, 5,SpringLayout.SOUTH,salePanle );
		layout.putConstraint(SpringLayout.WEST, priceMarket,20,SpringLayout.EAST,labelPriceMarket );
		layout.putConstraint(SpringLayout.NORTH,priceMarket, 5,SpringLayout.SOUTH,salePanle );
		layout.putConstraint(SpringLayout.WEST, labelPriceCustomer,5,SpringLayout.WEST,allTheFields );
		layout.putConstraint(SpringLayout.NORTH,labelPriceCustomer, 8,SpringLayout.SOUTH,labelPriceMarket );
		layout.putConstraint(SpringLayout.WEST, priceCustomer, 5,SpringLayout.EAST,labelPriceCustomer );
		layout.putConstraint(SpringLayout.NORTH,priceCustomer, 8,SpringLayout.SOUTH,labelPriceMarket );
		layout.putConstraint(SpringLayout.WEST, labelAmount,5,SpringLayout.WEST,allTheFields );
		layout.putConstraint(SpringLayout.NORTH,labelAmount, 8,SpringLayout.SOUTH,labelPriceCustomer );
		layout.putConstraint(SpringLayout.WEST, amount, 64,SpringLayout.EAST,labelAmount );
		layout.putConstraint(SpringLayout.NORTH,amount, 8,SpringLayout.SOUTH,labelPriceCustomer );
		
	}

	public JPanel createSalePanel() {
		JPanel saleP = new JPanel();
		JLabel labelSale = new JLabel("On Sale?");
		saleP.setPreferredSize(new Dimension(PANEL_WIDTH-5, SALE_HEIGHT));
		saleP.setBorder(BorderFactory.createTitledBorder("Sale Info"));
		buttonSale = new JCheckBox();
		buttonSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSale.setEdit(buttonSale.isSelected());
				endSale.setEdit(buttonSale.isSelected());
				percent.setEditable(buttonSale.isSelected());
				if(!buttonSale.isSelected())
					cleanSaleInfo();
			}
		});


		startSale = new DatePanel("Start Date");	
		endSale = new DatePanel("End Date");
		percent =  FormattedTextHelper.createIntegerText(0,100,30,20);
		JLabel labelPrec = new JLabel("Precent:");

		saleP.add(labelSale);
		saleP.add(buttonSale);
		saleP.add(startSale);
		saleP.add(endSale);
		saleP.add(labelPrec);
		saleP.add(percent);

		SpringLayout layout = new SpringLayout();
		saleP.setLayout(layout);

		layout.putConstraint(SpringLayout.WEST, labelSale, 0,SpringLayout.WEST,saleP );
		layout.putConstraint(SpringLayout.WEST, buttonSale, 5,SpringLayout.EAST,labelSale );
		layout.putConstraint(SpringLayout.WEST, startSale, 0,SpringLayout.WEST,saleP );
		layout.putConstraint(SpringLayout.NORTH, startSale, 5,SpringLayout.SOUTH,labelSale );
		layout.putConstraint(SpringLayout.WEST, endSale, 0,SpringLayout.WEST,saleP );
		layout.putConstraint(SpringLayout.NORTH, endSale, 5,SpringLayout.SOUTH,startSale );
		layout.putConstraint(SpringLayout.WEST, labelPrec, 0,SpringLayout.WEST,saleP );
		layout.putConstraint(SpringLayout.NORTH, labelPrec, 5,SpringLayout.SOUTH,endSale );
		layout.putConstraint(SpringLayout.WEST, percent, 5,SpringLayout.EAST,labelPrec );
		layout.putConstraint(SpringLayout.NORTH, percent, 5,SpringLayout.SOUTH,endSale );
		
		saleP.setPreferredSize(new Dimension(PANEL_WIDTH-5, SALE_HEIGHT));
		saleP.setBorder(BorderFactory.createTitledBorder("Sale Info"));

		startSale.setEdit(buttonSale.isSelected());
		endSale.setEdit(buttonSale.isSelected());
		percent.setEditable(buttonSale.isSelected());
		return saleP;
	}

	public JPanel createExpDatePanel() {
		JPanel expP = new JPanel();
		JLabel labelExp = new JLabel("Exp Date?");
		
		expDate = new DatePanel("Exp Date");
		buttonExpDate = new JCheckBox();
		buttonExpDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expDate.setEdit(buttonExpDate.isSelected());
				if(!buttonExpDate.isSelected())
					cleanExpDateInfo();
			}
		});
		
		expP.add(labelExp);
		expP.add(buttonExpDate);
		expP.add(expDate);
		SpringLayout layout = new SpringLayout();
		expP.setLayout(layout);

		layout.putConstraint(SpringLayout.WEST, labelExp, 0,SpringLayout.WEST,expP );
		layout.putConstraint(SpringLayout.WEST, buttonExpDate, 5,SpringLayout.EAST,labelExp );
		layout.putConstraint(SpringLayout.WEST, expDate, 0,SpringLayout.WEST,expP );
		layout.putConstraint(SpringLayout.NORTH, expDate, 5,SpringLayout.SOUTH,labelExp );
		
		expP.setPreferredSize(new Dimension(PANEL_WIDTH-5, EXP_DATE_HEIGHT));
		expP.setBorder(BorderFactory.createTitledBorder("Exp Date Info"));
		expDate.setEdit(buttonExpDate.isSelected());
		return expP;
	}
	
	public void createPanelCombo(){
		productList = new JComboBox<productType>(productType.values());
		productList.setPreferredSize(new Dimension(200, 20));
		productList.setSelectedIndex(0);

		productList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = productList.getSelectedIndex();
				if(index != -1)
					CorrectPanel(index);
			}
		});


		productComboBox = new JPanel();
		JLabel labelT = new JLabel("Product Type:");
		productComboBox.add(labelT);
		productComboBox.add(productList);
	}
	
	public void CorrectPanel(int index) {
		if(productPanel!= null){
			productPanel.setVisible(false);
			remove(productPanel);
			remove(add);
		}
		productPanel = panelArr[index];
		add(productPanel);
		productPanel.setVisible(true);
		add(add);
		mLayout.putConstraint(SpringLayout.WEST,productPanel,5,SpringLayout.WEST,this);			
		mLayout.putConstraint(SpringLayout.NORTH,productPanel, 5,SpringLayout.SOUTH,allTheFields );
		mLayout.putConstraint(SpringLayout.NORTH,add, 5,SpringLayout.SOUTH,productPanel );
		mLayout.putConstraint(SpringLayout.WEST,add, PANEL_WIDTH/2-20,SpringLayout.WEST,this);
	}
	
	private void createAddButton(){
		add = new JButton("Add");
		add.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					createProduct();
					cleanFields();
					productPanel.clean();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void createProduct() throws Exception {
		try{
			String theName =  getName();
			String barCode =  getBarcode();
			ValidNumbers.checkString(theName,"Name must be given");
			ValidNumbers.checkString(barCode,"Barcode must be given");
			Date expD = null;
			if(buttonExpDate.isSelected())
				expD = expDate.getDate();
			
			SaleInfo saleData = null;
			if(buttonSale.isSelected()){
				int prec = Integer.parseInt(percent.getText());			
				saleData = new SaleInfo(startSale.getDate(),endSale.getDate(), prec);
			}
			String sPriceMarket = priceMarket.getText();
			String sPriceCustomer = priceCustomer.getText();
			String sAmount = amount.getText();
			ValidNumbers.checkString(sPriceMarket,"Price to market must be given");
			ValidNumbers.checkString(sPriceCustomer,"Price to customer must be given");
			ValidNumbers.checkString(sAmount,"Amount must be given");
			int priceToStore = Integer.parseInt(sPriceMarket);
			int priceToCustomer = Integer.parseInt(sPriceCustomer);
			int amountI = Integer.parseInt(sAmount);
			Product prod = productPanel.createProduct(theName,barCode,expD,saleData,priceToStore,priceToCustomer,amountI);
			if(!market.addProduct(prod))
				JOptionPane.showMessageDialog(this,"Not added!!! already in super market!!");
			else {
				JOptionPane.showMessageDialog(this,prod + " was added");
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,"Data in dialog is incorrecrt, " + e.getMessage()+ " product was not added");
		}
	}
	
	protected void cleanExpDateInfo(){
		if(buttonExpDate != null)
			buttonExpDate.setSelected(false);
		if(expDate != null)
			expDate.clean();
		expDate.setEdit(false);
	}
	
	protected void cleanSaleInfo(){
		if(buttonSale != null)
			buttonSale.setSelected(false);
		if(startSale != null)
			startSale.clean();
		if(endSale!= null)
			endSale.clean();
		if(percent!= null)
			percent.setText(null);	
		startSale.setEdit(false);
		endSale.setEdit(false);
		percent.setEditable(false);
	
	}
	
	protected void cleanFields() {
		if(productName!=null)
			productName.setText(null);
		if(barcode != null)
			barcode.setText(null);
		cleanExpDateInfo();
		cleanSaleInfo();
		if(priceMarket!= null)
			priceMarket.setText(null);	
		if(priceCustomer!= null)
			priceCustomer.setText(null);	
		if(amount!= null)
			amount.setText(null);	
	}
	
	public String getName() {
		if( productName == null)
			return null;
		return productName.getText();
	}

	public String getBarcode() {
		if( barcode == null)
			return null;
		return barcode.getText();
	}

	
	
	
	
}
