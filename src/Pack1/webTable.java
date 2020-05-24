package Pack1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22760/ind-vs-aus-1st-odi-australia-tour-of-india-2020");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// xpath for the first row of the batting table can also e written like :   $x("((//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]/div)[3]")
		WebElement firstInningsTable = driver.findElement(By.xpath("(//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		//Finding the row count
		int RowCount = firstInningsTable.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']")).size();
		
		
		List<WebElement> firstInningsTableRows = firstInningsTable.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']/div[3]"));
		int count = firstInningsTableRows.size();
		int sum = 0;
		
		
		for(int i=0;i<count-2;i++) {
			String batsmanRun = firstInningsTableRows.get(i).getText();
			
			System.out.println(batsmanRun);
			//int batsmanRunInt = Integer.parseInt(batsmanRun);
			//sum=sum+batsmanRunInt;
			//System.out.println(sum);
			
		}
		//printing the first innings extra
		String firstInningExtras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
		//String firstInningExtras = driver.findElement(By.xpath("(//div[text()='Extras'])[2]/following-sibling::div[1]")).getText();   Can Write this also
		System.out.println("firstinnings extra : "+firstInningExtras);
		
		//prointing the soncd inning extras
		String secondInningExtras = driver.findElement(By.xpath("(//div[text()='Extras'])[2]/following-sibling::div[1]")).getText();
		System.out.println("Secondinnings extra : "+secondInningExtras);
	}

}
