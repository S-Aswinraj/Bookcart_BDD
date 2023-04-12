package StepDefinition;

import com.amazonaws.services.dynamodbv2.xspec.S;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

   public static WebDriver driver;
   String HomepageURL = "https://bookcart.azurewebsites.net/";
    String UrlAfterLogin;
    String UrlBeforeLogin;

    @Given("User is in book cart homepage")
    public void userIsInBookCartHomepage() {
        //this code is to open chrome incognito window
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        //this is to open chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().deleteAllCookies();
        driver.get(HomepageURL);
        UrlBeforeLogin = driver.getCurrentUrl();
        System.out.println("The url before login is: "+UrlBeforeLogin);

    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[3]")).click();

    }

    @When("user inputting valid credentials")
    public void userInputtingValidCredentials() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("mat-input-0")).sendKeys("abcxy");
        driver.findElement(By.id("mat-input-1")).sendKeys("Abc1234!");
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[8]")).click();

    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        UrlAfterLogin = driver.getCurrentUrl();
        System.out.println("After login the url is: "+UrlAfterLogin);
        Assert.assertNotEquals(UrlAfterLogin,UrlBeforeLogin);

    }
    @Then("user quit browser")
    public void userQuitBrowser() {
        driver.quit();
    }

}
