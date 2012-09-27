package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForUtils extends ExpectedConditionHelperUtils{

	public void waitForElementPresent(WebDriver driver, By by){
		//wait for element present
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(visibilityOfElementLocated(by)); //By.name("addressUpdateForm"))
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
	
	public void waitForElementVisible(WebDriver driver, By by){
		//wait for element visible
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(presenceOfElementLocated(by)); //(By.name("addressUpdateForm"))
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
