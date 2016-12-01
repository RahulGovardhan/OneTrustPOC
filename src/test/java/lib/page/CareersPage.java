package lib.page;

import static junit.framework.TestCase.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {

	WebDriver driver;
	WebDriverWait wait;

	public CareersPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public CareersPage verifyTitle(String title){
		assertEquals(title, driver.getTitle());
		return this;
	}
	
	public CareersPage getCurrentOpenings(String country) {
		driver.findElement(By.xpath("//a[@aria-controls='"+country+"']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='"+country+"']//ul/li/a")));
		List<WebElement> openings = driver.findElements(By.xpath("//div[@id='"+country+"']//ul/li/a"));
		System.out.println("Country Name : "+country.toUpperCase());
		System.out.println("----------------------------------------------");
		for (WebElement webElement : openings) {
			String opening = webElement.getText();
			System.out.println(opening);
		}
		System.out.println("----------------------------------------------");
		return this;
	}
}
