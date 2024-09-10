package Runtest;

import PageObject.HomePage;
import PageObject.WebElementPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebElement {
    WebDriver driver;
    HomePage homePage;
    WebElementPage webElement;
    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Khởi tạo đối tượng HomePage
        homePage = new HomePage(driver);

        homePage.navigateToHomePage("https://www.admlucid.com/Home/SeleniumSBS");
        assert(homePage.getTilte().contains("Step By Step Build Automation Test Projects"));

        webElement = new WebElementPage(driver);
        homePage.clickonTests();
        homePage.clickonWebElement();
    }
    @Test(priority = 2)
    public void testInputText1() {
        webElement.inputText1("hello");

    }
    @Test (priority = 1)
    public void testBtn1() {
        webElement.clickonBtn1();
        Alert alert = driver.switchTo().alert();

        System.out.println("Alert Text "+ alert.getText());

        Assert.assertEquals(alert.getText(),"Button has been disabled.Button1");

        alert.accept();
        Assert.assertFalse(webElement.btn1IsEnable(),"Button 1 has been disabled");

    }
    @Test (priority = 3)
    public void chooseFile() {
        webElement.selectFile1("C:/Users/User/Downloads/cin.pdf");
//        System.out.println(webElement.getFile1());
    }
//    @AfterSuite
//    public void tearDown() {
//        driver.quit();
//    }
}
