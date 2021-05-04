package demoblaze.test.cart;

import demoblaze.test.setup.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class CartStepDefinitions extends Base {

    WebDriverWait wait = new WebDriverWait(driver,40);
    String selectedItem;
    int numberOfItems = 0;

    @Given("user select an item")
    public void selectItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a")));
        Setup.driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a")).click();
    }

    @And("Add to cart")
    public void addItemToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")));
        Setup.driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
        selectedItem = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/h2")).getText();
        wait.until(ExpectedConditions.alertIsPresent());
        Setup.driver.switchTo().alert().accept();
    }

    @When("user go to the cart page")
    public void navigateToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/div/ul/li[4]/a")));
        Setup.driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[4]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr")));
        numberOfItems = driver.findElements(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr")).size();
    }

    @Then("the selected item should shown in the cart")
    public void testItemInCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")));
        assertEquals(driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")).getText(), selectedItem);
    }

    @When("user delete one item")
    public void deleteItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[4]/a")));
        Setup.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[4]/a")).click();
    }
    @Then("item removed from cart")
    public void testDelete() throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(driver.findElements(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr")).size(), numberOfItems - 1);
    }
}
