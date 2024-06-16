package indivituals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {
	
	public static WebDriver driver;
	
	public static WebElement waitForElement(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}

	public static WebElement waitForElement2(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public  void launchBroser() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
	}
	public void launchURL(String URL) {
		driver.get(URL);
	}
	
	public void login(String userName, String password) {
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	}
	
	public  void clickWaffle() throws InterruptedException {
		//Click on the toggle menu button from the left corner
		By WaffleIcon = By.className("slds-icon-waffle_container");
		Library.waitForElement(Library.driver, WaffleIcon, 40).click();
		
		//Click View All link
		By viewAllLink1 = By.xpath("(//button[@class='slds-button'])[2]");  //button[text()='View All']
		Library.waitForElement(Library.driver, viewAllLink1, 40).click(); 
		
		}
	public  void search_Sales()	{
		
		//search with sales in search box
		By searchTextBox = By.xpath("//input[@class='slds-input']");
		Library.waitForElement(Library.driver, searchTextBox, 20).sendKeys("sales");

		Library.driver.findElement(By.xpath("//p[contains(text(),'Manage your sales process')]/preceding-sibling::a//span//mark")).click();
	}
	
	
	public void search_workType() {
		//search with sales in search box
		By searchTextBox = By.xpath("//input[@class='slds-input']");
		Library.waitForElement(Library.driver, searchTextBox, 20).sendKeys("Work Types");
		Library.driver.findElement(By.xpath("//mark[text()='Work Types']")).click();
		

		//Library.driver.findElement(By.xpath("//p[contains(text(),'Manage your sales process')]/preceding-sibling::a//span//mark")).click();
			}
			
		
	
	public  void jsExecutor()	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
}
