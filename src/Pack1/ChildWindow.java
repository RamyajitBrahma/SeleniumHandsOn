package Pack1;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jit\\Desktop\\Selenium\\Latestdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup");
        driver.manage().window().maximize();
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Hello");
        //System.out.println(driver.getTitle());
        driver.findElement(By.linkText("Help")).click();
        System.out.println(driver.getTitle());
        
        Set<String>ids = driver.getWindowHandles();
        int size = ids.size();
        System.out.println("No of childwindows are: " + size);
       
        Iterator<String> its = ids.iterator();
        
        String parentid = its.next();
        
        String Chilids = its.next();
        driver.switchTo().window(Chilids);
        System.out.println(driver.getTitle());
        
        driver.switchTo().window(parentid);
        System.out.println(driver.getTitle());
        
        //$x("(//ul[@class='navigation clearfix'])[1]/parent::div/parent::nav/parent::div") can travgese back like this form one parent to anothretr
        //above xpath os from tis site "https://www.rahulshettyacademy.com/#/index"
        
        
        
       
        
        
        

	}

}
