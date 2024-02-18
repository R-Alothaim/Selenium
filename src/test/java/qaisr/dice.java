package qaisr;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import Listener.Retry;





public class dice extends BeforeAndAfterMethod{

@Test(retryAnalyzer = Retry.class)
public void dicee() throws IOException {
	driver.get(prop.getProperty("Dice"));
	while(true) {
		driver.findElement(By.cssSelector("#go-button")).click();
	   // WebElement htmlTag = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".roll-group span")));
	    //wait.until(ExpectedConditions.stalenessOf(htmlTag));
		//String span = driver.findElement(By.cssSelector(".roll-group span span")).getAttribute("textContent");
		String span = (String) jsExecutor.executeScript("return document.querySelector('.roll-group span span').innerText;");
		System.out.println(span);
		if(span.equalsIgnoreCase("6")) {
			break;
		}
		
	}
	getScreenshot("6");
}

}
