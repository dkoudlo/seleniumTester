package project.modules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;

import data.bundle.TestPropertyBundle;

public class PageContentModule {
//	@Inject
//	TestPropertyBundle properties;

	@Inject
	WebDriver driver;

//	@Inject
//	protected void init(TestPropertyBundle properties) {
//		this.properties = properties;
//	}

	// Instantiate webdriver and properties-DONE
//	public PageContentModule(WebDriver driver, TestPropertyBundle properties) {
//		this.driver = driver;
//		this.properties = properties;
//	
//		
//		System.out.println("Form header default constructo, properties is"+ this.properties);
//		System.out.println("Form header default constructo, driver is"+ this.driver);
//
//	}

	// compare two string arraylist-DONE
	public PageContentModule goToPage(String url) {
		System.out.println("Footer Header goToPageMethod(), url is" + url);
		
		driver.get(url);
		
		assertEquals(url, url);
		return this;
	}
	
	public PageContentModule testHeaderText(){
		System.out.println("Footer Header testFooterText()");
		fail("this test needs to be written");
		return this;
	}
	
	
}




