package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

import AllClasses.*;

@SuppressWarnings("serial")
public class ShowExpDatePanel extends JPanel {
	public static final int DELAY = 2000;
	private Vector<Product> prodVec;
	private Timer theTimer;
	private int productIndex;
	private Product theProd;
	
	
	public ShowExpDatePanel (SuperMarket market){
		this.prodVec = market.getProductVector();
		this.productIndex = 0;
		setPreferredSize(new Dimension(800, 300));
		theTimer = new Timer(DELAY, new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
					getProduct(productIndex);
					productIndex++;
					repaint();
					if(productIndex == prodVec.size()){
						theTimer.stop();
						productIndex = -1;
						theProd = null;
						repaint();
					}
			}
		});
		theTimer.start();
	}
	
	
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 20));
		if(theProd != null){
			g.drawString(theProd.checkExpDate(), getWidth()/2 -150, getHeight()/2);
		}else if(productIndex == -1){
			g.drawString("All Products were checked", getWidth()/2 -100, getHeight()/2);
		}else{
			g.drawString("No Product yet", getWidth()/2 -100, getHeight()/2);
		}
	}




	private void getProduct(int productIndex) {
		this.theProd = prodVec.get(productIndex);
		
	}
}
