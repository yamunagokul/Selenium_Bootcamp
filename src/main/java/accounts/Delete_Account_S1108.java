package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import indivituals.Library;

public class Delete_Account_S1108 {

	public static void main(String[] args) throws InterruptedException {
		
		Library lib=new Library();
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		lib.clickWaffle();
		lib.search_Sales();
		Create_Account_S1106.createAccout();
		Edit_Account_S1107.locateSearchBar();
		Delete_Account_S1108.deleteAccount();
		Delete_Account_S1108.get_deleteToastMessage();
	//Search with deleted name to verify that the account has been deleted or not
		Delete_Account_S1108.verify_deleted_account();
	}
	
     public static void deleteAccount() throws InterruptedException {
	
    	//Click on dropdown
 		By clickEditDropDown=By.xpath("((//table)[1]/tbody//td[5]//div[1]/a)[1]");
 		Library.waitForElement(Library.driver, clickEditDropDown, 30).click();
 		
 		//click on Delete
 		By clickDelete=By.xpath("(//a[@title='Delete'])[1]");
 		Library.waitForElement(Library.driver, clickDelete, 30).click();
 		

 		//Click on delete button
 		By clickDeleteButton=By.xpath("//span[text()='Delete']");
 		Library.waitForElement(Library.driver, clickDeleteButton, 30).click();

     }
 		
 		public static void get_deleteToastMessage() throws InterruptedException {
 			//get toast message and verify
 					By toastMessageText = By.xpath("//a/parent::span[text()='\" was deleted. ']"); // get toast message part  //span[text()=' was deleted.']
 					
 					String text1 = Library.waitForElement(Library.driver, toastMessageText, 40).getText();					
 					String rgpValue=Library.driver.findElement(By.xpath("//div[contains(@class,'forceToastMessage')]")).getCssValue("background-color");
 					System.out.println("RGP Color is " +rgpValue);
 					String clr=Color.fromString(rgpValue).asHex();
 					System.out.println("Hex code is "+clr);

 
 					if(text1.contains("was deleted.")) {
 						System.out.println(text1);
 					}else {
 						System.out.println("Account not deleted");
 					}
 				
 				WebElement	locate_parentSearch =Library.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral search-button slds-truncate')]")); 
 				Thread.sleep(2000);
 				locate_parentSearch.click();
 				Thread.sleep(2000);
 				WebElement	locate_childSearch =Library.driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder='Search...']"));
 				locate_childSearch.clear();
 				locate_childSearch.sendKeys(Create_Account_S1106.set_Account_Name);
 				locate_childSearch.sendKeys(Keys.RETURN);
 				
 		}			
 	public static void verify_deleted_account() {
 		
 		By getSearchReselt=By.xpath("//span[contains(text(),'We searched the')]");
 		String saveSearchReselt=Library.waitForElement(Library.driver, getSearchReselt, 30).getText();
 		
 		if(saveSearchReselt.contains("didn't find any matches")) {
 			System.out.println(saveSearchReselt);
 		}
 			else {
 				System.out.println("Account deleted successfully");
 			}
 		}
 		
 					
	}


