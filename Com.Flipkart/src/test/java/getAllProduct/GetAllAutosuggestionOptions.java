package getAllProduct;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllAutosuggestionOptions {
	
	public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("taj mahal");
	List<WebElement> autosuggestion = driver.findElements(By.xpath("//li[@role='presentation' and not (@id='dh215c') and not (@id='YMXe')]"));
	//System.out.println(autosuggestion);
	//Thread.sleep(5000);
	for ( WebElement ele : autosuggestion) {
		System.out.println(ele.getText());
		
	}
	}
	
}
