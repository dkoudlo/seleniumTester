package project.modules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import common.interfaces.IPageModule;

import data.bundle.TestPropertyBundle;

public class PageContentModule implements IPageModule{
	@Inject
	TestPropertyBundle properties;

	@Inject
	WebDriver driver;

	public PageContentModule(WebDriver driver, TestPropertyBundle properties) {
		this.driver = driver;
		this.properties = properties;
	}
	
	public PageContentModule goToPage(String url) {
		System.out.println("Footer Header goToPageMethod(), url is" + url);
		
		driver.get(url);
		
		assertEquals(url, url); //always pass
		return this;
	}
	
	public PageContentModule verifyFirstParagraph(){
		System.out.println("Testing First Paragraph Header verifyFirstParagraph()");
		fail("this test needs to be written");
		return this;
	}
	
	
}




