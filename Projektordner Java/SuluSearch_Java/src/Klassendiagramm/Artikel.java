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

//End of user code for imports

/**
 * Class Artikel<br />
 * 
 * @author Team7
 */
public class Artikel 
{
    // Owned attributes
    public String Pfad;
    public String Text;


    // Start of user code for extra fields
    // End of user code for extra fields

    /**
     * Default constructor
     */
    public Artikel ()
    {
        // Start of user code for the default constructor
        super();
        // Attributes TODO
        ;
        this.Text = null;
        // End of user code for the default constructor
    }

    // Start of user code for parameterized constructors
    // End of user code for parameterized constructors

    // Accessors
    /**
     * Return Pfad
     * @return String
     */
    public String getPfad()
    {
        // Start of user code for Artikel.getPfad():String
        return Pfad;
        // End of user code
    }

    /**
     * Set the value of Pfad
     * @param Pfad
     */
    public void setPfad(String Pfad)
    {
        // Start of user code for Artikel.setPfad(String)
        this.Pfad = Pfad;
        // End of user code
    }

    /**
     * Return Text
     * @return String
     */
    public String getText()
    {
        // Start of user code for Artikel.getText():String
        return Text;
        // End of user code
    }

    /**
     * Set the value of Text
     * @param Text
     */
    public void setText(String Text)
    {
        // Start of user code for Artikel.setText(String)
        this.Text = Text;
        // End of user code
    }


    

    // Start of user code for extra methods
    // End of user code for extra methods

    // Start of user code for Artikel.main	
    /*public static void main (String[] args) {	
    }
    */
    // End of user code
	
}
