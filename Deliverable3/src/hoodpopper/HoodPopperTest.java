package hoodpopper;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HoodPopperTest {

	static WebDriver driver = new HtmlUnitDriver();
		
		// Start at the home page for HoodPopper for each test
		@Before
		public void setUp() throws Exception {
			driver.get("http://lit-bayou-7912.herokuapp.com");
		}
		
	
		// Given that I am on the main page
		// When I view the title
		// Then I see that it contains the word "Hoodpopper"
		@Test
		public void testShowsCorrectTitle() {
			
			// Simply check that the title contains the word "Hoodpopper"
			
			String title = driver.getTitle();
			assertTrue(title.contains("Hoodpopper"));
		}
		
		// Given that I have typed some Ruby code with whitespace
		// When I click on the Tokenize button
		// Then I see the code ":on_sp" in the output
		@Test
		public void testTokenizeWhitespace() {
			
			driver.findElement(By.id("code_code")).sendKeys("a = 5\nb = 6\nc = a + (b * 4)");;
			
			WebElement submitButton = driver.findElement(By.name("commit"));
			submitButton.click();
			
			try {
				WebElement e = driver.findElement(By.tagName("code"));
				String elementText = e.getText();
				assertTrue(elementText.contains(":on_sp"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
		
		// Given that I have typed some Ruby code with a variable named variable1
		// When I click on the Tokenize button
		// Then I see the identifier "variable1" in the output
		@Test
		public void testTokenizeVariable() {
					
			driver.findElement(By.id("code_code")).sendKeys("variable1 = 5\nb = 6\nc = a + (b * 4)");;
					
			WebElement submitButton = driver.findElement(By.name("commit"));
			submitButton.click();
					
			try {
				WebElement e = driver.findElement(By.tagName("code"));
				String elementText = e.getText();
				assertTrue(elementText.contains("variable1"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
		
		// Given that I have typed some Ruby code with puts in it
		// When I click on the Tokenize button
		// Then I see the code ":on_ident" in the output
		@Test
		public void testTokenizePuts() {
							
			String a = "the_best_cat = \"Noogie Cat\" \nputs \"The best cat is: \" + the_best_cat";
			driver.findElement(By.id("code_code")).sendKeys(a);;
							
			WebElement submitButton = driver.findElement(By.name("commit"));
			submitButton.click();
							
			try {
				WebElement e = driver.findElement(By.tagName("code"));
				String elementText = e.getText();
				assertTrue(elementText.contains(":on_ident"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
		
		// Given that I have typed some Ruby code with multiplication in it
		// When I click on the Tokenize button
		// Then I see ":on_op" in the output
		@Test
		public void testTokenizeOperation() {
							
			driver.findElement(By.id("code_code")).sendKeys("variable1 = 5\nb = 6\nc = a + (b * 4)");;
									
			WebElement submitButton = driver.findElement(By.name("commit"));
			submitButton.click();
									
			try {
				WebElement e = driver.findElement(By.tagName("code"));
				String elementText = e.getText();
				assertTrue(elementText.contains(":on_op"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
	
		// Given that I have typed some Ruby code with puts in it
		// When I click on the Parse button
		// Then I see "@ident" in the output
		@Test
		public void testParsePuts() {
									
			String a = "the_best_cat = \"Noogie Cat\" \nputs \"The best cat is: \" + the_best_cat";
			driver.findElement(By.id("code_code")).sendKeys(a);;
									
			WebElement submitButton = driver.findElement(By.xpath("(//input[@name='commit'])[2]"));
			submitButton.click();
									
			try {
				WebElement e = driver.findElement(By.tagName("code"));
				String elementText = e.getText();
				assertTrue(elementText.contains("@ident"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
		
		// Given that I have typed some Ruby code with whitespace in it
		// When I click on the Parse button
		// Then I see should not see the ":on_sp" identifier
		@Test
		public void testParseNoWhitespace() {
										
			driver.findElement(By.id("code_code")).sendKeys("variable1 = 5\nb = 6\nc = a + (b * 4)");;
											
			WebElement submitButton = driver.findElement(By.xpath("(//input[@name='commit'])[2]"));
			submitButton.click();
											
			try {
				WebElement e = driver.findElement(By.tagName("code"));
				String elementText = e.getText();
				assertFalse(elementText.contains(":on_sp"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
		
}
