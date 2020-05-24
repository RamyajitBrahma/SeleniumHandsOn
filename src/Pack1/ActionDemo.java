package Pack1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class ActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Hello");
        System.out.println(driver.getTitle());
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement accntlist = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		//a.contextClick(searchbox);
		a.contextClick(accntlist).build().perform();
		
		


	}

}
