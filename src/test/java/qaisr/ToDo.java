package qaisr;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;


public class ToDo extends BeforeAndAfterMethod{
	@Test(groups = "Qaisr")
	public void ToDoo() throws InterruptedException   {
		
		driver.get(prop.getProperty("Home"));
		driver.manage().addCookie(new Cookie(cookie1.getName(), cookie1.getValue()));
		driver.navigate().to(prop.getProperty("Welcome"));
		
		driver.findElement(By.cssSelector("a[href*='To-Do-List']")).click();
		while(driver.findElements(By.cssSelector("tbody")).size()>1) {
				driver.findElement(By.cssSelector(".tab tbody:nth-child(2) a:first-of-type")).click();
			}
		
		driver.findElement(By.cssSelector("input[name='todo']")).sendKeys("Yess");
		driver.findElement(By.cssSelector("input[name='date']")).sendKeys("01-01-2024");
		driver.findElement(By.cssSelector(".add")).click();
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
