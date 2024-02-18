package settings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shortcut extends setting{
public void login(String user, String pass) {
	driver.findElement(By.id("userEmail")).sendKeys(user);
	 driver.findElement(By.id("userPassword")).sendKeys(pass);
	 driver.findElement(By.id("login")).click();
}
	public void waitforvis(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

		
	}
	public void waitforinv(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));

		
	}
	public WebElement streem(String produ, By findBy) {
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		return products.stream().filter(product -> product.findElement(findBy).getText().equals(produ)).findFirst().orElse(null);

	}
	
	public boolean matching(List<WebElement> x, String m) {
		boolean match = x.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(m));
		return match;
		
	}
	
	public void list(String cssselector,int nth,String key) {
		List<WebElement>list = driver.findElements(By.cssSelector(cssselector));
		list.get(nth).sendKeys(key);
	}
}
