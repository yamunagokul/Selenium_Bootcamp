package workType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import indivituals.Library;

public class Edit_WorkType_Negative_S11039 {

	public static void main(String[] args) throws InterruptedException {
		Library lib=new Library();
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		lib.clickWaffle();
		lib.search_workType();
		Create_WorkType_S11038.create_Worktype();
		Edit_WorkType_Negative_S11039.EditWorkTypeNegative();
	}
	
	public static void EditWorkTypeNegative() throws InterruptedException {
	//Click on recently viewed work type tab
	//By click_recently_viewed_worktype_tab=By.xpath("//span[contains(text(),'| Work Type')]/parent::a[contains(@title,'| Work Type')]");	
	//Library.waitForElement(Library.driver, click_recently_viewed_worktype_tab, 30).click();
	Thread.sleep(3000);
	WebElement click_recently_viewed_worktype_tab=Library.driver.findElement(By.xpath("//span[contains(text(),'| Work Type')]/parent::a[contains(@title,'| Work Type')]")); 
	 
	
		JavascriptExecutor executor = (JavascriptExecutor)Library.driver;
		executor.executeScript("arguments[0].click();", click_recently_viewed_worktype_tab);
	Thread.sleep(2000);
			
	
	Library.driver.navigate().refresh();
	By clickEditDropDown=By.xpath("((//table)[1]/tbody//td[5]//div[1]/a)[1]");
	
	Library.waitForElement(Library.driver, clickEditDropDown, 30).click();
	
	
	//click on Edit			
	By clickEdit=By.xpath("//div[text()='Edit']/..");
	Library.waitForElement(Library.driver, clickEdit, 30).click();
	
	Thread.sleep(2000);
	//Scroll un till locate Timeframe End field
			WebElement locateTimeframe_end=Library.driver.findElement(By.xpath("//label[text()='Timeframe End']"));
			JavascriptExecutor executor1 = (JavascriptExecutor)Library.driver;
			executor1.executeScript("arguments[0].scrollIntoView(true);",locateTimeframe_end);
			
			
	//Enter values in Timeframe Start input field
			By enter_TimeframeStart=By.xpath("//input[@name='TimeframeStart']");
			Library.waitForElement(Library.driver, enter_TimeframeStart, 20).sendKeys("9");
			
			//Enter values in Timeframe end input field
			By enter_Timeframeend=By.xpath("//input[@name='TimeframeEnd']");
			Library.waitForElement(Library.driver, enter_Timeframeend, 20).sendKeys("7");		
			
			
			//Click on save button
			By click_saveButton=By.xpath("//button[@name='SaveEdit']");
			Library.waitForElement(Library.driver, click_saveButton, 20).click();	
		
			//Validate the erro messages
			
		String Timeframe_start_expected_message="Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe Start";
		String Timeframe_end_expected_message="Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe End";
			Thread.sleep(2000);
		String get_Timeframe_start_actual_message_=Library.driver.findElement(By.xpath("//div[contains(text(),'Start number.: Timeframe Start')]")).getText();
		
		String get_Timeframe_end_actual_message_=Library.driver.findElement(By.xpath("//div[contains(text(),'Start number.: Timeframe End')]")).getText();	
		
		if(Timeframe_start_expected_message.equals(get_Timeframe_start_actual_message_)) {
			System.out.println(get_Timeframe_start_actual_message_);
			if(Timeframe_end_expected_message.equals(get_Timeframe_end_actual_message_)) {
				System.out.println(get_Timeframe_end_actual_message_);							
			}else {
				System.out.println("Timeframe End input field validation message not verified");
				
			}
		}
		else {
			System.out.println("Timeframe Start input field validation message not verified");
		}	
	}
}