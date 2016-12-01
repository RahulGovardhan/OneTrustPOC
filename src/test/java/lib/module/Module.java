package lib.module;

import java.util.concurrent.TimeUnit;

import lib.data.TestData.CareersData;
import lib.data.TestData.ModuleData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Module {

	WebDriver driver;
	WebDriverWait wait;

	public Module(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public Module navigateToCarriers(){
		//Commented the below approach because the following code is not working consistently
		
		/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lib.locators.Module.COMPANY)));
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(lib.locators.Module.COMPANY))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lib.locators.Module.CAREERS)));
		driver.findElement(By.xpath(lib.locators.Module.CAREERS)).click();*/
		
		driver.get(ModuleData.URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.titleContains(CareersData.TITLE));
		return this;
	}
}
