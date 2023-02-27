package br.ce.wcaquino.appium.test;

import org.junit.Assert;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SwipeTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	public void deveRealizarSwipe() {
		//acessar menu
		menu.acessarSwipe();
		
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//swipe para a direita
		menu.swipe(0.9, 0.1);
		
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//clicar botao direito
		menu.clicarPorTexto(">");
		
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		
		//swipe esquerdo
		menu.swipe(0.1, 0.9);
		
		//clicar botao esquerda
		menu.clicarPorTexto("<");
		
		
		//verificar texto a esquerda
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}

}
