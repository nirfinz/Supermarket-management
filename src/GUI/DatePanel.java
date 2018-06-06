package GUI;


import java.awt.Dimension;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import AllClasses.Date;

@SuppressWarnings("serial")
public class DatePanel extends JPanel {
	
	public static final int MAX_DAY = 31;
	public static final int MAX_MONTH = 12;
	public static final int MAX_YEAR = 22;
	public static final int MIN_DAY = 1;
	public static final int MIN_MONTH = 1;
	public static final int MIN_YEAR = 15;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 20;
	
	private JFormattedTextField day;
	private JFormattedTextField month;
	private JFormattedTextField year;

	private JLabel labelDay;
	private JLabel labelMonth;
	private JLabel labelYear;
	
	
	public DatePanel (String name){
		JLabel titleLable = new JLabel(name);
		titleLable.setPreferredSize(new Dimension(60, 20));
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		day = FormattedTextHelper.createIntegerText(MIN_DAY,MAX_DAY,WIDTH,HEIGHT);
		labelDay = new JLabel("Day:");
		
		month = FormattedTextHelper.createIntegerText(MIN_MONTH, MAX_MONTH, WIDTH, HEIGHT);
		labelMonth = new JLabel("Month:");
		
		year = FormattedTextHelper.createIntegerText(MIN_YEAR, MAX_YEAR, WIDTH, HEIGHT);
		labelYear = new JLabel("Year 15-22:");
		
		
		
		add(titleLable);
		add(labelDay);
		add(day);
		add(labelMonth);
		add(month);
		add(labelYear);
		add(year);
		
		layout.putConstraint(SpringLayout.WEST, titleLable, 0,SpringLayout.WEST,this );
		layout.putConstraint(SpringLayout.WEST, labelDay, 7,SpringLayout.EAST,titleLable );
		layout.putConstraint(SpringLayout.WEST, day, 5,SpringLayout.EAST,labelDay );
		layout.putConstraint(SpringLayout.WEST, labelMonth, 5,SpringLayout.EAST,day );
		layout.putConstraint(SpringLayout.WEST, month, 5,SpringLayout.EAST,labelMonth );
		layout.putConstraint(SpringLayout.WEST, labelYear, 5,SpringLayout.EAST,month );
		layout.putConstraint(SpringLayout.WEST, year, 5,SpringLayout.EAST,labelYear );
		
		setPreferredSize(new Dimension(AddProductPanel.PANEL_WIDTH-15, 25));
	}
	
	protected void setEnable(boolean e) {
		day.setEnabled(e);
		month.setEnabled(e);
		year.setEnabled(e);
	}

	protected void setEdit(boolean e) {
		day.setEditable(e);
		month.setEditable(e);
		year.setEditable(e);
	}

	protected Date getDate() throws Exception{
		int newDay = Integer.parseInt(day.getText());
		int newMonth = Integer.parseInt(month.getText());
		int newYear = Integer.parseInt(year.getText());
		return new Date(newDay,newMonth,newYear);
	}
	
	protected void clean() {
		if(day!= null)
			day.setText(null);
		if(month!= null)
			month.setText(null);
		if(year!= null)
			year.setText(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
