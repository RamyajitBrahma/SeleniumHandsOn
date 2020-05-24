package Pack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// *************** STATIC and Dynamic Drop Downs *******************************

		driver.get("http://spicejet.com/");
		driver.manage().window().maximize();

		// Static Drop Down
		WebElement Currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select curDropdowns = new Select(Currency);
		curDropdowns.selectByVisibleText("USD");

		// Dynamic Drop Down

		WebElement fromstation = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		WebElement tostation = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		Thread.sleep(2000);
		fromstation.click();

		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000);

		List<WebElement> Noofelements = driver.findElements(By.xpath("//a[@value='CCU']"));
		int count = Noofelements.size();
		System.out.println(count);
		// Option1 write the xpath inthe below way
		driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();

		// Option2 write it in the below way with the parent ID
		// driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']
		// //a[@value='CCU']")).click();

		Assert.assertTrue(true);
	
		System.out.println("Assert PAssed");
		if (driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).getAttribute("id").contains("CC")) {
			System.out.println("PASS");
			System.out.println(driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).getAttribute("value"));
		}

		else {
			System.out.println("Fail");
			System.out.println(driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).getAttribute("value"));
		}

	}

	// *************** STATIC and Dynamic Drop Downs *******************************

}
