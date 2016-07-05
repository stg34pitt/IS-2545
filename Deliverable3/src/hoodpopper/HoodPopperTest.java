package hoodpopper;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import org.junit.Test;

public class HoodPopperTest {

	static WebDriver driver = new HtmlUnitDriver();
		
		// Start at the home page for HoodPopper for each test
		@Before
		public void setUp() throws Exception {
			driver.get("http://lit-bayou-7912.herokuapp.com");
		}
		
		
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
