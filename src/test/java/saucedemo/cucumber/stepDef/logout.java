package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";

    @Given("user login website")
    public void user_login_website(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user navigate to sidebar menu")
    public void userNavigateToSidebarMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("user click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @And("user back to login page")
    public void userBackToLoginPage() {
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }
}
