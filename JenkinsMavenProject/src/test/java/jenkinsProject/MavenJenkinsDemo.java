package jenkinsProject;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenJenkinsDemo {

	WebDriver driver;

	@Test
	public void mavenJenkinTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://google.com");

		String title = driver.getTitle();
		System.out.println("website-title: " + title);
		String expectedTitle = "Google";
		assertEquals(title, expectedTitle);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("laptops");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/ul/li[1]/div[1]/div/span")).click();
		Thread.sleep(5000);

		driver.close();
	}

}

