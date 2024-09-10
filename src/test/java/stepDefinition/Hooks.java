package stepDefinition;

import PageObject.HomePage;
import base.baseSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        // Khởi tạo WebDriver trước mỗi scenario
        driver = new baseSetup().setupDriver("chrome");
        driver.manage().window().maximize();
}

    @After
    public void tearDown() {
        // Đóng trình duyệt sau mỗi scenario
        if (driver != null) {
            driver.quit();
        }
    }
}
