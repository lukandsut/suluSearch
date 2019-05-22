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
	 * Archiv erbt von Artikel
	 * @param f ist der Pfad
	 * @param s ist der Name
	 */
	public Archiv(File f, String s) {
		super(f, s);
		i = 0;
		j = 0;
		artikel = new Artikel[30];
		this.fillArray(f);
}
/**
 * schreibt alle Dateipfade, die auf ".txt" enden, aus einem Verzeichnis in eine Liste
 * @param f ist der Name
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
	 * returnt einen Artikel aus der Liste
	 * @return artikel[j]
	 */
	public Artikel getArtikel() {
		if (artikel[j] != null)
			return artikel[j];
		else
			return null;
	}

	/**
	 * returnt den nächsten Artikel aus der Liste (Button next/nächster)
	 * @return artikel[j]
	 */
	public Artikel nextArtikel() {
		if (j < i - 1) {
			j++;
			return artikel[j];
		} else
			return null;
	}
/**
 * returnt den vorherigen Artikel aus der Liste (Button back/zurück)
 * @return artikel[j]
 */
	public Artikel previousArtikel() {
		if (j > 0) {
			j--;
			return artikel[j];
		} else
			return null;
	}
/**
 * Länge des Artikels in byte
 * @return i
 */
	public Byte getAnz() {
		return (byte) i;
	}
}
