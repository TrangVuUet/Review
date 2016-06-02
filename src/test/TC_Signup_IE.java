package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC_Signup_IE {
  
	WebDriver driver = null;
	
  @BeforeTest
  public void beforeTest() {
	  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	  File file = new File(Common.IE_PATH);
	  System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	  driver = new InternetExplorerDriver(capabilities);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test (enabled = false)
  public void test_login() {
	  driver.get(Common.BASE_URL + "login");
	  driver.findElement(By.id("id_username")).sendKeys("trang");
	  driver.findElement(By.id("id_password")).sendKeys("123");
	  driver.findElement(By.id("btn_login")).click();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
