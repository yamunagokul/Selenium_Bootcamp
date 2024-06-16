package accounts;



import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import indivituals.Library;


public class Create_Account_S1106 {
	
	static Random rand=new Random();
	public static String set_Account_Name = "Yamuna" + rand.nextInt();
	
	public static void main(String[] args) throws InterruptedException {
		
		Library lib=new Library();
		//Launch browser
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		lib.clickWaffle();
		lib.search_Sales();
		Create_Account_S1106.createAccout();
		Create_Account_S1106.get_CreateAccountToastMessage();
			
	}
//To create new account
	
		public static void createAccout() throws InterruptedException {
		
		//Click on account tab drop down
		By clickAccountDropDown=By.xpath("//span[text()='Accounts List']/..");	
		Library.waitForElement(Library.driver, clickAccountDropDown, 30).click();
		
		//Click on New Account 
		Thread.sleep(3000);
		WebElement clickNewAccount=Library.driver.findElement(By.xpath("//span[text()='New Account']/../..")); 
		 JavascriptExecutor executor = (JavascriptExecutor)Library.driver;
		executor.executeScript("arguments[0].click();", clickNewAccount);
		
		By accountName=By.xpath("//input[@name='Name']");
		Library.waitForElement(Library.driver, accountName, 20).sendKeys(set_Account_Name);
		
	//scroll the pop up untill locate the Ownership dropdown
		Thread.sleep(3000);
		
		WebElement locateOwnershipText=Library.driver.findElement(By.xpath("//label[text()='Ownership']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)Library.driver;
		executor1.executeScript("arguments[0].scrollIntoView(true);",locateOwnershipText);
		
		
	//Select Ownership as Public 
		By locateDropdown = By.xpath("(//span[text()='--None--'])[3]");
		Library.waitForElement(Library.driver, locateDropdown, 30).click();
		
		By selctDropdown=By.xpath("//span[text()='Public']");
		Library.waitForElement(Library.driver, selctDropdown, 20).click();
		
	//Click on save button
		By clickSave = By.xpath("//button[@name='SaveEdit']");
		Library.waitForElement(Library.driver, clickSave, 20).click();
	
		}
		public static void get_CreateAccountToastMessage() throws InterruptedException {
			
	//get toast message and verify
		By toastMessageText = By.xpath("//span[text()='Account']/parent::div"); // get toast message part 1  //span[text()='Account']
		
		
		String text1 = Library.waitForElement(Library.driver, toastMessageText, 40).getText();
		//System.out.println(text1);
		
		String rgpValue=Library.driver.findElement(By.xpath("//div[contains(@class,'forceToastMessage')]")).getCssValue("background-color");
		System.out.println("RGP Color is " +rgpValue);
		String clr=Color.fromString(rgpValue).asHex();
		System.out.println("Hex code is "+clr);

		WebElement	locate_parentSearch =Library.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral search-button slds-truncate')]")); 
		Thread.sleep(2000);
		locate_parentSearch.click();
		Thread.sleep(2000);
		WebElement	locate_childSearch =Library.driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder='Search...']")); 
		locate_childSearch.sendKeys(set_Account_Name);
		locate_childSearch.sendKeys(Keys.RETURN);
		
		Thread.sleep(3000);
		By get_Account_Name = By.xpath("//table//tr//span/a[contains(text(),'Yamuna')]");
		String name=Library.waitForElement(Library.driver, get_Account_Name, 40).getText();
		
    //Verify whether the new Account has been created or not
		
		if(text1.contains("was created.")) {
			System.out.println(text1);
			if(set_Account_Name.equals(name)) {
				System.out.println("Account name verified successfully");
			}
			else {
				System.out.println("Account name not verified successfully");
			}
					
		}else {
			System.out.println("Account not created");
		}

}
}
	
	

