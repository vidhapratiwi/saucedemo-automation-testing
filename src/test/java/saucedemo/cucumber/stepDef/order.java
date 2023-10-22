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

public class order {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";
    @Given("user login to saucedemo")
    public void user_login_to_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Thread.sleep(1000);
    }

    @When("user click the add to cart button")
    public void userClickTheAddToCartButton() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("user click the icon cart button")
    public void userClickTheIconCartButton() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("the selected product is displayed")
    public void theSelectedProductIsDisplayed() {
        driver.findElement(By.xpath("//div[@class='cart_item']"));
    }

    @And("user click the checkout button")
    public void userClickTheCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("user fills the information form")
    public void userFillsTheInformationForm() {
        driver.findElement(By.id("first-name")).sendKeys("moa");
        driver.findElement(By.id("last-name")).sendKeys("ina");
        driver.findElement(By.id("postal-code")).sendKeys("40440");
    }

    @And("user click the continue button")
    public void userClickTheContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("order overview is displayed")
    public void orderOverviewIsDisplayed() {
        driver.findElement(By.xpath("//div[@class='cart_item']"));
        driver.findElement(By.xpath("//div[@class='summary_info']"));
    }

    @And("user click the finish button")
    public void userClickTheFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("the confirmation message is diplayed")
    public void theConfirmationMessageIsDiplayed() {
        driver.findElement(By.id("checkout_complete_container"));
        String orderSuccess = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        Assert.assertEquals(orderSuccess, "Thank you for your order!");
    }


}
