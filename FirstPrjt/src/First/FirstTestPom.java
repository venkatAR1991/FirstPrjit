package First;

import java.time.Duration;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FirstTestPom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


	
 ChromeOptions option = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Barrla\\Desktop\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(option);
	//driver.get("https://www.google.co.in");
	driver.get("https://www.leafground.com/window.xhtml");
	option.addArguments("--remote-allow-origins=*");
	option.addArguments("--incognito");
	option.addArguments("--headless");
	  option.addArguments("--window-size=1200,800"); // Set the window size
	  
	  //get title
	String name=  driver.getTitle();
	System.out.println("the title of page is :" + name);
	
	//close the browser
	//driver.close();
	 
String	oldwindow=driver.getWindowHandle();	
	
	WebElement openB = driver.findElement(By.id("j_idt88:new"));
		openB.click();
		
		Set<String>  handles= driver.getWindowHandles();
		for (String newwindow : handles) {
			driver.switchTo().window(newwindow);
			}
		String D=driver.getTitle();
		System.out.println("the new windows title is :"+ D);
			WebElement serch = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/ul/li[1]/input"));
	serch.sendKeys("I entered the new window");
	Thread.sleep(300);
	driver.close();
	
	driver.switchTo().window(oldwindow);
	
	WebElement OM = driver.findElement(By.id("j_idt88:j_idt91"));
	OM.click();
	
	int numwh =	driver.getWindowHandles().size();
	System.out.println("the number of windows opened :" +numwh);

	String NW1=	driver.getTitle();
	System.out.println("Current windows title is :" + NW1);


	
	Set<String> winhandles = driver.getWindowHandles();
	for (String NewWindow : winhandles) {
		if (!NewWindow.equals(oldwindow)) {
			driver.switchTo().window(NewWindow);
			
			driver.close();
			
			// Switch back to the original window
	        driver.switchTo().window(oldwindow);
	        
	        // Wait for an element in the original window    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt95")));
		
		
		  WebElement em = driver.findElement(By.id("j_idt88:j_idt95")); em.click();
		 
	String lm=	driver.getTitle();
	System.out.println("the overall title of the page : "+ lm);
	
	
	int  po=	driver.getWindowHandles().size();
	System.out.println("the overall opeened window are : " + po);
		//driver.quit();
			/*
			 * WebElement delay = driver.findElement(By.id("j_idt88:j_idt95"));
			 * delay.click();
			 */
			
			
			  
		}	 
		}
		}
	} 
			
		
		
	
	
	

	


