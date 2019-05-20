/*******************************************************************************
 * Copyright (c) 2007 TOPCASED. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Topcased contributors and others - initial API and implementation
*******************************************************************************/

package Klassendiagramm;


//Start of user code for imports

import java.io.*;

import javax.swing.JOptionPane;
//import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;

//End of user code for imports

/**
 * Class SuluSearch<br />
 * 
 * @author Team7
 */
public class SuluSearch extends Panel implements ActionListener
{
    // Owned attributes
	TextField tfSearchTerm;
	TextField tfFile;
	TextArea tfResults;
	Label lSulu;
	Label lSulu2;
	Label lFile;
	Label lSearchTerm;
	Label results;
	Label origin;
	Label trueOrigin;
	Label hits;
	Label trueHits;
	Button searchButton;
	Button closeButton;
	Button closeButton2;
	Button german;
	Button english;
	Button back;
	Button arrow1;
	Button arrow2;
	Panel mainscreen;
	Panel resultscreen;
	GridBagConstraints c;
	GridBagLayout gl;
	CardLayout cl;
	boolean ger = true;
	boolean furtherData = false;
	boolean previousData = false;
	String error1;
	String error2;
	String error3;
	int hitcount;
 
    public SuluSearch ()
    {
    	//Layout
		this.setFont(new Font("MyFond", Font.PLAIN, 24));
		cl = new CardLayout();
		this.setLayout(cl);
		c = new GridBagConstraints();
		mainscreen = new Panel();
		gl =  new GridBagLayout();
		mainscreen.setLayout(gl);
		resultscreen = new Panel();
		resultscreen.setLayout(gl);
		this.add(mainscreen, "mainscreen");
		this.add(resultscreen, "resultscreen");
		
		
		
		//Components
		lSulu = new Label("SuluSearch");
		lSulu2 = new Label(lSulu.getText());
		lFile = new Label("Bitte einen Datei- oder Verzeichnisnamen eingeben!");
		lSearchTerm = new Label("Bitte einen Suchbegriff eingeben");
		results = new Label("Suchergebnisse: ");
		origin = new Label("Gefunden in der Datei: ");
		trueOrigin = new Label("");
		hits = new Label("Häufigkeit: ");
		trueHits = new Label("");
		tfSearchTerm = new TextField();
		tfFile = new TextField();
		tfResults = new TextArea("", 1,1,TextArea.SCROLLBARS_BOTH);
		searchButton = new Button("Suchen");
		searchButton.addActionListener(this);
		closeButton = new Button("Schließen");
		closeButton.addActionListener(this);
		closeButton2 = new Button("Schließen");
		closeButton2.addActionListener(this);
		german = new Button("Deu");
		german.addActionListener(this);
		english = new Button("Eng");
		english.addActionListener(this);
		back = new Button("Zurück");
		back.addActionListener(this);
		arrow1 = new Button("-->");
		arrow1.addActionListener(this);
		arrow2 = new Button("<--");
		arrow2.addActionListener(this);
		error1 = "Sie müssen einen Wert für Suchwort und Datei festlegen!";
		error1 = "Feher!";
		error3 = "Ein Fehler ist beim Lesen folgender Datei aufgetreten: ";
		hitcount = 0;
		
		
		//Design
		//Mainscreen
		c.gridwidth = 5;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		gl.setConstraints(lSulu,c);
        mainscreen.add(lSulu);
        c.gridx = 3;
        gl.setConstraints(english,c);
        mainscreen.add(english);
        c.gridy = GridBagConstraints.RELATIVE;
        gl.setConstraints(german,c);
        mainscreen.add(german);
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        gl.setConstraints(lFile,c);
        mainscreen.add(lFile);
        c.gridy = 3;
        c.ipadx = 400;
        gl.setConstraints(tfFile,c);
        mainscreen.add(tfFile);
        c.gridy = 4;
        c.ipadx = 0;
        gl.setConstraints(lSearchTerm,c);
        mainscreen.add(lSearchTerm);
        c.gridy = 5;
        c.ipadx = 400;
        gl.setConstraints(tfSearchTerm,c);
        mainscreen.add(tfSearchTerm);
        c.gridy = 6;
        c.gridwidth = 2;
        c.ipadx = 200;
        c.insets = new Insets(10,15,10,15);
        c.anchor = GridBagConstraints.LINE_START;
        gl.setConstraints(searchButton,c);
        mainscreen.add(searchButton);
        c.anchor = GridBagConstraints.LINE_END;
        gl.setConstraints(closeButton,c);
        mainscreen.add(closeButton);
        
        
        //resultscreen
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 0;
		c.insets = new Insets(0,0,0,0);
        gl.setConstraints(lSulu2,c);
        resultscreen.add(lSulu2);
        c.gridy = 1;
        gl.setConstraints(results,c);
        resultscreen.add(results);
        c.gridy = 2;
        c.ipadx = 650;
        c.ipady = 250;
        gl.setConstraints(tfResults,c);
        resultscreen.add(tfResults);
        c.gridwidth = 2;
        c.gridy = 3;
        c.gridx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.anchor = GridBagConstraints.LINE_START;
        gl.setConstraints(origin,c);
        resultscreen.add(origin);
        c.gridx = 2;
        c.anchor = GridBagConstraints.LINE_END;
        gl.setConstraints(trueOrigin,c);
        resultscreen.add(trueOrigin);
        c.gridy = 4;
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        gl.setConstraints(hits,c);
        resultscreen.add(hits);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 2;
        gl.setConstraints(trueHits,c);
        resultscreen.add(trueHits);
        c.gridy = 5;
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        gl.setConstraints(arrow2,c);
        resultscreen.add(arrow2);
        c.gridx = 2;
        c.anchor = GridBagConstraints.LINE_END;
        gl.setConstraints(arrow1,c);
        resultscreen.add(arrow1);
        c.gridy = 6;
        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        gl.setConstraints(back,c);
        resultscreen.add(back);
        c.gridx = 2;
        c.anchor = GridBagConstraints.LINE_END;
        gl.setConstraints(closeButton2,c);
        resultscreen.add(closeButton2);
    }
    
    
    //Actionlisteners
    
