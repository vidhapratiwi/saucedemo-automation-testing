package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class productDetails {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";
    @Given("user already login to saucedemo")
    public void user_already_login_to_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click on product name")
    public void userClickOnProductName() {
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @Then("product details is displayed")
    public void productDetailsIsDisplayed() {
        String proDetails = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        Assert.assertEquals(proDetails, "Sauce Labs Backpack");

    }
}
