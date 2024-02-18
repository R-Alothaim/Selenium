package qaisr;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import settings.shortcut;

public class BeforeAndAfterMethod extends shortcut{
	@BeforeMethod(alwaysRun = true)
	public void before() throws IOException {
		Setup();
	}
	@AfterMethod(alwaysRun = true)
	public void aftermethod() {
		after();
	}


}
