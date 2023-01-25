package br.ce.wcaquino.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;
import junit.framework.Assert;

public class AlertTeste {
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	
	@Test
	public void deveConfirmarAlerta() {
	
	//clicar em alerta confirm
		page.clicarAlertaConfirm();
		
	//verificar os textos	
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		//page.confirmar();
		//Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		//page.sair();
	}
	
	public void deveClicarForaAlerta() {

		page.clicarAlertaSimples();
		
		//esperar(1000);
		page.clicarForaCaixa();
		
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa"));
		
		
	}
	

}
