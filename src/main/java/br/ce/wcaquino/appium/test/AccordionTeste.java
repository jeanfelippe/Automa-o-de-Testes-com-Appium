package br.ce.wcaquino.appium.test;

import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;
import junit.framework.Assert;

public class AccordionTeste extends BaseTest{
	private MenuPage menu = new MenuPage();
	private AccordionPage page= new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		
		//acessar menu
		menu.acessarAccordion();
		
		page.selecionarOp1();
		
		//esperar(1000);
		//Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
	}
	

	
}
