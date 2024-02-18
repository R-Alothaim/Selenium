package qaisr;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;


public class RPS extends BeforeAndAfterMethod{
	@Test(groups = "Qaisr")
	public void RPSs() {
		driver.get(prop.getProperty("Home"));
		driver.manage().addCookie(new Cookie(cookie1.getName(), cookie1.getValue()));
		driver.navigate().to(prop.getProperty("Welcome"));
		driver.findElement(By.cssSelector("a[href*='RPS']")).click();
		driver.findElement(By.cssSelector("img[alt='scissors']")).click();
		driver.findElement(By.cssSelector("img[alt='paper']")).click();
		driver.findElement(By.cssSelector("img[alt='rock']")).click();
		driver.findElement(By.cssSelector(".reset")).click();
		driver.findElement(By.cssSelector(".auto")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
