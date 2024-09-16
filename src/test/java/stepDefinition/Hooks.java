package stepDefinition;

import PageObject.HomePage;
import base.baseSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {
    public static WebDriver driver;
    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        // Khởi tạo WebDriver trước mỗi scenario
        driver = new baseSetup().setupDriver("chrome");
        driver.manage().window().maximize();
}

    @After
    public void tearDown(Scenario scenario) throws Exception  {
//         Đóng trình duyệt sau mỗi scenario
        if (scenario.isFailed()) {
            log.error("        " + scenario.getName() + " is FAILED :((");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        else {
            log.error("        " + scenario.getName() + " is PASSED <3");
            log.info("        " + scenario.getName() + " is PASSED <3");
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
