package test.auto;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_scripts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F://Selenium_IDE_new_course//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Step1. Navigate to the Browser :- https://www.google.ca/
		driver.navigate().to("https://www.google.ca/");
		
		//Step2. Search for "Kira Systems"
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Kira Systems");
		driver.findElement(By.xpath("//input[@name='btnK']")).submit();
		
		//Step3. Verify the first result is a link to “https://kirasystems.com/”
		String link = "https://kirasystemss.com/";
	    List <WebElement> links= driver.findElements(By.xpath("//div[@id='rso']//a"));
	    String firstLink = links.get(0).getAttribute("href");
	    
	    if(firstLink.equals(link))
	    System.out.println("First Result link is link to the :- "+firstLink);
	    
	    //Step4. Take a screenshot if the test case failed
	    else {
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("F://screenshot.png"));
	    }
	    
	}

}
