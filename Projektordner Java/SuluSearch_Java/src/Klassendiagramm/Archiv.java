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
import java.util.*;
//End of user code for imports

/**
 * Class Archiv<br />
 * 
 * @author Team7
 */
public class Archiv extends Artikel
{
    // Owned attributes
  
    public Artikel artikel[];


    // Start of user code for extra fields
    private int i;
    private int j;
    // End of user code for extra fields

    /**
     * Default constructor
     */
    public Archiv (File f, String s)
    {
        // Start of user code for the default constructor
        super(f,s);
        i = 0;
        j = 0;
        artikel = new Artikel [30];
        this.fillArray(f);
        // Attributes TODO
    
        	
        // End of user code for the default constructor
    }

    // Start of user code for parameterized constructors
    // End of user code for parameterized constructors

    // Accessors
   public void fillArray(File f) {
	   File list[] = f.listFiles();
       if(list!=null) {
	        for (File fil : list)
	        {       
	        	if (i < 30) {
		             if (fil.getName().contains(".txt"))
		            {
		                artikel[i] = new Artikel(fil, fil.getName());
		                i++;
		            }
		             if (fil.isDirectory())
		            {
		                fillArray(fil);
		            }
	        	}
	        }	        
       }
       /*else 
       		s.myError();
		*/	   
   }
   
   public Artikel getArtikel() {
	   if (artikel[j] != null)
		   return artikel[j];
	   else 
		   return null;
   }
   
   public Artikel nextArtikel() {
	   if (j < i - 1) {
	   j++;
	   return artikel[j];
	   }
	   else
		   return null;
   }
   
   public Artikel previousArtikel() {
	   if(j>0) {
	   j--;
	   return artikel[j];
	   }
	   else
		   return null;
   }
   
   public Byte getAnz() {
	   return (byte) i;
   }
    // Start of user code for extra methods
    // End of user code for extra methods

    // Start of user code for Archiv.main	
    /*public static void main (String[] args) {	
    }
    */
    // End of user code
	
}
