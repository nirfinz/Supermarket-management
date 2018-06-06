package GUI;

import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

public class FormattedTextHelper {
	
	
	protected static JFormattedTextField createIntegerText (int min,int max,int width,int height ){
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(min);
		formatter.setMaximum(max);
		formatter.setCommitsOnValidEdit(true);

		JFormattedTextField textField =  new JFormattedTextField(formatter);
		textField.setPreferredSize(new Dimension(width,height));	

		return textField;
	}
}
