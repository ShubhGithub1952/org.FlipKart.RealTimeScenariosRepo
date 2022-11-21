package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This this Class We Are Captureing the Broken Link
 * @author SHUBH
 *
 */
public class CaptureTheBrokenLinksOfWebPage3Test {
	static WebDriver driver;
	@Test
	public void captureBrokenLinkTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement userNameTextField = driver.findElement(By.xpath("//input[@name='username']"));
		userNameTextField.clear();
		userNameTextField.sendKeys("Admin");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextField.clear();
		passwordTextField.sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> AllWebelementLinks = driver.findElements(By.xpath("//a"));
		System.out.println(AllWebelementLinks.size());
		// Take The Link of All WebElement 
		for (WebElement ele : AllWebelementLinks) {
			String allHomePageLinks = ele.getAttribute("href");
		CaptureTheBrokenLinksOfWebPage3Test obj = new	CaptureTheBrokenLinksOfWebPage3Test();
		obj.getLinks(allHomePageLinks);
		}
		driver.quit();
	}
	
	public void getLinks(String urlLink ) throws Throwable {
		URL url = new URL(urlLink);
		HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
		httpUrlConnection.setConnectTimeout(5000);
		httpUrlConnection.connect();
		if (httpUrlConnection.getResponseCode()>=400) {
			System.out.println(urlLink+" "+httpUrlConnection.getResponseMessage());
		}
		else {
			System.out.println(urlLink+" :- "+httpUrlConnection.getResponseMessage());
		}
		httpUrlConnection.disconnect();
	}
}
