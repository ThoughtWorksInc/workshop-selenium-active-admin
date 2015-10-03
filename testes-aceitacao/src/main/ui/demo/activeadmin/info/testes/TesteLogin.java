package demo.activeadmin.info.testes;

import demo.activeadmin.info.support.util.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TesteLogin extends Driver {

    private final static By LINK_LOGIN = By.linkText("Log in");
    private final static By LOGIN_USUARIO = By.id("login");
    private final static By PASSWORD_USUARIO = By.name("password");
    private final static By BOTAO_COMMIT = By.name("commit");
    private final static By MENSAGEM_SUCESSO = By.xpath("//div[@id='flash_notice'][2]");
    private final static By MENSAGEM_ERRO = By.id("flash_error");


    @Test
    public void loginUsuarioValido() {
        String mensagemEsperada = "Logged in successfully.";

        driver.get("http://localhost:3000");
        driver.findElement(LINK_LOGIN).click();

        WebElement loginUsuario = driver.findElement(LOGIN_USUARIO);
        loginUsuario.clear();
        loginUsuario.sendKeys("rafalima07@gmail.com");

        WebElement senhaUsuario = driver.findElement(PASSWORD_USUARIO);
        senhaUsuario.clear();
        senhaUsuario.sendKeys("password");

        driver.findElement(BOTAO_COMMIT).click();

        String mensagemAtual = driver.findElement(MENSAGEM_SUCESSO).getText();

        assertEquals(mensagemEsperada,mensagemAtual);
    }

    @Test
    public void loginUsuarioInValido() {
        driver.get("http://localhost:3000");
        driver.findElement(LINK_LOGIN).click();

        driver.findElement(LOGIN_USUARIO).clear();
        driver.findElement(LOGIN_USUARIO).sendKeys("rafalimgmail.com");

        driver.findElement(PASSWORD_USUARIO).clear();
        driver.findElement(PASSWORD_USUARIO).sendKeys("password");

        driver.findElement(BOTAO_COMMIT).click();

        String mensagemError = driver.findElement(MENSAGEM_ERRO).getText();

        assertEquals("Invalid login or password.",mensagemError);
    }
}