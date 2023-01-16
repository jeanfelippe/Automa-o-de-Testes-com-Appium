package br.ce.wcaquino.appium.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;



public class FormularioTeste extends BaseTest {
	
	//private DSL dsl = new DSL();
	
	
	//private static AndroidDriver<MobileElement> driver;
	
	private MenuPage menu= new MenuPage();
	private FormularioPage page= new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
		
		//dsl.clicarPorTexto("Formulario");
		//driver=DriverFactory.getDriver();

		//driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}
	
	/*
	@After
	public void tearDown() {
		//driver.quit();
		DriverFactory.killDriver();
	}
	*/
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		page.escreverNome("Wagner");
		//assertEquals("Wagner", page.obterNome());
		
		//dsl.escrever(MobileBy.AccessibilityId("nome"), "Wagner");
		
		//Assert.assertEquals("Wagner", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
		Assert.assertEquals("Wagner", page.obterNome());
		
		//driver = inicializarAppium();
		 
		//Teste em que a automação localiza o campo nome e escreve o nome Jean e depois realiza um
		 // assert para validar se o nome contido na variavel bate com o nome Jean
		
		//List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		
		//elementosEncontrados.get(1).click();
		
		
		//MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		//campoNome.sendKeys("Jean");
		
		//String text= campoNome.getText();
		//Assert.assertEquals("Jean", text);
		
		//driver.quit();
		
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		//driver.findElement(MobileBy.AccessibilityId("console")).click();

		//driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		page.selecionarCombo("Nintendo Switch");
		//String text= dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		//String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		//Assert.assertEquals("Nintendo Switch", text);
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	
	
	

	
	
	
	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {

		
		//MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));		
		//MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));		
		//Assert.assertTrue(check.getAttribute("checked").equals("false"));
		//Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		//Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		//Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());
		
		//clicar nos elementos
		page.clicarCheck();
		page.clicarSwitch();
		
		//clicar nos elementos
		//dsl.clicar(By.className("android.widget.CheckBox")));
		//dsl.clicar(MobileBy.AccessibilityId("switch"));
		
		//verificar estamos alterados
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
		//Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		//Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
		
		//check.click();
		//switc.click();
		
		//Assert.assertFalse(check.getAttribute("checked").equals("false"));
		//Assert.assertFalse(switc.getAttribute("checked").equals("true"));
		
		//driver.quit();
	
		
		
	}
	
	
	@Test
	public void DesafioRealizarCadastro() throws MalformedURLException {
		//preencher campos
		page.escreverNome("Wagner");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		
		page.salvar();
		
		//verificacoes
		//Assert.assertEquals("Nome: Wagner", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Jean']"));
		//Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
		Assert.assertEquals("Nome: Wagner", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.ObterCheckCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("arcado"));
		

		
	/*
		
		//encontrar o campo para digitar o nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Jean");
		
		//interagir com o checkbox e com o switch
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));		
		check.click();
		//switc.click();
		
		
		//escolher qual console
		driver.findElement(MobileBy.AccessibilityId("console")).click();	
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//apertar botao salvar
		driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		
		//asert
		
		MobileElement nome=driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Jean']"));
		Assert.assertEquals("Nome: Jean", nome.getText());
		
		*/
		
	}
	
	

	@Test
	public void DesafioRealizarCadastroDemorado() throws MalformedURLException {
		
		
		
		//preencher campos
		page.escreverNome("Wagner");
		
		//DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		page.salvarDemorado();
		//esperar(3000);
		//WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Wagner']")));

		Assert.assertEquals("Nome: Wagner", page.obterNomeCadastrado());

		

		
	}

		
		
		
		
		/*
	
			//teste utilizando a aplicação Calculadora somando 2 + 2
			
			MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
			el1.click();
			MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
			el2.click();
			MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
			el3.click();
			MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
			System.out.println(el4.getText());
			Assert.assertEquals("4", el4.getText());
		
		 */
	}


