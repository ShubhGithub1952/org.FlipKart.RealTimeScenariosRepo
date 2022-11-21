package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureBrokenLinkTest {
	static WebDriver driver;
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.katespade.com/account-login");
			List<WebElement> links = driver.findElements(By.xpath("//a"));	
			//ArrayList<String> arrayUrlList = new ArrayList<String>();
			System.out.println("Size of All Links are :- "+links.size());
			for (WebElement urlLink : links) {
				String brokenUrl = urlLink.getAttribute("href");
				checkBrokenLinkUrl(brokenUrl);
			}
			
			driver.quit();
	}
		
		public static void checkBrokenLinkUrl(String linkurl) {
			try {
				URL url = new URL(linkurl);
				HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
				httpUrlConnection.setConnectTimeout(5000);
				httpUrlConnection.connect();
				
				if (httpUrlConnection.getResponseCode()>=400) {
					System.out.println(linkurl+"-->"+httpUrlConnection.getResponseMessage()+ " is a Broken Link !");
				}
				else {
					System.out.println(linkurl+"-->"+httpUrlConnection.getResponseMessage());
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
}
