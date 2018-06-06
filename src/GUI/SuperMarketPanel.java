package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import AllClasses.*;


@SuppressWarnings("serial")
public class SuperMarketPanel extends JPanel {
	
	public final static int MAX_BUTTONS = 6;
	public final static int TABEL_WIDTH = 250;
	public final static int TABEL_HEIGHT = 120;
	public final static int TEXT_WIDTH=250;
	public final static int TEXT_HEIGHT = 100;
	
	private MyTableModel tableModel;
	private JTable	tblProducts;
	private JScrollPane scrollerProduct;
	private JTextArea text;
	private SuperMarket market;
	private SpringLayout mainPanelLayout;
	private JButton addButton;
	private JButton remove;
	private JButton sortByName;
	private JButton sortByBarcode;
	private JButton sortByDate;
	private JButton expDate;

	public SuperMarketPanel (SuperMarket market){
		this.market=market;
		mainPanelLayout = new SpringLayout();
		setLayout(mainPanelLayout);
		setPreferredSize(new Dimension(520,300));
		JPanel tablePanel = createTablePanle();
		JPanel boxLayout = createBoxLayoutPanel();
		JPanel 	textArea = createTextArea();
		
		textArea.setBorder(new LineBorder(Color.RED));
		tblProducts.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent mouse) {
				int row = tblProducts.getSelectedRow();
				String barcode =(String) tblProducts.getValueAt(row, 0);
				Product p = market.getProductByBarcode(barcode);
				text.setText(p.toString());
				remove.setEnabled(true);
			}
		});
		
		add(textArea);
		add(tablePanel);
		add(boxLayout);
		
		mainPanelLayout.putConstraint(SpringLayout.WEST, tablePanel, 10, SpringLayout.WEST, this);
		mainPanelLayout.putConstraint(SpringLayout.NORTH, tablePanel, 10, SpringLayout.NORTH, this);
		mainPanelLayout.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.SOUTH, tablePanel);
		mainPanelLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		mainPanelLayout.putConstraint(SpringLayout.WEST, boxLayout, 10, SpringLayout.EAST, tablePanel);
		mainPanelLayout.putConstraint(SpringLayout.NORTH, boxLayout, 40, SpringLayout.NORTH, this);

	}

	public JPanel createTextArea() {
		JPanel textAreaPanel = new JPanel();
		text = new JTextArea();
		text.setPreferredSize(new Dimension(TEXT_WIDTH,TEXT_HEIGHT));
		text.setEditable(false);
		text.setBackground(Color.WHITE);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		textAreaPanel.add(text);
		
		return textAreaPanel;
	}

	public JPanel createBoxLayoutPanel() {
		JPanel boxLayout = new JPanel();
		boxLayout.setPreferredSize(new Dimension(200, 200));
		boxLayout.setLayout(new GridLayout(MAX_BUTTONS, 1, 0, 5));
		this.addButton = new JButton("Add");
		boxLayout.add(addButton);
		this.remove = new JButton("Remove");
		boxLayout.add(remove);
		this.sortByName = new JButton("Name Sort");
		boxLayout.add(sortByName);
		this.sortByBarcode = new JButton("Barcode Sort");
		boxLayout.add(sortByBarcode);
		this.sortByDate = new JButton("Date Sort");
		boxLayout.add(sortByDate);
		this.expDate = new JButton("Check Exp Date");
		boxLayout.add(expDate);
		remove.setEnabled(false);
		eventButtons();
		
		
		
		return boxLayout;
	}
	
	
	private void addProduct() {
		new AddProductDialog(market, this);
	}
	

	public void eventButtons() {
		
		
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addProduct();
			}

		});
		
		
		remove.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent delete) {
				int row = tblProducts.getSelectedRow();
				if(row != -1){
					String barcode = (String)tblProducts.getValueAt(row, 0);
					market.removeProduct(barcode);
					tblProducts.clearSelection();
					text.setText(" ");
					tableModel.fireTableDataChanged();
				}
				remove.setEnabled(false);
			}
		});
		
		sortByName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				market.sortProductsByName();
				tableModel.fireTableDataChanged();
			}
		});
		
		sortByBarcode.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				market.sortProductsByBarcode();
				tableModel.fireTableDataChanged();
			}
		});
		
		sortByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				market.sortProductsByExpDate();
				tableModel.fireTableDataChanged();
			}
		});
		
		expDate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ShowExpDate(market);
				
			}
		});
		
	}

	public JPanel createTablePanle() {
		 JPanel pnlMain = new JPanel();
		
//		tableModel = new DefaultTableModel();
//		tblProducts = new JTable(tableModel);
//		tblProducts.setPreferredScrollableViewportSize(new Dimension(TABEL_WIDTH,TABEL_HEIGHT));
//		
//		tableModel.setColumnIdentifiers(new Object[] {"Barcode","Name","Exp Date"});
//		
//		scrollerProduct = new JScrollPane(tblProducts);
//		scrollerProduct.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		
//		for(int i = 0 ;i<market.getProdCount();i++){
//			Product p = market.getProductVector().elementAt(i);
//			tableModel.addRow(new Object[] {p.getBarcode(),p.getName(),(p.getExpDate() != null )? p.getExpDate():"None",p});
//		}
//		
//		pnlMain.add(scrollerProduct);
		 
		 	tableModel = new MyTableModel(market);
			tblProducts = new JTable(tableModel);
			tblProducts.setPreferredScrollableViewportSize(new Dimension(TABEL_WIDTH,TABEL_HEIGHT));

			scrollerProduct = new JScrollPane(tblProducts);
			scrollerProduct.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			tableModel.fireTableDataChanged();
			pnlMain.add(scrollerProduct);
		
		return pnlMain;
	}
	
	
}


