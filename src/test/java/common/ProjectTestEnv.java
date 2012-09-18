package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.guiceberry.GuiceBerryEnvMain;
import com.google.guiceberry.GuiceBerryModule;
import com.google.guiceberry.TestScoped;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import data.bundle.TestPropertyBundle;
import data.bundle.TestPropertyBundleModule;

public class ProjectTestEnv extends AbstractModule {
	//protected Logger log;
	protected WebDriver driver;
	protected TestPropertyBundle properties;
	
//	@Provides
//	@TestScoped
//	public Logger getLogger() {
//		log = Logger.getLogger(this.getClass());
//		return log;
//	}
	
//	@Provides
//	@TestScoped
//	WebDriverWait getWebDriverWait() {
//		return new WebDriverWait(getWebDriver(), properties.longs.get("default.timeOut").longValue());
//	}
	
//	@Provides
//	@TestScoped
//	WebDriver getWebDriver() { 
//		log.info("Instantiating Webdriver.");
//
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		URL url = null;
//		try {
//			url = new URL("http://sjbude813v.corp.webex.com:4444/wd/hub");
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		//capability.setBrowserName("chrome18");
//		capability.setVersion("3.5");
//		
//		capability.setPlatform(Platform.WINDOWS);
//		
//		WebDriver driver = new RemoteWebDriver(url, capability);
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		return driver;
//	}
	
	@Provides
	@TestScoped
	WebDriver getWebDriver() { 
		if(driver == null){
			driver = new FirefoxDriver();
			
		}
		
		return driver;
	}
	
	
	@Override
	protected void configure() {
//		try {
//			URL log4jPropertiesUrl = this.getClass().getResource("/data/log4j.properties");
//			InputStream log4jPropertiesInputStream = log4jPropertiesUrl.openStream();
//			Properties log4jProperties = new Properties();
//			log4jProperties.load(log4jPropertiesInputStream);
//			PropertyConfigurator.configure(log4jProperties);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		install(new GuiceBerryModule());
		properties = new TestPropertyBundle();
		install(new TestPropertyBundleModule());
		bind(GuiceBerryEnvMain.class).to(PSSEnv.class);
	}

	static class PSSEnv implements GuiceBerryEnvMain {
		public void run() {
			// dont do anything here
		}
	}
}
