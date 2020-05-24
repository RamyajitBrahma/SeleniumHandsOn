package Pack1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellenous {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebElement iFrame = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame("courses-iframe");

		// find no of links in header
		WebElement header = driver.findElement(By.xpath("//header[@class='main-header']"));
		int noOfLinksInHeader = header.findElements(By.tagName("a")).size();
		List<WebElement> allHeaderLinks = header.findElements(By.tagName("a"));

		System.out.println("No Of header Links : " + noOfLinksInHeader);
		
		//Capturing the parent ID of the first window .. useful to get back to the first window
		   String parentWindowId = driver.getWindowHandle();
		   
		// Opening all the header links in new TABS from Home link until Jobs link
		for (int i = 4; i < noOfLinksInHeader; i++) {
			String linkNames = allHeaderLinks.get(i).getText().trim();
			System.out.println("Link Name : " + linkNames);

			String rightClickCommand = Keys.chord(Keys.CONTROL, Keys.ENTER);
			allHeaderLinks.get(i).sendKeys(rightClickCommand);
			Thread.sleep(5000L);
			if (linkNames.contains("Mentorship")) {
				
				break;
			}

		}
        
		//Reading the names of the new TABS opened for each link
		Set<String> windowIdHandle = driver.getWindowHandles();
		//int noOfWindowOpened = windowIdHandle.size();
		Iterator<String> windowsItertetor = windowIdHandle.iterator();
		
		while(windowsItertetor.hasNext()) {
			String windowIds = windowsItertetor.next();
			driver.switchTo().window(windowIds);
			Thread.sleep(2000L);
			String windowTitle = driver.getTitle();
			System.out.println("Window Title : "+windowTitle);
			
			String windowUrl = driver.getCurrentUrl();
			System.out.println("Window URL : "+windowUrl);
		}
		
		//getting back to the parent wondow
		driver.switchTo().window(parentWindowId);
		System.out.println("It witched back to parent window : "+parentWindowId);
		
		
		
		
	}

}
