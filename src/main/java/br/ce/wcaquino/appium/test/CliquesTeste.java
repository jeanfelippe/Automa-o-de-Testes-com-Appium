package br.ce.wcaquino.appium.test;

import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;
import junit.framework.Assert;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page= new CliquesPage();
	
	public void setup() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {
		
		//acessar menu
		menu.acessarCliques();
		
		page.cliqueLongo();
		
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	public void deveRealizarCliqueDuplo() {
		
	
	page.clicarPorTexto("Clique Duplo");
	page.clicarPorTexto("Clique Duplo");
	
	}
}
