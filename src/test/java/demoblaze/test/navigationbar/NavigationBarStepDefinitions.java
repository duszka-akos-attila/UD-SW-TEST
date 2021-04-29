package demoblaze.test.navigationbar;

import demoblaze.test.setup.LoadBrowser;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

import static org.testng.Assert.assertEquals;

public class NavigationBarStepDefinitions extends LoadBrowser {

    WebDriverWait wait = new WebDriverWait(driver,40);

    @Given("the {string} website")
    public void loadSite(String url) {
        driver.navigate().to(url);
    }

    @Given("the user press the {string} button")
    public void buttonPressed(String btnXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnXpath)));
        driver.findElement(By.xpath(btnXpath)).click();
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

    @After
    public void resetSite() {
        driver.navigate().to("https://www.demoblaze.com");
    }

}

