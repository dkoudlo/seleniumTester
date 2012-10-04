package common;


import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	protected Logger log;
	protected WebDriver driver;
	protected TestPropertyBundle properties;
	
	@Provides
	@TestScoped
	public Logger getLogger() {
		log = Logger.getLogger(this.getClass());
		return log;
	}
	
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
		try {
			URL log4jPropertiesUrl = this.getClass().getResource("/data/log4j.properties");
			InputStream log4jPropertiesInputStream = log4jPropertiesUrl.openStream();
			Properties log4jProperties = new Properties();
			log4jProperties.load(log4jPropertiesInputStream);
			PropertyConfigurator.configure(log4jProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		properties = new TestPropertyBundle();
		
		install(new GuiceBerryModule());
		install(new TestPropertyBundleModule());
		
		bind(GuiceBerryEnvMain.class).to(ProjectEnv.class);
	}

	static class ProjectEnv implements GuiceBerryEnvMain {
		public void run() {
			// run scripts here 
		}
	}
}
