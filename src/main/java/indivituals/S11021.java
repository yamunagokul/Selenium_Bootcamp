package indivituals;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class S11021 extends Library{

	public static void main(String[] args) throws InterruptedException {
		
			Library lib=new Library();
			
	//1. Login to the application		
			lib.launchBroser();
			lib.launchURL("https://login.salesforce.com");
			lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
	//2.Create Individuals
			S11020.createIndividual();
				
	//3. Edit Individuals
	//Search with name
			WebElement	searchLastName1 =driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate']")); 
			Thread.sleep(3000);
			searchLastName1.click();
			Thread.sleep(3000);
			WebElement	searchLastName =driver.findElement(By.xpath("//input[@class='slds-input' and @placeholder='Search...']")); 
			searchLastName.sendKeys("Palaniyappan");
			searchLastName.sendKeys(Keys.RETURN);
			
//Click dropdown icon to select Edit button			
		By clickDropdown=By.xpath("((//table)[3]//tbody/tr[1]/td[6]//div//li//div//div//div//a//span)[1]");
		waitForElement(driver,clickDropdown, 20 ).click();
		
//Click on Edit 					
		driver.findElement(By.xpath("//div[text()='Edit']/..")).click();
		

	}

}
