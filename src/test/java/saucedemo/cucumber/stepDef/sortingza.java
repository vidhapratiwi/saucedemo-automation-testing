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

public class sortingza {
    WebDriver driver;
    String baseurl ="https://www.saucedemo.com/";
    @Given("user is login on the website")
    public void user_is_login_on_the_website(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click the sort dropdown menu on page")
    public void userClickTheSortDropdownMenuOnPage() {
        driver.findElement(By.xpath("//span[@class='select_container']")).click();
    }

    @Then("user select sort name z to a")
    public void userSelectSortNameZToA() {
        driver.findElement(By.xpath("//option[@value='za']")).click();
    }

    @And("products sorted by name from z to a")
    public void productsSortedByNameFromZToA() {
        String proDetailsza = driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
        Assert.assertEquals(proDetailsza, "Test.allTheThings() T-Shirt (Red)");
    }
}
