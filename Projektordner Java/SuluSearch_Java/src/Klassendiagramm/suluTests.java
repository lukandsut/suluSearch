/**

 * 
 */
package Klassendiagramm;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.*;
import org.junit.Test;

/**
 * @author mariu
 *
 */
public class suluTests {
	Artikel art1 = new Artikel(new File("./bible/bible_part1.txt"),"./bible/bible_part1.txt");
	Archiv arch1 = new Archiv(new File("./bible"),"./bible");
	Suchwort sw = new Suchwort("cinnamon");
	SuluSearch s;
	int hits = 0;
	
	@Test
	public void verifyLanguageTest() {		
		s = new SuluSearch();
		s.changeLanguage();
		assertTrue(s.closeButton.getLabel().equals("close") && s.searchButton.getLabel().equals("Search"));
	}
	
	/*@Test
	public void searchFileTest() {		
		s = new SuluSearch();
		int hits = s.search(text1, sw);
		assertTrue(hits == 2);
	}*/
	
	/*@Test
	public void searchArchiveTest() {		
		s = new SuluSearch();
		dir = Paths.get("./Bible");
		int hits = s.search(dir, sw);
		//assertTrue(hits == 4);
	}*/
	
}
