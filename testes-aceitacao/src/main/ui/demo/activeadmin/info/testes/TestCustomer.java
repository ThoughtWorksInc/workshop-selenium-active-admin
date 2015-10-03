package demo.activeadmin.info.testes;

import demo.activeadmin.info.support.util.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCustomer extends Driver {

    private static final By USERNAME_SELECT = By.cssSelector("label[for=q_username] + select");
    private static final By USERNAME_INPUT = By.id("q_username");
    private static final By FILTER_BTN = By.name("commit");
    private static final By USERS_LIST = By.cssSelector("tr[id^=user_]");
    private static final By USER_NAME = By.className("col-username");


    @Test
    public void filterCustomer() {
        String expectedUser = "rafalima";
        driver.get("http://localhost:3000/admin/customers");
        Select usernameSelect = new Select(driver.findElement(USERNAME_SELECT));
        usernameSelect.selectByValue("username_equals");

        driver.findElement(USERNAME_INPUT).sendKeys(expectedUser);

        driver.findElement(FILTER_BTN).click();

        List<WebElement> usersList = driver.findElements(USERS_LIST);

        assertEquals(usersList.size(),1);


        String actualUser = usersList.get(0).findElement(USER_NAME).getText();

        assertEquals(expectedUser,actualUser);
    }


}
