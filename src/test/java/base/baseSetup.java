package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class baseSetup {
    private static WebDriver driver;

    static String driverPath = "resources\\drivers\\";

    public static WebDriver getDriver() {
        return driver;
    }
    public static void takeScreenShot(String name) {
        try {
            // Ép kiểu WebDriver sang TakesScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            // Chụp ảnh và lưu vào File
            File screenshotFile = scrShot.getScreenshotAs(OutputType.FILE);

            // Sao chép file ảnh vào thư mục mong muốn
            FileUtils.copyFile(screenshotFile, new File("./screenshots/" + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String screenshotPath = "screenshots/" + screenshotName +".png";
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
    public WebDriver setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
//        System.out.println("Launching Chrome browser...");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        return driver;
        System.out.println("Launching Chrome browser...");

        // Set up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and set headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run Chrome in headless mode
        options.addArguments("--disable-gpu"); // Optional: Disable GPU acceleration
        options.addArguments("--window-size=1920,1080"); // Optional: Set window size

        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Configure WebDriver timeouts
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }


    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            // Khởi tạo driver và browser
            setupDriver(browserType);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
