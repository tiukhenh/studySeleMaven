package Runtest;

import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Home {
    WebDriver driver;
    HomePage homePage;
    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Khởi tạo đối tượng HomePage
        homePage = new HomePage(driver);
    }
    @Test
    public void testHomePage() {
        homePage.navigateToHomePage("https://www.admlucid.com/Home/SeleniumSBS");

        assert(homePage.getTilte().contains("Step By Step Build Automation Test Projects"));
//        homePage.clickonTests();
//        homePage.clickonWebElement();
//        homePage.inputText1("hello");
        Assert.assertEquals(homePage.getTests(),"Tests");


    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
