package project.modules;

import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

import data.bundle.TestPropertyBundle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FormFooterModule {
	
//	@Inject
//	TestPropertyBundle properties;
//	
	@Inject
	WebDriver driver;
	
//	public FormFooterModule(WebDriver driver, TestPropertyBundle properties) {
//		this.driver = driver;
//		this.properties = properties;
//		
//		
//		System.out.println("Form footer default constructo, properties is"+ this.properties);
//		System.out.println("Form footer default constructo, driver is"+ this.driver);
//		
//	}
	
	
	public FormFooterModule goToPage(String url){
		System.out.println("Footer Module goToPageMethod(), url is" + url);

		
		assertEquals(url, url);
		driver.get(url);
		return this;
	}
	
	
	public FormFooterModule testFooterText(){
		System.out.println("Footer Module testFooterText()");
		fail("this test needs to be written");
		return this;
	}
	
}
