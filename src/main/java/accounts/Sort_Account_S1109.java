package accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import indivituals.Library;

public class Sort_Account_S1109 {

	public static void main(String[] args) throws InterruptedException {
		
		Library lib=new Library();
		lib.launchBroser();
		lib.launchURL("https://login.salesforce.com");
		lib.login("bootcamp_2024@testleaf.com", "Bootcamp@123");
		lib.clickWaffle();
		lib.search_Sales();
		Sort_Account_S1109.Sorting();
	}

	public static void Sorting() throws InterruptedException {
		
	//click on Account name tab	
			Thread.sleep(5000);
			WebElement clikAccounts_Tab=Library.driver.findElement(By.xpath("(//span[text()='Accounts'])/parent::a"));
			
			JavascriptExecutor executor = (JavascriptExecutor)Library.driver;
			executor.executeScript("arguments[0].click();", clikAccounts_Tab);
				
	//Scroll the web table
			Thread.sleep(2000);
			List<WebElement> before_short=Library.driver.findElements(By.xpath("//table/tbody/tr/th/span/a"));
			
			
			 	  
			Actions actions = new Actions(Library.driver); 
			 WebElement live=Library.driver.findElement(By.xpath("(//table/tbody/tr/th/span/a)[15]"));
			 actions.moveToElement(live).build().perform();
		
	//Store the account name before sorting
			List<String> before_short_List=new ArrayList<String>();
			Thread.sleep(2000);
			
			
			List<WebElement> before_short1=Library.driver.findElements(By.xpath("//table/tbody/tr/th/span/a"));
			
			for(WebElement ele:before_short) {
				before_short_List.add(ele.getText());
			
			}
			System.out.println("Before Short "+before_short_List);
			System.out.println(before_short_List.size());
			
	//Click on Account name in column header
			By click_AccountName=By.xpath("//span[text()='Account Name']/parent::a");
	 		Library.waitForElement(Library.driver, click_AccountName, 30).click();
	 		Thread.sleep(3000);
	 		
			WebElement after_Scroll= Library.driver.findElement(By.xpath("(//table/tbody/tr/th/span/a)[15]"));
			actions.moveToElement(after_Scroll).build().perform();
			
	 		List<String> after_short_List=new ArrayList<String>();
	 		
			List<WebElement> after_short=Library.driver.findElements(By.xpath("//table/tbody/tr/th/span/a"));
	 		
			for(WebElement ele2:after_short) {
				
				after_short_List.add(ele2.getText());
			}
			System.out.println("After Short: "+after_short_List);
			System.out.println(after_short_List.size());
	 		
			
	//Compare before and after sort	 
			int n = before_short_List.size();
			 
		        for (int i = 0; i < n - 1; i++) {
		            for (int j = 0; j < n - 1; j++) {
		                if (before_short_List.get(j).compareToIgnoreCase(before_short_List.get(j + 1)) > 0) {
		                    // Swap names[j] and names[j + 1]
		                    String temp = before_short_List.get(j);
		                    before_short_List.set(j, before_short_List.get(j + 1));
		                    before_short_List.set(j + 1, temp);
		                }
		            }
		        }
		      System.out.println("After Compar: "+before_short_List);	        
		      
		      /* for (String a : after_short_List)
		        {
		            for (String b : before_short_List)
		            {
		                if (a.equals(b))
		                {
		                    System.out.println(before_short_List);
		                 break;
		                }
		            }
		        } */
		        
		}
 		

	}
		
		
		
 
 		
 		
 		

