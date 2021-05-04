package demoblaze.test.navigationbar;

import demoblaze.test.setup.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

import static org.testng.Assert.assertEquals;

public class NavigationBarStepDefinitions extends Base {

    WebDriverWait wait = new WebDriverWait(driver,40);

    @Given("the user press the {string} button")
    public void buttonPressed(String btnXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnXpath)));
        Setup.driver.findElement(By.xpath(btnXpath)).click();
    }

    @Then("the {string} page should be loaded")
    public void testLinkLoaded(String link) {
        assertEquals(driver.getCurrentUrl(), link);
    }

    @Then("the {string} should showed")
    public void testContact(String popupXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupXpath)));
        assertEquals(driver.findElement(By.xpath(popupXpath)).getAttribute("class"), "modal fade show");
    }
}

