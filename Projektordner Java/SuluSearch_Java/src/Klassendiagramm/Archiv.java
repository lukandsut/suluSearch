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
import java.util.*;

/**
 * Class Archiv
 * 
 * @author Team7
 */
public class Archiv extends Artikel {

	public Artikel artikel[];

	private int i;
	private int j;
	/**
	 * 
	 * @param f
	 * @param s
	 */
	public Archiv(File f, String s) {
		super(f, s);
		i = 0;
		j = 0;
		artikel = new Artikel[30];
		this.fillArray(f);
}
/**
 * 
 * @param f
 */
	public void fillArray(File f) {
		File list[] = f.listFiles();
		if (list != null) {
			for (File fil : list) {
				if (i < 30) {
					if (fil.getName().contains(".txt")) {
						artikel[i] = new Artikel(fil, fil.getName());
						i++;
					}
					if (fil.isDirectory()) {
						fillArray(fil);
					}
				}
			}
		}
		/*
		 * else s.myError();
		 */
	}

	/**
	 * 
	 * @return
	 */
	public Artikel getArtikel() {
		if (artikel[j] != null)
			return artikel[j];
		else
			return null;
	}

	/**
	 * 
	 * @return
	 */
	public Artikel nextArtikel() {
		if (j < i - 1) {
			j++;
			return artikel[j];
		} else
			return null;
	}
/**
 * 
 * @return
 */
	public Artikel previousArtikel() {
		if (j > 0) {
			j--;
			return artikel[j];
		} else
			return null;
	}
/**
 * 
 * @return
 */
	public Byte getAnz() {
		return (byte) i;
	}
}
