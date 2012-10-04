package project.modules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import common.interfaces.IPageModule;

import data.bundle.TestPropertyBundle;

public class PageHeaderModule implements IPageModule{
	
	@Inject
	TestPropertyBundle properties;

	@Inject
	WebDriver driver;

	public PageHeaderModule(WebDriver driver, TestPropertyBundle properties) {
		this.driver = driver;
		this.properties = properties;
	}
	
	
	public PageHeaderModule goToPage(String url){
		System.out.println("Header Module goToPage(), url is" + url);

		
		assertEquals(url, url);
		driver.get(url);
		return this;
	}
	
	
	public PageHeaderModule testHeaderText(){
		System.out.println("Header Module testFooterText()");
		fail("this test needs to be written");
		return this;
	}
	
}
