package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;


import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;


public class TDAnd {
	public  static void main(String[] args) {
		exce("7DE396A2");
	}
	public static void exce(String deviceID ) {

		System.out.println("Run started");
		String host = Constants.PM_CLOUD;
		String user = Constants.PM_USER;
		String password = Constants.PM_PASSWORD;
		MobileDriver driver = new MobileDriver(host, user, password);


		IMobileDevice device = ((IMobileDriver) driver).getDevice(deviceID);

		device.open();
		device.home();
		IMobileWebDriver visual = device.getVisualDriver();
		IMobileWebDriver WebDriver = device.getNativeDriver();

		try {
			// write your code here

			device.getNativeDriver("Ameritrade").open();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("you are not logged in"));



			// go to Research Tab

			WebDriver.findElement(By.linkText("Research")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("UPDATE"));

			// go to Research/News Tab

			device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("577,1654")), new MobileCoordinates(new MobilePoint("591,330")), 2);

			device.getMobileTouchScreen().swipe(new MobileCoordinates(new MobilePoint("687,1656")), new MobileCoordinates(new MobilePoint("671,684")), 1);

			sleep(3000);

			WebDriver.findElement(By.linkText("News")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("Market Pulse"));
			device.getMobileKeyboard().pressKey("BACK");

			// go to Research/Calendar Tab

			WebDriver.findElement(By.linkText("Calendar")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("earnings"));
			device.getMobileKeyboard().pressKey("BACK");

			// go to Accounts Tab

			WebDriver.findElement(By.linkText("Accounts")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("you must be logged for"));

			// go to More Tab


			WebDriver.findElement(By.xpath("//device/view/group[1]/group[1]/group[1]/group[3]/group[2]/text[1]")).click();
			sleep(3000);
			WebDriver.findElement(By.linkText("Contact Us")).click();
			visual.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			visual.findElement(By.linkText("For help opening a new account"));


			device.getNativeDriver("Ameritrade").close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
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

