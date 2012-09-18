package util;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import common.GenericSeleniumTest;

public class UniqueEmailUtils extends GenericSeleniumTest{

	@Inject WebDriver driver;
	public String UniqueEmail() throws Exception {
		
	driver.get("http://mail.qa.webex.com/");
	ExpectedCondition<WebElement> element = new ExpectedCondition<WebElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/b/a"));
		}
	};
	new WebDriverWait(driver, 10).until(element);
	assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/b/a")).isDisplayed());
	
	driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/b/a")).click();
	
	ExpectedCondition<WebElement> element1 = new ExpectedCondition<WebElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/font/b"));
		}
	};
	new WebDriverWait(driver, 10).until(element1);
	assertTrue(driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/font/b")).isDisplayed());
	
	Date date;
	date = new Date();
	String uniqueID = new SimpleDateFormat("MM-dd-yy-HH.mm.ss.SSS").format(date);
	
	
	driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr/td[2]/input")).sendKeys("selenium" + uniqueID);
	driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td[2]/input")).sendKeys("qa1234");
	driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td[2]/input")).sendKeys("qa1234");
	driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[3]/td/input")).click();
	
	
	ExpectedCondition<Boolean> condition1 = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            return driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/font/b")).getText().contains("creation successful.");
        }
    };
	new WebDriverWait(driver, 10).until(condition1);
	
	System.out.println("Your unique email address is: selenium" + uniqueID + "@qa.webex.com");
	return "selenium" + uniqueID + "@qa.webex.com";
	}
}
