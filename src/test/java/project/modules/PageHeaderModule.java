package project.modules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

import data.bundle.TestPropertyBundle;

public class PageHeaderModule {
	
	@Inject
	TestPropertyBundle properties;

	@Inject
	WebDriver driver;

	public PageHeaderModule(WebDriver driver, TestPropertyBundle properties) {
		this.driver = driver;
		this.properties = properties;
	}
	
	
	public PageHeaderModule goToPage(String url){
		System.out.println("Footer Module goToPageMethod(), url is" + url);

		
		assertEquals(url, url);
		driver.get(url);
		return this;
	}
	
	
	public PageHeaderModule testFooterText(){
		System.out.println("Footer Module testFooterText()");
		fail("this test needs to be written");
		return this;
	}
	
}
