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

public class login {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";
    @Given("user opens the website page")
    public void user_opens_the_website_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("user input (.*) as username$")
    public void user_input_standard_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void user_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if(status.equals("success")) { //jika success
            driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]"));
        } else {
            String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        }
        driver.close();
    }

    //@And("user input invalid password")
    //public void userInputInvalidPassword() {
    //    driver.findElement(By.id("password")).sendKeys("failed_login");
    //}

    //@Then("user get error message")
    //public void userGetErrorMessage() {
    //    String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    //    Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    //}
}
