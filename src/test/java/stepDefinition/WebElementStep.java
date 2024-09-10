package stepDefinition;

import PageObject.WebElementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebElementStep {
    WebDriver driver;
    WebElementPage webElement;

    public WebElementStep(){
        driver = Hooks.driver;
        webElement = new WebElementPage(driver);
    }

    @Then("Verify navigate to WebElementPage successful")
    public void verifyNavigateToWebElementPageSuccessful() {
    }
    @When("Click on button")
    public void clickOnButton() {
        webElement.clickonBtn1();
    }

    @And("Confirm accept")
    public void confirmAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Chờ cho alert xuất hiện
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        alert.accept();
        // Chờ cho trang web được cập nhật sau khi chấp nhận alert
        try {
            Thread.sleep(2000); // Thời gian chờ 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Verify button status disable")
    public void verifyButtonStatusDisable() {
        Assert.assertFalse(webElement.btn1IsEnable(),"Button 1 has been disabled");
    }

    @When("User input {string}")
    public void userInput(String arg0) {
        webElement.inputText1(arg0);
    }

    @When("User click on choose file button and select file")
    public void userClickOnChooseFileButtonAndSelectFile() {
        webElement.selectFile1("C:/Users/User/Downloads/cin.pdf");
    }
}
