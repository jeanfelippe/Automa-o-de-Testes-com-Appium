package br.ce.wcaquino.appium.core;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	//private static AndroidDriver<MobileElement> driver;
	
	
		@Rule
		public TestName testName = new TestName();
		//para cada print ele irá gerar uma imagem com titulo diferente
		
		@AfterClass
		public static void finalizaClasse() {
			DriverFactory.killDriver();
		}
		
		
		@After
		public void tearDown() {
			gerarScreenShot();
		DriverFactory.getDriver().resetApp();
		//DriverFactory.killDriver();
	}
		
		
		//Printar o resultado final de cada teste
		public void gerarScreenShot() {
			try {
				File imagem=	((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
			}catch(IOException e) {
				e.printStackTrace();
		}

}


		
}
