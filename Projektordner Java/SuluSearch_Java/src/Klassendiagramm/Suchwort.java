/*******************************************************************************
 * Copyright (c) 2007 TOPCASED. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Topcased contributors and others - initial API and implementation
*******************************************************************************/

/**
 * 
 */
package Klassendiagramm;

/**
 * Class Suchwort<br />
 * 
 * @author Team7
 */
public class Suchwort {
	// Owned attributes
	private String text;

	// Start of user code for extra fields
	// End of user code for extra fields
/**
 * 
 * @param content
 */
	public Suchwort(String content) {

		// Attributes TODO
		this.text = content;
		// End of user code for the default constructor
	}

	// Start of user code for parameterized constructors
	// End of user code for parameterized constructors

	// Accessors
	/**
	 * Return Text
	 * 
	 * @return String
	 */
	public String getText() {
		// Start of user code for Suchwort.getText():String
		return text;
		// End of user code
	}

	/**
	 * Set the value of Text
	 * 
	 * @param Text
	 */
	public void setText(String Text) {
		// Start of user code for Suchwort.setText(String)
		this.text = Text;
		// End of user code
	}
}
