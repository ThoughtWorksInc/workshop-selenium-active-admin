package demo.activeadmin.info.testes;


import demo.activeadmin.info.support.util.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class TestWait extends Driver {

    private static final By BTN = By.id("btn");
    private static final By MENSAGEM = By.id("mensagem");

    private String getHtmlWait() {
        return "file:///" + System.getProperty("user.dir") + "/testes-aceitacao/src/main/ui/demo/activeadmin/info/support/html/exemploWait.html";
    }

    @Test
    public void explicitWaitFail() {
        driver.get(getHtmlWait());
        driver.findElement(BTN).click();
        WebElement mensagem = driver.findElement(MENSAGEM);


        assertEquals("Checar essa mensagem", mensagem.getText());

    }

    @Test
    public void explicitWait() {
        driver.get(getHtmlWait());
        driver.findElement(BTN).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(MENSAGEM));
        assertEquals("Checar essa mensagem",msg.getText());
    }

    @Test
    public void explicitWait2() {
        driver.get(getHtmlWait());
        driver.findElement(BTN).click();
        WebElement mensagem = ( new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOfElementLocated(MENSAGEM));


        assertEquals("Checar essa mensagem", mensagem.getText());

    }

}
