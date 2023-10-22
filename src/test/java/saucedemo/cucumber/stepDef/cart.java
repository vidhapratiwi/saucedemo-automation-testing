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

public class cart {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";
    @Given("user success login to saucedemo")
    public void user_success_login_to_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Thread.sleep(1000);
    }

    @When("user click the add to cart button on selected product")
    public void userClickTheAddToCartButtonOnSelectedProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("user click the cart icon button")
    public void userClickTheCartIconButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("the selected product will be displayed")
    public void theSelectedProductWillBeDisplayed() {
        driver.findElement(By.xpath("//div[@class='cart_item']"));
    }
}
