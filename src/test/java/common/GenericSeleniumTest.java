package common;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import util.ScreenShotUtils;

import com.google.guiceberry.junit4.GuiceBerryRule;
import com.google.inject.Inject;

import data.bundle.TestPropertyBundle;

public class GenericSeleniumTest {
	//protected TestPropertyBundle properties;
	
	@Rule
	public GuiceBerryRule guiceBerry = new GuiceBerryRule(ProjectTestEnv.class);
	
	@Inject 
	public Logger log;
	
	@Inject 
	WebDriver driver;
	
//	@Rule 
//	public TestName name = new TestName();
//	
	@Inject protected TestPropertyBundle properties;
	
//	@Rule
//	public MethodRule watchman = new TestWatchman() {
//		// this method runs when test is failed (Note: runs after @After annotation)
//		@Override
//		public void failed(Throwable e, FrameworkMethod method) {
//			log.error("Test failed: " + method.getName(), e);
//			// Take Screen Shot
//			String classCanonicalName = method.getName();//.getMethod().getName().getClass().getCanonicalName();
//			new ScreenShotUtils(driver, classCanonicalName);
//		}
//		
//		// this method runs when the test is finished as the last thing in the test
//		@Override
//		public void finished(FrameworkMethod method) {
//			//log.info("Test finished: " + method.getName());
//			driver.quit();
//		}
//	};
	
	/*public void GenericSeleniumTest(@Named("US") TestPropertyBundle properties) {
		this.properties = properties;
	}*/
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Running tests: " + this.getClass().getName());
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Finished tests: " + this.getClass().getName());
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
//	public void setProperties(TestPropertyBundle properties) {
//		this.properties = properties;
//	}
}
