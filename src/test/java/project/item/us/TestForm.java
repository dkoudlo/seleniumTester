package project.item.us;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import project.modules.FormFooterModule;
import project.modules.FormHeaderModule;

import com.google.inject.Inject;

import common.GenericSeleniumTest;
import data.bundle.TestPropertyBundle;

public class TestForm extends GenericSeleniumTest{

	private TestPropertyBundle properties;

	@Inject
	WebDriver driver;
	
	@Inject
	FormFooterModule footer;
	
	@Inject
	FormHeaderModule header;
	
//	@Inject
//	protected void init(TestPropertyBundle propertiesIn) {
//		this.properties = propertiesIn;
//	}
	
	@Test
	public void testFooter() 
	{
		
		driver.get("http://www.wtfjs.com");
		assertEquals( driver.getTitle() ,  driver.getTitle());
		
		footer.goToPage("http://www.google.com")
			.testFooterText();
	}
	
	
	@Test
	public void testHeader() 
	{
		header.goToPage("http://www.yahoo.com")
			.testHeaderText();
		
	}
}