    @Override
    public void actionPerformed(ActionEvent e)
    {    
        if (e.getSource() == searchButton){    
        	if (tfSearchTerm.getText() != "" && tfFile.getText()!= "") {
        		if (tfFile.getText().contains(".txt")) 
        			this.search(new File(tfFile.getText()),new Suchwort(tfSearchTerm.getText()));
        		//couldnt find file
        		//else
        			//this.search(new Path(tfFile.getText()),tfSearchTerm.getText());
        		//couldnt find directory
        	}
        	else
        		JOptionPane.showMessageDialog(null, 
                        error1, 
                        error2, 
                        JOptionPane.WARNING_MESSAGE);
        	
        }
        	
        else if (e.getSource() == closeButton || e.getSource() == closeButton2){  
        	this.close(); 
        }
        
        else if (e.getSource() == back ){  
        	hitcount = 0;
        	cl.first(this);
        }
        
        else if (e.getSource() == english &&  ger){  
        	this.changeLanguage();
        }
        
        else if (e.getSource() == german &&  !ger){  
        	this.changeLanguage();
        }
        
        else if (e.getSource() == arrow1 &&  furtherData){  
        	//Daten umschreiben
        }
        
        else if (e.getSource() == arrow2 &&  previousData){  
        	//Daten umschreiben
        }
        
    }
   

    
    

    // Methods 

    /**
     */
    public int search(File f, Suchwort sw)
    {
    	int hits = 0;
    	Vector<String> findings = new Vector<String>();
    	  try
    	  {
    	    BufferedReader reader = new BufferedReader(new FileReader(f));
    	    String line;
    	    Scanner sc;
    	    while ((line = reader.readLine()) != null)
    	    {
    	    if (line.contains(sw.getText()))
    	    	findings.add(line);
    	    	sc = new Scanner(line);
    	    	while(sc.hasNext()) {
    	    		if(sc.next() == sw.getText())
    	    			hitcount ++;
    	    	}
    	    	
    	    }
    	    tfResults.setText(findings.toString());
    	    reader.close();
    	    cl.last(this);
    	    
    	  }
    	  catch (Exception e)
    	  {
    		JOptionPane.showMessageDialog(null, 
                      error3 + f.getName(), 
                      error2, 
                      JOptionPane.WARNING_MESSAGE);
    	    e.printStackTrace();
    	    return -1;
    	  }
        
    	
    	return hits;
    }
    
    public int search(Path p, Suchwort searchTerm)
    {
    	int hits = 0;
        
    	cl.last(this);
    	return hits;
    }

    /**
     */
    public void close()
    {
        System.exit(0);
    }
    
    public void changeLanguage()
    {
        if (ger) {
        	
        	
        	lFile.setText("Please enter the the path of the directory or file that you want to search!");
        	lSearchTerm.setText("Please enter the word that you want to search for!");
        	results.setText("Results: ");
        	origin.setText("Origin: ");
        	hits.setText("Number of hits: ");        	
        	searchButton.setLabel("Search");
        	closeButton.setLabel("Close");
        	closeButton2.setLabel("Close");
        	german.setLabel("Ger");
        	back.setLabel("Back");
        	ger = false;
        	error1 = "You need to fill in values for searchword and path!";
        	error1 = "Error!";
        	error3 = "Exception occurred trying to read: ";
        }
        else {
        	lFile.setText("Bitte einen Datei- oder Verzeichnisnamen eingeben!");
        	lSearchTerm.setText("Bitte einen Suchbegriff eingeben");
        	results.setText("Suchergebnisse: ");
        	origin.setText("Gefunden in der Datei: ");
        	hits.setText("Häufigkeit: ");        	
        	searchButton.setLabel("Suchen");
        	closeButton.setLabel("Schleißen");
        	closeButton2.setLabel("Schleißen");
        	german.setLabel("Deu");
        	back.setLabel("Zurück");
        	ger = true;
        	error1 = "Sie müssen einen Wert für Suchwort und Datei festlegen!";
        	error1 = "Fehler!";
        	error3 = "Ein Fehler ist beim Lesen folgender Datei aufgetreten: ";
        }
    }
    
    
    @Override
    public Dimension getPreferredSize() {
    	Dimension d  = new Dimension(950,650);
    	return d;
    }

    // Start of user code for extra methods
    // End of user code for extra methods

    // Start of user code for SuluSearch.main	
    public static void main (String[] args) {	
    	SuluSearch s = new SuluSearch();
		Frame f = new Frame("SuluSearch");		
		f.add(s);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
		
    }
    
    // End of user code
	
}
