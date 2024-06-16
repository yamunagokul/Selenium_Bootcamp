package indivituals;

import org.openqa.selenium.By;

//

public class S11020 extends Library{
	
	public static void main(String[] args) {
		Library lib=new Library();
		
//1. Login to the application		
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		S11020.createIndividual();
	}
		public static void createIndividual() {
//2. Click on the toggle menu button from the left corner
		By WaffleIcon = By.className("slds-icon-waffle");
		waitForElement(driver, WaffleIcon, 40).click();

//3. Click View All and click Individuals from App Launcher

		By viewAllLink1 = By.xpath("(//button[@class='slds-button'])[2]");
		waitForElement(driver, viewAllLink1, 30).click();

		By searchTextBox = By.xpath("//input[@class='slds-input']");
		waitForElement(driver, searchTextBox, 20).sendKeys("individuals");

		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

//4. Click on the Dropdown icon in the Individuals tab
		By clickNewButton = By.xpath("//a[@class='forceActionLink']/div");
		waitForElement(driver, clickNewButton, 20).click();

//6. Enter the Last Name as 'kumar'

		By drodown = By.xpath("(//div/a[text()='--None--'])[1]");
		waitForElement(driver, drodown, 20).click();
		driver.findElement(By.xpath("//li/a[text()='Mrs.']")).click();

//enter the first name
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Yamuna");

//Enter Last name
		driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).sendKeys("Palaniyappan");

//Select Date of Birth

		driver.findElement(By.xpath("//div/a[contains(@class,'datePicker')]")).click();// Click date picker

		driver.findElement(By.xpath("//label/select[contains(@class,'slds-select')]")).click();// Click year
		driver.findElement(By.xpath("//label/select[contains(@class,'slds-select')]/option[text()='1994']")).click(); // select and click 1994																												

		String month = "JANUARY";
//String getMonth=driver.findElement(By.xpath("//h2[@class='monthYear']")).getText();

		while (true) {

			String getMonth = driver.findElement(By.xpath("//h2[@class='monthYear']")).getText();
			if (month.equals(getMonth)) {
				{
					break;
				}
			} else {
				driver.findElement(By.xpath("//div/a[contains(@class,'prevMonth')]")).click();
			}
		}

		driver.findElement(By.xpath("//table/tbody/tr[5]/td[3]/span[text()='25']")).click(); // Click on 25th date
		
//Click on Don't process check box
		driver.findElement(By.xpath("//span[contains(text(),'Process')]/../..//input")).click();

// Click on save button		
		driver.findElement(By.xpath("//button[@title='Save']/span[text()='Save']")).click();

		By toastMessageText = By.xpath("//div[contains(@id,'toastDescription')]/span[contains(text(),'Individual')]"); // get toast message
																														
		String text = waitForElement2(driver, toastMessageText, 40).getText();

		System.out.println(text);
		driver.findElement(By.xpath("//span[text()='Close']/preceding-sibling::lightning-primitive-icon")).click();
	}
	}

	//// div[contains(@id,'toastDescription')]/span[contains(text(),'Individual')]

	/*
	 * if(month==getMonth){
	 * 
	 * driver.findElement(By.xpath("//table/tbody/tr[4]/td[5]/span")).click(); }
	 * else {
	 * 
	 * driver.findElement(By.xpath("//div/a[contains(@class,'prevMonth')]")).click()
	 * ; }
	 * 
	 * }
	 */


