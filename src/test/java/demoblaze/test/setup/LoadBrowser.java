package demoblaze.test.setup;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class LoadBrowser {

    protected static WebDriver driver ;

    static
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);*/
        driver.manage().window().maximize();
    }

}
