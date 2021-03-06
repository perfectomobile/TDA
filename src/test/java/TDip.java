package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;


import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;


public class TDip {
	public  static void main(String[] args) {
		//exce("CEC63D6236866DD8AA617904D40E0F3A8154376E");
	}
	public static void exce(String deviceID ,MobileDriver driver) {

		IMobileDevice device = ((IMobileDriver) driver).getDevice(deviceID);

		device.open();
		device.home();
		IMobileWebDriver visual = device.getVisualDriver();
		IMobileWebDriver WebDriver = device.getNativeDriver();
 
		try {
			// write your code here

			try {
				 device.getNativeDriver("Ameritrade").open();
				 sleep(5000);
				 while(true) {
					System.out.println("Inside while block");
					WebDriver.findElement(By.xpath("//*[starts-with(@label,\"OK\")and @isvisible=\"true\"]")).click();
					//WebDriver.findElement(By.xpath("//device/view/window[3]/alert[1]/table[1]/cell[1]")).click();
					sleep(3000);
					
				}
				
			} catch (Exception e) {
				// Do nothing
			}
			
			
			// go to Research Tab

			WebDriver.findElement(By.linkText("Research")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("Calendar"));

			// go to Research/News Tab

			WebDriver.findElement(By.linkText("News")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("Market Pulse"));


			// go to Research/Calendar Tab

			WebDriver.findElement(By.linkText("Calendar")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("earnings"));


			// go to Accounts Tab

			WebDriver.findElement(By.linkText("Accounts")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("Create account"));

			//device.getMobileKeyboard().pressKey("BACK");
			// go to Trade Tab

			WebDriver.findElement(By.linkText("Trade")).click();
			sleep(3000);
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("Create account"));
			// go to More Tab

			WebDriver.findElement(By.linkText("More")).click();
			sleep(3000);
			WebDriver.findElement(By.linkText("Contact Us")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("For help opening a new account"));


			device.getNativeDriver("Ameritrade").close();





		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		//	driver.quit();
		}
		System.out.println("Run ended");

	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}

