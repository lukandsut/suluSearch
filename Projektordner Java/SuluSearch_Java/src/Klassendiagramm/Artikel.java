/*******************************************************************************
 * Copyright (c) 2007 TOPCASED. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Topcased contributors and others - initial API and implementation
*******************************************************************************/

package Klassendiagramm;

import java.io.*;
/**
 * Class Artikel
 * 
 * @author Team7
 */
public class Artikel {
	public File pfad;
	public String name;
/**
 * Artikeleigenschaften
 * @param f ist ein Dateipfad des Artikels
 * @param s ist der Name der Datei
 */
	public Artikel(File f, String s) {
		;
		this.name = s;
		this.pfad = f;
	}

/**
 * returns the value of the path
 * @return Pfad 
 */
	public File getPfad() {
		return pfad;
	}

	/**
	 * Set the value of the path
	 * 
	 * @param Pfad
	 */
	public void setPfad(File Pfad) {
		this.pfad = Pfad;
	}

/**
 * returns the name of the path
 * @return name
 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of Text
	 * 
	 * @param Text
	 */
	public void setName(String Text) {
		this.name = Text;
	}
}
