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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;


/**
 * Class SuluSearch
 * 
 * @author Team7
 */
public class SuluSearch extends Panel implements ActionListener {
	// Owned attributes
	TextField tfSearchTerm;
	TextField tfFile;
	JScrollPane scroll;
	JTextArea tfResults;
	Highlighter highlighter;
	HighlightPainter painter;
	Label lSulu;
	Label lSulu2;
	Label lFile;
	Label lSearchTerm;
	Label results;
	Label origin;
	Label trueOrigin;
	Label hits;
	Label trueHits;
	Label currPage;
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
	String error1;
	String error3;
	String noResults;
	String lLine;
	String wrongFile;
	int hitcount;
	int linecount;
	Archiv arch;
	Artikel art;
	String searchTerm;
	String unvalidDir;
	byte x, y, i;
	Matcher matcher;
	Pattern pattern;


	public SuluSearch() {
		// Layout
		this.setFont(new Font("MyFond", Font.PLAIN, 24));
		cl = new CardLayout();
		this.setLayout(cl);
		c = new GridBagConstraints();
		mainscreen = new Panel();
		gl = new GridBagLayout();
		mainscreen.setLayout(gl);
		resultscreen = new Panel();
		resultscreen.setLayout(gl);
		this.add(mainscreen, "mainscreen");
		this.add(resultscreen, "resultscreen");

		// Components
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
		tfResults = new JTextArea("", 1, 1);
		tfResults.setFont(new Font("myFont", Font.ITALIC, 20));
		scroll = new JScrollPane(tfResults);
		highlighter = tfResults.getHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
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
		error3 = "Ein Fehler ist beim Lesen folgender Datei aufgetreten: ";
		hitcount = 0;
		linecount = 0;
		lLine = "Linie: ";
		noResults = "Es wurden in der Datei keine Ergebnisse zu diesem Suchwort gefunden!";
		wrongFile = "Leider handelt es sich hierbei nicht um eine gültige Datei!";
		unvalidDir = "Ungültiges oder leeres Verzeichnis!";
		x = y = 1;
		currPage = new Label(x + "/" + y);

		// Design
		// Mainscreen
		c.gridwidth = 5;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		gl.setConstraints(lSulu, c);
		mainscreen.add(lSulu);
		c.gridx = 3;
		gl.setConstraints(english, c);
		mainscreen.add(english);
		c.gridy = GridBagConstraints.RELATIVE;
		gl.setConstraints(german, c);
		mainscreen.add(german);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		gl.setConstraints(lFile, c);
		mainscreen.add(lFile);
		c.gridy = 3;
		c.ipadx = 400;
		gl.setConstraints(tfFile, c);
		mainscreen.add(tfFile);
		c.gridy = 4;
		c.ipadx = 0;
		gl.setConstraints(lSearchTerm, c);
		mainscreen.add(lSearchTerm);
		c.gridy = 5;
		c.ipadx = 400;
		gl.setConstraints(tfSearchTerm, c);
		mainscreen.add(tfSearchTerm);
		c.gridy = 6;
		c.gridwidth = 2;
		c.ipadx = 200;
		c.insets = new Insets(10, 15, 10, 15);
		c.anchor = GridBagConstraints.LINE_START;
		gl.setConstraints(searchButton, c);
		mainscreen.add(searchButton);
		c.anchor = GridBagConstraints.LINE_END;
		gl.setConstraints(closeButton, c);
		mainscreen.add(closeButton);

		// resultscreen
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 0;
		c.insets = new Insets(0, 0, 0, 0);
		gl.setConstraints(lSulu2, c);
		resultscreen.add(lSulu2);
		c.gridy = 1;
		gl.setConstraints(results, c);
		resultscreen.add(results);
		c.gridy = 2;
		c.ipadx = 600;
		c.ipady = 350;
		gl.setConstraints(scroll, c);
		resultscreen.add(scroll);
		c.gridwidth = 2;
		c.gridy = 3;
		c.gridx = 1;
		c.ipadx = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.LINE_START;
		gl.setConstraints(origin, c);
		resultscreen.add(origin);
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_END;
		gl.setConstraints(trueOrigin, c);
		resultscreen.add(trueOrigin);
		c.gridy = 4;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		gl.setConstraints(hits, c);
		resultscreen.add(hits);
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 2;
		gl.setConstraints(trueHits, c);
		resultscreen.add(trueHits);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 5;
		c.anchor = GridBagConstraints.CENTER;
		gl.setConstraints(currPage, c);
		resultscreen.add(currPage);
		c.gridwidth = 2;
		c.gridy = 6;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		gl.setConstraints(arrow2, c);
		resultscreen.add(arrow2);
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_END;
		gl.setConstraints(arrow1, c);
		resultscreen.add(arrow1);
		c.gridy = 7;
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		gl.setConstraints(back, c);
		resultscreen.add(back);
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_END;
		gl.setConstraints(closeButton2, c);
		resultscreen.add(closeButton2);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchButton) {
			searchTerm = tfSearchTerm.getText();
			if (searchTerm.length() != 0 && tfFile.getText().length() != 0) {
				if (tfFile.getText().contains(".txt"))
					this.search(new Artikel(new File(tfFile.getText()), tfFile.getText()), new Suchwort(searchTerm));
				else if (new File(tfFile.getText()).isDirectory()) {
					arch = new Archiv(new File(tfFile.getText()), tfFile.getText());
					y = arch.getAnz();
					currPage.setText(x + "/" + y);
					if ((art = arch.getArtikel()) != null)
						this.search(art, new Suchwort(searchTerm));
					else
						myError(unvalidDir);
				} else
					myError(wrongFile);
			} else
				myError(error1);
		}

