package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import indivituals.Library;

public class Edit_Account_S1107 {

	public static void main(String[] args) throws InterruptedException {
		
		Library lib=new Library();
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		lib.clickWaffle();
		lib.search_Sales();
		Create_Account_S1106.createAccout();
		Edit_Account_S1107.locateSearchBar();
		Edit_Account_S1107.editAccount();
		Edit_Account_S1107.get_EditToastMessage();
		}

	
	public static void locateSearchBar() throws InterruptedException {
		//Search with created account name
		WebElement	locate_parentSearch =Library.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral search-button slds-truncate')]")); 
		Thread.sleep(2000);
		locate_parentSearch.click();
		Thread.sleep(2000);
		WebElement	locate_childSearch =Library.driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder='Search...']")); 
		locate_childSearch.sendKeys(Create_Account_S1106.set_Account_Name);
		locate_childSearch.sendKeys(Keys.RETURN);
		
		}
	
	public static void editAccount() throws InterruptedException {
	
	//Click on dropdown
		By clickEditDropDown=By.xpath("((//table)[1]/tbody//td[5]//div[1]/a)[1]");
		Library.waitForElement(Library.driver, clickEditDropDown, 30).click();
		
	//click on Edit
		By clickEdit=By.xpath("//div[text()='Edit']/..");
		Library.waitForElement(Library.driver, clickEdit, 30).click();
		
	//Enter Unique Number in Phone Field
		By enter_name=By.xpath("//label[text()='Phone']/following-sibling::div/input"); //
		Library.waitForElement(Library.driver, enter_name, 30).sendKeys("9876542133");
		
	//Select type as technology parter
		By locateType = By.xpath("//label[text()='Type']/following-sibling::div//div//div//button//span[text()='--None--']");
		Library.waitForElement(Library.driver, locateType, 30).click();
		
		By selctTechlonogyPartner=By.xpath("//span[text()='Technology Partner']");
		String get_TechlonogyPartner=selctTechlonogyPartner.toString(); 
		System.out.println(get_TechlonogyPartner);
		Library.waitForElement(Library.driver, selctTechlonogyPartner, 20).click();
		
		Thread.sleep(3000);
		
	//Scroll un till locate the Industry field
		WebElement locateIndustryText=Library.driver.findElement(By.xpath("//label[text()='Industry']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)Library.driver;
		executor1.executeScript("arguments[0].scrollIntoView(true);",locateIndustryText);
		
		By locateIndustryDropDown = By.xpath("//label[text()='Industry']");
		Library.waitForElement(Library.driver, locateIndustryDropDown, 30).click();
		
	//Scroll un till locate the healthcare 
		WebElement scrollTo_Locate_Healthcare=Library.driver.findElement(By.xpath("//span[text()='Healthcare']"));
		executor1.executeScript("arguments[0].scrollIntoView(true);",scrollTo_Locate_Healthcare);
		Library.driver.findElement(By.xpath("//span[text()='Healthcare']")).click();
		
	//Enter Billing Address
		Library.driver.findElement(By.xpath("(//textarea[@class='slds-textarea' and @name='street'])[1]")).sendKeys("345/3, new streat, Erode");
		
	//Enter Shipping Address
		Library.driver.findElement(By.xpath("(//textarea[@class='slds-textarea' and @name='street'])[2]")).sendKeys("345/3, new streat, Erode");
		
	//Scroll still Customer Priority
		WebElement scrollTo_Locate_Customer_priority=Library.driver.findElement(By.xpath("//label[text()='Customer Priority']"));
		executor1.executeScript("arguments[0].scrollIntoView(true);",scrollTo_Locate_Customer_priority);
		Library.driver.findElement(By.xpath("//label[text()='Customer Priority']/following-sibling::div//div//div//button/span[text()='--None--']")).click();
		Library.driver.findElement(By.xpath("//span[text()='Low']")).click();
		
	//Select SLA as Silver	
		Library.driver.findElement(By.xpath("//label[text()='SLA']/following-sibling::div//div//button/span[text()='--None--']")).click();
		Library.driver.findElement(By.xpath("//span[text()='Silver']")).click();
		
	//Select Active as No
		Library.driver.findElement(By.xpath("//label[text()='Active']/following-sibling::div//div//button/span[text()='--None--']")).click();
		Library.driver.findElement(By.xpath("//span[text()='No']")).click();
		
	//Select Upsell Opportunity as No
		Library.driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div//div//button/span[text()='--None--']")).click();
		Library.driver.findElement(By.xpath("(//span[text()='No'])[1]")).click();
	
	//Click on Save button
		WebElement click_save=Library.driver.findElement(By.xpath("(//button[text()='Save'])[2]"));	
		executor1.executeScript("arguments[0].click(true);",click_save);
		
	//executor1.executeScript("arguments[0].click();", Library.driver.findElement( By.xpath("(//button[text()='Save'])[2]") ));
	}
		public static void get_EditToastMessage() {
	
	//get toast message and verify
		By toastMessageText = By.xpath("//span[text()='\" was saved.']"); // get toast message part 
				
		String text1 = Library.waitForElement(Library.driver, toastMessageText, 40).getText();
		System.out.println(text1);
				
		String rgpValue=Library.driver.findElement(By.xpath("//div[contains(@class,'forceToastMessage')]")).getCssValue("background-color");
		System.out.println("RGP Color is " +rgpValue);
		String clr=Color.fromString(rgpValue).asHex();
		System.out.println("Hex code is "+clr);

			if(text1.contains("was saved.")) {
					System.out.println(text1);
				}else {
					System.out.println("Account not edited");
			}

		
		
	}


}

