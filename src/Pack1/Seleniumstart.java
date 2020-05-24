package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Seleniumstart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://login.salesforce.com");
        //driver.manage().window().maximize();
        
        //System.out.println(driver.getTitle());
       // driver.findElement(By.xpath("//*[@id='username']")).sendKeys("abcd");
        //String a = driver.findElement(By.xpath("//*[@id='username']")).getText();
       // System.out.println("dfssf"+a);
        //driver.findElement(By.linkText("Forgot Your Password?")).click();
        
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();
        
        //driver.findElement(By.linkText("Courses")).click();
        //boolean a = driver.findElement(By.linkText("Practice Project")).isDisplayed();
        String a = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[2]/a")).getText();        
        System.out.println(a);
        boolean b = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[2]/a")).isDisplayed();
        System.out.println(b);
        boolean c = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[2]/a")).isEnabled();
        System.out.println(c);
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[2]/a")).click();
        //driver.findElement(By.linkText("Practice Project")).click();
        
        
	}

}
