package qaisr;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class qCards extends BeforeAndAfterMethod{
@Test(groups = "Qaisr")
public void bvcards() {
	driver.get(prop.getProperty("Home"));
	driver.manage().addCookie(new Cookie(cookie1.getName(), cookie1.getValue()));
	driver.navigate().to(prop.getProperty("Welcome"));
	
	driver.findElement(By.cssSelector("a[href*='q-cards']")).click();
	driver.findElement(By.cssSelector(".btn")).click();
	List <WebElement> cards = driver.findElements(By.cssSelector(".card"));
	for(int i = 0 ; i < cards.size();i++) {
		cards.get(i).click();
	}
	
}
}
