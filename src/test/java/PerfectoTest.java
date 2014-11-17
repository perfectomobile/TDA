package test.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.options.visual.text.MobileTextMatchMode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

import com.perfectomobile.selenium.*;
import com.perfectomobile.selenium.api.*;
import com.perfectomobile.selenium.by.ByMobile;


public class PerfectoTest {


	public void runTest()
	{
		
		String host = Constants.PM_CLOUD;
		String user = Constants.PM_USER;
		String password = Constants.PM_PASSWORD;
		
		MobileDriver PMdriver = new MobileDriver(host, user, password);		
		
		IMobileDevice device1 = PMdriver.getDevice("0149BCA71700D01F");
		IMobileDevice device = PMdriver.getDevice("39F3DA5531ADBE2A05CFF4D65E43A2C38D3D595A");

		IMobileWebDriver oracleAppi = device1.getNativeDriver("Oracle BI Mobile");
		IMobileWebDriver oracleAppA = device.getNativeDriver("Oracle BI HD");
		IMobileWebDriver oracleAppAv = device1.getVisualDriver();
		IMobileWebDriver oracleAppiv = device.getVisualDriver();

		device1.open();
		device.open();
		// closeApp
		try{
			oracleAppi.close();

		}catch (Exception e)
		{
			//	application already closed 
		}
		try{
			oracleAppA.close();

		}catch (Exception e)
		{
			//	application already closed 
		}

		oracleAppA.open();
		oracleAppi.open();

		oracleAppA.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		oracleAppA.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		oracleAppi.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		oracleAppi.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		oracleAppAv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		oracleAppAv.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		oracleAppiv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		oracleAppiv.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// search 

		oracleAppAv.findElement(ByMobile.image("PRIVATE:script\\Samsung_Galaxy Nexus_141117_153148.png")).click();

		device1.getMobileKeyboard().sendKeys("my dashboard");

		oracleAppAv.manageMobile().visualOptions().textMatchOptions().setIndex(2);
		oracleAppAv.findElement(By.linkText("My Dashboard")).click();


		oracleAppiv.findElement(ByMobile.image("PRIVATE:oracle_menu.png")).click();

		oracleAppiv.findElement(By.linkText("Search")).click();
		oracleAppiv.findElement(By.linkText("My Folders")).click();
		oracleAppiv.findElement(By.linkText("My Dashboard")).click();



		try{
			Thread.sleep(10000);
			oracleAppA.quit();
			oracleAppi.quit();
			oracleAppAv.quit();
			oracleAppiv.quit();

		}catch (Exception e)
		{
			//	e.printStackTrace();
		}


	

	}
}
