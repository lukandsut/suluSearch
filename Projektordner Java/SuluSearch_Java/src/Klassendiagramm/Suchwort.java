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
 * Class Suchwort
 * 
 * @author Team7
 */
public class Suchwort {
	private String text;
/**
 * Suchwort
 * @param content Inhalt des Suchwortes
 */
	public Suchwort(String content) {
		this.text = content;
	}

	/**
	 * This Returns the Text
	 * 
	 * @return the Text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the value of Text
	 * 
	 * @param Text the Text
	 */
	public void setText(String Text) {
		this.text = Text;
	}
}
