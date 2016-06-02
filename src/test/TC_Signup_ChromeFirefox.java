package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC_Signup_ChromeFirefox {
	
	public WebDriver driver;
	public WebDriver dr;
	

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		dr = Common_MultiBrowser.setup_multibrowser(browser, driver);
		
	}

	@Test
	public void signup_tc() {
		if (dr == null) System.out.println("null");
		
		dr.get(Common.BASE_URL + "signup/public/");
		dr.findElement(By.name("first_name")).sendKeys("Trang");
		dr.findElement(By.name("last_name")).sendKeys("Vu");
		dr.findElement(By.name("email")).sendKeys("abc@gmail.com");
		dr.findElement(By.name("password")).sendKeys("123");
		//
		Select question = new Select(dr.findElement(By
				.name("answer_occupation")));
		question.selectByVisibleText("Student");
		dr.findElement(By.id("submit-public")).click();
	}

	@AfterTest
	public void afterTest() {
		dr.close();
	}

}
