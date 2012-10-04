package salon.item.generic;

import static org.junit.Assert.assertEquals;

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
	
	@Override
	public void setUp() throws Exception{
		super.setUp();
		pageContentModule.goToPage(properties.strings.get("project.item.url"));
	}
	
	public void testContent() {
		pageContentModule.verifyFirstParagraph();
		
		
		assertEquals( driver.getTitle() ,  driver.getTitle());
	}
	
	public void testHeader() {
		pageHeaderModule.testHeaderText();
		
	}
	
}
