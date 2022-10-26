package FlipkartPhone;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllPhonesNameFromFlipkart {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("phones");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		ArrayList<String> phoneName = new ArrayList<String>();
		ArrayList<Integer> price = new ArrayList<Integer>();
		WebElement nextText = driver.findElement(By.xpath("//span[text()='Next']"));
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        TreeSet<String> set = new TreeSet<String>();
		//		for (; ;) 
		//			try {
		//				nextText.click();
		//			} catch (Exception e) {
		//				JavascriptExecutor jse = (JavascriptExecutor)driver;
		//				jse.executeScript("window.scrollBy(0,300)");
		//			}
		//		}
		int page=1;
		while (page<=5) {
			//wait.until(ExpectedConditions.elementToBeClickable(nextText);
			List<WebElement> phoneNames1 = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			List<WebElement> price1 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
			if (nextText.isDisplayed()) {
				for (WebElement str : phoneNames1) {
					String str1 = str.getText();
					phoneName.add(str1);
				}
				for (WebElement str : price1) {
					String str1 = str.getText().substring(1).replace("," , "");
					int price2 = Integer.parseInt(str1);
					price.add(price2);
				}

				nextText.click();
			}else {
				break;
			}
			page++;
			Thread.sleep(3000);

		}
		for (int i = 0; i < phoneName.size(); i++) {
			map.put(phoneName.get(i), price.get(i));
		}

//		for (String str : phoneName2) {
//			System.out.println(str);
//		}
//		for (String str : price2) {
//			System.out.println(str);
//		}
		System.out.println("=========================Before Sorting ======================");
		for (Entry<String, Integer> mapset :map.entrySet()) {
			String value = mapset.getKey()+" :- "+mapset.getValue();
			System.out.println(value);
			set.add(value);
		}
		System.out.println("==========================After Sorting==================");
		for (String set1 : set) {
			
			System.out.println(set1);
		}
		driver.quit();
	}
}
