package Pack1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> veggieList = driver.findElements(By.xpath("//table[@class='table table-striped table-bordered table-sm']/tbody/tr/td[2]"));
		
		int noOfRows = veggieList.size();
		
		ArrayList<String> veggieArrList = new ArrayList<String>();
		
		for(int i=0;i<noOfRows;i++) {
			String veggieName = veggieList.get(i).getText();
			veggieArrList.add(veggieName);
			System.out.println("Original List  " +veggieArrList.get(i));
		}
		System.out.println("List tpo be prinyed as arralist"+veggieArrList);
		ArrayList<String> copiedVeggieArrList = new ArrayList<String>();
		
		for(int j=0;j<veggieArrList.size();j++) {
			copiedVeggieArrList.add(veggieArrList.get(j));
			System.out.println("Copied List befor sorting " +copiedVeggieArrList.get(j));
		}
		
		//Sorting the copied list now to compare with the original list
		Collections.sort(copiedVeggieArrList); // ascending sort
		//Collections.reverse(copiedVeggieArrList);//descending sort
		
		for(String sortedStr : copiedVeggieArrList) {
			System.out.println("Copied list after sirting : "+sortedStr);
		}
		
		//Validaitng if the original one is sorted or not
		if(copiedVeggieArrList.equals(veggieArrList)) {
			System.out.println("it is in ascending order");
		}
		else {
			System.out.println("it is NOT in ascending order");
		}
	}

}