		else if (e.getSource() == closeButton || e.getSource() == closeButton2) {
			this.close();
		}

		else if (e.getSource() == back) {
			hitcount = 0;
			linecount = 0;
			cl.first(this);
		}

		else if (e.getSource() == english && ger) {
			this.changeLanguage();
		}

		else if (e.getSource() == german && !ger) {
			this.changeLanguage();
		}

		else if (e.getSource() == arrow1) {
			if ((art = arch.nextArtikel()) != null) {
				if (x < y)
					currPage.setText(++x + "/" + y);
				hitcount = 0;
				this.search(art, new Suchwort(searchTerm));
			}
		}

		else if (e.getSource() == arrow2) {
			if ((art = arch.previousArtikel()) != null) {
				if (x > 0)
					currPage.setText(--x + "/" + y);
				hitcount = 0;
				this.search(art, new Suchwort(searchTerm));
			}
		}
	}


/**
 * 
 * @param f
 * @param sw
 * @return
 */
	public int search(Artikel f, Suchwort sw) {

		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f.getPfad()));
			String line;
			String toAdd;
			Scanner sc;
			while ((line = reader.readLine()) != null) {
				linecount++;
				if (line.contains(sw.getText())) {
					toAdd = lLine + linecount + "	" + line + "\n";
					sb.append(toAdd);
					sc = new Scanner(line);
					String word;
					while (sc.hasNext()) {
						word = sc.next();
						if (word.contains(sw.getText()))
							hitcount++;
					}
					sc.close();
				}
			}
			if (hitcount > 0) {
				tfResults.setText(sb.toString());
				pattern = Pattern.compile(sw.getText());
				matcher = pattern.matcher(tfResults.getText());
				while (matcher.find()) {
					int start = matcher.start();
					int end = matcher.end();
					try {
						highlighter.addHighlight(start, end, painter);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}

			} else
				myError(noResults);

			trueHits.setText(Integer.toString(hitcount));
			trueOrigin.setText(f.getName());
			reader.close();
			cl.last(this);

		} catch (Exception e) {
			myError(error3 + f.getName());
			e.printStackTrace();
			return -1;
		}

		return hitcount;
	} // ./bible/bible_part1.txt


	public void close() {
		System.exit(0);
	}
	
	/**
	 * 
	 * @param err
	 */

	public void myError(String err) {
		tfResults.setText(err);
		cl.last(this);
	}

	public void changeLanguage() {
		if (ger) {

			lFile.setText("Please enter a path name that you want to search!");
			lSearchTerm.setText("Please enter a search-term!");
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
			error3 = "Exception occurred trying to read: ";
			lLine = "Line: ";
			noResults = "There were no words matching your searchterm!";
			wrongFile = "Unfortunately not a valid file!";
			unvalidDir = "Invalid or empty direcory!";
		} else {
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
			error3 = "Ein Fehler ist beim Lesen folgender Datei aufgetreten: ";
			lLine = "Linie: ";
			noResults = "Es wurden in der Datei keine Ergebnisse zu diesem Suchwort gefunden!";
			wrongFile = "Leider handelt es sich hierbei nicht um eine gültige Datei!";
			unvalidDir = "Ungültiges oder leeres Verzeichnis!";
		}
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = new Dimension(950, 650);
		return d;
	}

/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		SuluSearch s = new SuluSearch();
		Frame f = new Frame("SuluSearch");
		f.add(s);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);

	}

}
