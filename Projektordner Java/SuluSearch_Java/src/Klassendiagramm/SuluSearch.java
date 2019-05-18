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
import java.io.File;
//import java.io.FileInputStream;
import java.nio.file.Path;
import java.awt.*;
import java.awt.event.*;
//End of user code for imports

/**
 * Class SuluSearch<br />
 * 
 * @author Team7
 */
public class SuluSearch extends Panel
{
    // Owned attributes
	TextField tfSearchTerm;
	TextField tfFile;
	Label lSulu;
	Label lFile;
	Label lSearchTerm;
	Button searchButton;
	Button closeButton;
	Button german;
	Button english;
	Panel mainscreen;
	Panel resultscreen;
	GridBagConstraints c;
	GridBagLayout gl;
	
 
    public SuluSearch ()
    {
    	//Layout
		this.setFont(new Font("MyFond", Font.PLAIN, 24));
		this.setLayout(new CardLayout());
		GridBagConstraints c = new GridBagConstraints();
		mainscreen = new Panel();
		gl =  new GridBagLayout();
		mainscreen.setLayout(gl);
		//resultscreen = new Panel();
		//resultscreen.setLayout(gl);
		c = new GridBagConstraints();
		this.add(mainscreen);		
		
		//Components
		lSulu = new Label("SuluSearch");
		lFile = new Label("Bitte einen Datei- oder Verzeichnisnamen eingeben!");
		lSearchTerm = new Label("Bitte einen Suchbegriff eingeben");
		tfSearchTerm = new TextField();
		tfFile = new TextField();
		searchButton = new Button("Suchen");
		closeButton = new Button("Schlieﬂen");
		german = new Button("Deu");
		english = new Button("Eng");		
		
		//Design
		c.gridwidth = 5;
		c.gridx = 1;
		c.gridy = 0;
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
    }

    // Methods 

    /**
     */
    public int search(File f, String searchTerm)
    {
    	int hits = 0;
    	//get results
    	//open responsescreen and fill
    	return hits;
    }
    
    public int search(Path p, String searchTerm)
    {
    	int hits = 0;
        //get results
    	//open responsescreen and fill
    	return hits;
    }

    /**
     */
    public void close()
    {
        // Start of user code for SuluSearch.close()
        // TODO
        // End of user code
    }

    /**
     */
    public void actionlistener1()
    {
        // Start of user code for SuluSearch.actionlistener1()
        // TODO
        // End of user code
    }
    
    public void changeLanguage()
    {
        // Start of user code for SuluSearch.actionlistener1()
        // TODO
        // End of user code
    }
    
   // @Override
    /*public Dimension getPreferredSize() {
    	Dimension d  = new Dimension(1250,750);
    	return d;
    }*/

    // Start of user code for extra methods
    // End of user code for extra methods

    // Start of user code for SuluSearch.main	
    public static void main (String[] args) {	
    	SuluSearch s = new SuluSearch();
		Frame f = new Frame("SuluFrame");		
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
