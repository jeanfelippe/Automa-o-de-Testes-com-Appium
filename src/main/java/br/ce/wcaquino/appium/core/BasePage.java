package br.ce.wcaquino.appium.core;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;

public class BasePage {
	
	public void escrever(By by,String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
		}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by,String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);		
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size()>0;
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(x,y).perform();
	}
	
	public void swipe(double inicio, double fim) {
		org.openqa.selenium.Dimension size = getDriver().manage().window().getSize();
		
		int y=size.height/2;
		
		int start_x=(int)(size.width*inicio);
		int end_x=(int)(size.width*fim);
		
		new TouchAction(getDriver()).press(start_x,y)
		.waitAction(Duration.ofMillis(500))
		.moveTo(end_x,y)
		.release()
		.perform();
	}


}
