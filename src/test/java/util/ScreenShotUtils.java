package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class ScreenShotUtils {

	private SimpleDateFormat dateFormat;
	private Date date;
	private String separator;
	private String projDirectory;
	private File srcFile;

	private String getTimeStamp(){
		dateFormat = new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
		date = new Date();

		return dateFormat.format(date);
	}
	
	public ScreenShotUtils(WebDriver driver, String className) {
		separator = System.getProperty("file.separator");
		projDirectory = System.getProperty("user.dir");
		
		// RemoteWebDriver does not implement the TakesScreenshot class
        // if the driver does have the Capabilities to take a screenshot
        // then Augmenter will add the TakesScreenshot methods to the instance
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        
        srcFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File( projDirectory 
					+ separator
					+ "target"
					+ separator
					+ "selenium-screenshots"
					+ separator
					+ className
					+ "_"
					+ this.getTimeStamp()
					+ ".jpg"));
		} catch (IOException e) {
			System.out.println("Taking screenshot failed: ");
			e.printStackTrace();
		}
		
		augmentedDriver.close();
		augmentedDriver.quit();
	}
}
