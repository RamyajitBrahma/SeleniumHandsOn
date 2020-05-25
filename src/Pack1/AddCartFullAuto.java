package Pack1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartFullAuto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		//**********   Waits  ****************
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//hard coded wait
		Thread.sleep(2000);
		//Explicit wait
		WebDriverWait waitObj = new WebDriverWait(driver,5);
		//waiting 5 seconds for the GreenCart logo to appear which will show that it has landed in the home page
		waitObj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='brand greenLogo']")));
		System.out.println("Git Check");
		
		
		
		
		//**********   Waits  ****************

		String[] veggies = { "Brocolli", "Carrot", "Beans" };
		int NoOfVeggiesToBeSelected = veggies.length;
		System.out.println("No of Veggies to be selected : " + NoOfVeggiesToBeSelected);

		List<WebElement> NoOfProductsList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int NoOfProducts = NoOfProductsList.size();
		System.out.println("No of products : " + NoOfProducts);

		List<WebElement> NoOfAddCartButtonList = driver.findElements(By.xpath("//div[@class='product-action']/button"));
		int noOfAddCartbutton = NoOfAddCartButtonList.size();
		// Converting to arraylist to use cintaiins
		List<String> VeggieList = Arrays.asList(veggies);

		// running through all te products
		int counterforloop = 0;
		for (int i = 0; i < NoOfProducts; i++) {

			String[] productNameArr = NoOfProductsList.get(i).getText().split("-");
			String productName = productNameArr[0].trim();

			if (VeggieList.contains(productName)) {
				NoOfAddCartButtonList.get(i).click();
				Thread.sleep(2000);
				counterforloop++;
				if (counterforloop == NoOfVeggiesToBeSelected) {
					break;
				}
			}

		}

	}

}
