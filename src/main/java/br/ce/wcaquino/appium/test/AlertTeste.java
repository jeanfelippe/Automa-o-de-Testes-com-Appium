package br.ce.wcaquino.appium.test;

import org.junit.Test;

import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;
import junit.framework.Assert;

public class AlertTeste {
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	
	@Test
	public void deveConfirmarAlerta() {
		//acessar menu alerta
		menu.acessarAlertas();
	
	//clicar em alerta confirm
		page.clicarAlertaConfirm();
		
	//verificar os textos	
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
	}
	

}
