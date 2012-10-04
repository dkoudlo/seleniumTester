package salon.item.us;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import salon.item.generic.AbstractSalonPage;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import data.bundle.TestPropertyBundle;

public class TestSalonPageUS extends AbstractSalonPage{

	@Inject protected WebDriver driver;

	@Override @Inject protected void init(@Named("Salon US") TestPropertyBundle properties) {
		super.init(properties);
	}

	@Override @Before public void setUp() throws Exception {
		super.setUp();
		System.out.println("Setting up "+ this.getClass().getCanonicalName().toString());
	}
	
	@Override @Test public void testContent(){ super.testContent(); }
	
}
