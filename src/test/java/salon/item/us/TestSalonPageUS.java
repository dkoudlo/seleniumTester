package salon.item.us;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import project.modules.PageHeaderModule;
import project.modules.PageContentModule;

import com.google.inject.Inject;

import common.GenericSeleniumTest;
import data.bundle.TestPropertyBundle;

public class TestSalonPageUS extends GenericSeleniumTest{

	private TestPropertyBundle properties;

	@Inject
	WebDriver driver;

	PageHeaderModule footer;
	PageContentModule header;
	
	@Inject
	protected void init(TestPropertyBundle propertiesIn) {
		this.properties = propertiesIn;

	}
	
	
}
