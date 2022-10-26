package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author SHUBH
 * Capture Broken Link
 */
public class CaptureTheBrokenLinksOfWebPageTest {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		
		 List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		 
		 HashSet<String> brokenUrl = new HashSet<String>();
		 for (WebElement webLink : allLinks) {
			// Thread.sleep(3000);
			 String linkUrl = webLink.getAttribute("href");
			 URL url = new URL(linkUrl);
			 URLConnection urlOpenConnection = url.openConnection();
			 HttpURLConnection httpUrlConnection= (HttpURLConnection) urlOpenConnection;
			 httpUrlConnection.setConnectTimeout(5000);
			 httpUrlConnection.connect();
			 if (httpUrlConnection.getResponseCode()!=200) {
				 brokenUrl.add(linkUrl);
			}else {
				System.out.println(linkUrl+" :- "+httpUrlConnection.getResponseMessage());
			}
			 httpUrlConnection.disconnect();
		 }	
		 driver.quit();
		 for (String url : brokenUrl) {
			System.out.println(url);
		}
	}
}
