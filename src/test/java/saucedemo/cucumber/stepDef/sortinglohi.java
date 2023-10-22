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

public class sortinglohi {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";
    @Given("user login the website")
    public void user_login_the_website(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click sort dropdown")
    public void userClickSortDropdown() {
        driver.findElement(By.xpath("//span[@class='select_container']")).click();
    }

    @Then("user select price low to high")
    public void userSelectPriceLowToHigh() {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
    }

    @And("products are sorted by the lowest price")
    public void productsAreSortedByTheLowestPrice() {
        String proDetails = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        Assert.assertEquals(proDetails, "$7.99");
    }
}
