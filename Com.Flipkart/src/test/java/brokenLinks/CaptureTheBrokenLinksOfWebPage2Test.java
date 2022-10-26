package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTheBrokenLinksOfWebPage2Test {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		HashSet<String> brokenLink = new HashSet<String>();
		for (WebElement webLink : allLinks) {
			String linkUrl = webLink.getAttribute("href");
			URL url = new URL(linkUrl);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpUrlConnection=(HttpURLConnection) urlConnection;
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if (httpUrlConnection.getResponseCode()!=200) {
				brokenLink.add(linkUrl);
			}else {
				//System.out.println(linkUrl+" :- "+httpUrlConnection.getResponseMessage());
			}
			httpUrlConnection.disconnect();
		}
		for (String str : brokenLink) {
			System.out.println(str);
		}
		driver.quit();
		
	}
}
