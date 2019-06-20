package Klassendiagramm;

import java.awt.*; 
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.JFrame;



public class ImgPanel extends Panel {

	 private Image Img;
	    
	    ImgPanel() {
	    	JFrame F = new JFrame("myFrame");
			Toolkit tk = F.getToolkit();  
	    	this.Img = tk.getImage("./pictures/About.png"); 
	    	              
	        MediaTracker M=new MediaTracker(this);
	        M.addImage(this.Img,1);
	        try {
	            M.waitForID(1);
	        }
	        catch (Exception e){
	        	e.printStackTrace();
	        }	
	        F.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        F.add(this);	        
	                F.pack();
	                F.setVisible(true);
	             
	              
	    }	    
	 

	public void paint(Graphics g) {
		g.drawImage(Img, 0, 0, this);
	}

	public Dimension getPreferredSize() {
		return new Dimension(Img.getWidth(this), Img.getHeight(this));
	}

}
