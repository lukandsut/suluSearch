/**
 * 
 */
package Klassendiagramm;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.*;
import org.junit.Test;

/**
 * @author mariu
 *
 */
public class suluTests {
	File text1;
	File text2;
	Path dir;
	SuluSearch s;
	@Test
	public void verifyLanguageTest() {		
		s = new SuluSearch();
		s.changeLanguage();
		//assertTrue(Closebutton.getLabel() == "close" && SearchButton.getLabel() == "search");
	}
	
	@Test
	public void searchFileTest() {		
		s = new SuluSearch();
		int hits = s.search(text1, "cinnamon");
		//assertTrue(hits == 2);
	}
	
	@Test
	public void searchArchiveTest() {		
		s = new SuluSearch();
		dir = Paths.get("./Bible");
		int hits = s.search(dir, "cinnamon");
		//assertTrue(hits == 4);
	}
	
}
