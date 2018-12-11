package jenkinsProject;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
	
	
	WebDriver driver;
	
	@Test
	public void loginTest() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://myuat.ginniemae.gov/");
		
		driver.findElement(By.id("T:j_id__ctru15pc14")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("terry.aki@ampcusinc.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Conf_14900");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/input[6]")).click();
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("website-title: " + title);
		String expectedTitle = "Issuer Dashboard";
		assertEquals(title, expectedTitle);
		
		driver.close();
		
		
		
	}

}
