package qaisr;

import java.util.HashMap;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Listener.Retry;

public class Login extends BeforeAndAfterMethod {


	@Test(groups = "Qaisr" , dataProvider = "dataprovid", retryAnalyzer = Retry.class)
	public void sqlInjection(HashMap<String, String> inp) {
		driver.get(prop.getProperty("Login"));
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(inp.get("user"));
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(inp.get("pass"));
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		
		cookie1 = driver.manage().getCookieNamed("PHPSESSID");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Test(groups = "r")
	public void authLogin() {

		driver.get(prop.getProperty("r"));
		login(prop.getProperty("user"), prop.getProperty("pass"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 token = localStorage.getItem("token");
		
	}
	@Test(groups = "r",dependsOnMethods = "authLogin")
	public void testToken() {
		driver.get(prop.getProperty("r"));

		localStorage.setItem("token", token);
		driver.get(prop.getProperty("r"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] dataprovid(){
		HashMap<String, String> F=new HashMap<String, String>();
		F.put("user", "' or 1=1 limit 1 -- -");
		F.put("pass", "12");
		HashMap<String, String> S=new HashMap<String, String>();
		S.put("user", "' or 1=1 limit 1 -- -");
		S.put("pass", "12");
		
		return new Object[][] {{S}};
		
	}
}
