package settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class setting  {
public static WebDriver driver;
public static Properties prop = new Properties();
public static JavascriptExecutor jsExecutor;
public static WebStorage webStorage;
public static LocalStorage localStorage;
public static WebDriverWait wait;
public static String token;
public static Cookie cookie1;

public void Setup() throws IOException {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\qaisr\\resources\\Data.properties");
	prop.load(fis);
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		 jsExecutor = (JavascriptExecutor) driver;
		  webStorage = (WebStorage) new Augmenter().augment(driver);
			
		 localStorage = webStorage.getLocalStorage();
	 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);  
		 wait= new WebDriverWait(driver, Duration.ofSeconds(10));

	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.manage().window().maximize();
}
public static ExtentReports getReport() {
	String path = System.getProperty("user.dir")+"\\reportHTML\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Result");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ryan");
	return extent;
}

public String getScreenshot(String string) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+"//reports//"+string+".png");
FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+string+".png";
	
}

public void after() {
	driver.close();
}

}
