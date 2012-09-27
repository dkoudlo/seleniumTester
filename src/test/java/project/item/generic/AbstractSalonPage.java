package project.item.generic;

import java.util.ArrayList;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import project.modules.PageContentModule;
import project.modules.PageHeaderModule;

import com.google.inject.Inject;
import common.GenericSeleniumTest;

import data.bundle.TestPropertyBundle;

public abstract class AbstractSalonPage extends GenericSeleniumTest {
	
	@Inject
	protected WebDriver driver;

	protected TestPropertyBundle properties;
	
	protected PageContentModule pageContentModule;
	protected PageHeaderModule pageHeaderModule;


	@Inject protected void init(TestPropertyBundle properties) {
		this.properties = properties;
		pageContentModule = new PageContentModule(driver, properties);
		pageHeaderModule = new PageHeaderModule(driver, properties);
		
	}
	
	@Override @Before public void setUp() throws Exception {
		super.setUp();
		
		
	}
}
