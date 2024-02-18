package qaisr;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class pumpingLemma extends BeforeAndAfterMethod{
	@Test(groups = "Qaisr")
public void oumbLema() throws InterruptedException {
		driver.get(prop.getProperty("Home"));
		driver.manage().addCookie(new Cookie(cookie1.getName(), cookie1.getValue()));
		driver.navigate().to(prop.getProperty("Welcome"));
		
		driver.findElement(By.cssSelector("a[href*='PumpingLemma']")).click();
		driver.findElement(By.cssSelector(".n")).sendKeys("AB");
		driver.findElement(By.cssSelector("#num")).sendKeys("10");
		driver.findElement(By.cssSelector("button[onclick='add()']")).click();
		Thread.sleep(2000);
}
}
