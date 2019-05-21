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
 * 
 * @param f
 * @param s
 */
	public Artikel(File f, String s) {
		;
		this.name = s;
		this.pfad = f;
	}

/**
 * this returns the Pfad
 * @return Pfad 
 */
	public File getPfad() {
		return pfad;
	}

	/**
	 * Set the value of Pfad
	 * 
	 * @param Pfad
	 */
	public void setPfad(File Pfad) {
		this.pfad = Pfad;
	}

/**
 * 
 * @return the name of the pfad
 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of Text
	 * 
	 * @param Text
	 */
	public void setName(String Text) {
		this.name = Text;
	}
}
