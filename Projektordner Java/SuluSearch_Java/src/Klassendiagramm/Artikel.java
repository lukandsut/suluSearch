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
//End of user code for imports

/**
 * Class Artikel<br />
 * 
 * @author Team7
 */
public class Artikel {
	// Owned attributes
	public File pfad;
	public String name;

	// Start of user code for extra fields
	// End of user code for extra fields

	/**
	 * Default constructor
	 */
	public Artikel(File f, String s) {
		// Start of user code for the default constructor

		// Attributes TODO
		;
		this.name = s;
		this.pfad = f;
		// End of user code for the default constructor
	}

	// Start of user code for parameterized constructors
	// End of user code for parameterized constructors

	// Accessors
	/**
	 * Return Pfad
	 * 
	 * @return String
	 */
	public File getPfad() {
		// Start of user code for Artikel.getPfad():String
		return pfad;
		// End of user code
	}

	/**
	 * Set the value of Pfad
	 * 
	 * @param Pfad
	 */
	public void setPfad(File Pfad) {
		// Start of user code for Artikel.setPfad(String)
		this.pfad = Pfad;
		// End of user code
	}

	/**
	 * Return Text
	 * 
	 * @return String
	 */
	public String getName() {
		// Start of user code for Artikel.getText():String
		return name;
		// End of user code
	}

	/**
	 * Set the value of Text
	 * 
	 * @param Text
	 */
	public void setName(String Text) {
		// Start of user code for Artikel.setText(String)
		this.name = Text;
		// End of user code
	}

	// Start of user code for extra methods
	// End of user code for extra methods

	// Start of user code for Artikel.main
	/*
	 * public static void main (String[] args) { }
	 */
	// End of user code

}
