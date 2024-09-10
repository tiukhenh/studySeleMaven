package stepDefinition;

import PageObject.HomePage;

import PageObject.WebElementPage;
import base.baseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class commonStepDefinition {
    WebDriver driver;
    HomePage homePage;

    public commonStepDefinition(){
        driver = Hooks.driver;
        homePage = new HomePage(driver);
    }
    @Given("Navigate to HomePage")
    public void navigate_to_home_page() {
//        driver = new baseSetup().setupDriver("chrome");
//        homePage = new HomePage(driver);

        homePage.navigateToHomePage("https://www.admlucid.com");
    }

    @Then("Verify navigate to Homepage successful")
    public void verifyNavigateToHomepageSuccessful() {
        assert(homePage.getTilte().contains("Step By Step Build Automation Test Projects"));
    }

    @When("Click on Test button")
    public void clickOnTestButton() {
        homePage.clickonTests();
    }

    @And("Click on WebElement")
    public void clickOnWebElement() {
        homePage.clickonWebElement();
    }

    @When("Screenshot {string}")
    public void screenshot(String arg0) {
        baseSetup.takeScreenShot(arg0);
    }
}
