package workType;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import indivituals.Library;

public class Create_WorkType_S11038 {
	
	static Random rand=new Random();
	public static String set_WorkType_Name = "Salesforce" + rand.nextInt();

	public static void main(String[] args) throws InterruptedException {
		
		Library lib=new Library();
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		lib.clickWaffle();
		lib.search_workType();
		Create_WorkType_S11038.create_Worktype();
		Create_WorkType_S11038.get_CreateAccountToastMessage();

	}

	public static void create_Worktype() throws InterruptedException {
		//Click on the new button
		By click_newButton=By.xpath("//div[text()='New']/parent::a");
		Library.waitForElement(Library.driver, click_newButton, 20).click();
		
		//Enter the name as salesforce project	
		By enter_WorkTypeName=By.xpath("//input[@name='Name']");
		Library.waitForElement(Library.driver, enter_WorkTypeName, 20).sendKeys(set_WorkType_Name);
		
		//Enter the name as Description as Specimen	
		By enter_Description=By.xpath("//textarea[@class='slds-textarea']");
		Library.waitForElement(Library.driver, enter_Description, 20).sendKeys("Specimen");
		
		//scroll the pop up untill Duration Type field
		WebElement scroll_Duration_Type=Library.driver.findElement(By.xpath("//label[text()='Operating Hours']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)Library.driver;
		executor1.executeScript("arguments[0].scrollIntoView(true);",scroll_Duration_Type);
		
		
		//Locate Operating Hours and click
		By click_OperatingHours=By.xpath("//input[contains(@placeholder,'Search Operating Hours...')]");
		Library.waitForElement(Library.driver, click_OperatingHours, 20).click();
		
		Thread.sleep(3000);
		//Scroll untill to find new operating hours
		WebElement scroll_to_New_Operating_Hours=Library.driver.findElement(By.xpath("//span[text()='New Operating Hours']"));
		executor1.executeScript("arguments[0].scrollIntoView(true);",scroll_to_New_Operating_Hours);	
		scroll_to_New_Operating_Hours.click();
		

		//create new operating hour
		By enter_Name=By.xpath("//span[text()='Name']/parent::label/following-sibling::input");
		Library.waitForElement(Library.driver, enter_Name, 20).sendKeys("UK Shift");
		
		//click on  save
		By click_Save=By.xpath("//span[text()='Save']//parent::button[@title='Save']");
		Library.waitForElement(Library.driver, click_Save, 20).click();
		
		//Enter Estimated Duration
		By enter_Estimated_Duration=By.xpath("//label[text()='Estimated Duration']/following-sibling::div//input");
		Library.waitForElement(Library.driver, enter_Estimated_Duration, 20).sendKeys("7");
		
		
		//Click on save button
		By click_saveButton=By.xpath("//button[@name='SaveEdit']");
		Library.waitForElement(Library.driver, click_saveButton, 20).click();
	}
	
	  //Verify the toast message
		public static void get_CreateAccountToastMessage() throws InterruptedException {
			
			//get toast message and verify
				By toastMessageText = By.xpath("//span[text()='Work Type']/parent::div");
				String text1 = Library.waitForElement(Library.driver, toastMessageText, 20).getText();
				//System.out.println(text1);
				
				
			//Verify the created new work type
				By get_work_type = By.xpath("(//span[text()='Work Type Name'])[2]/../../..//dd//span//lightning-formatted-text");
				String text2 = Library.waitForElement(Library.driver, get_work_type, 20).getText();
				System.out.println(text2);
		
				if(text1.contains("was created.")) {
					System.out.println(text1);
					if(set_WorkType_Name.equals(text2)) {
						System.out.println("Newly created work type has been verified successfully");
					}
					else {
						System.out.println("AWork type not verified successfully");
					}
							
				}else {
					System.out.println("Work type not created");
				}

				
				
				
				
				
				
		}
		
	}

