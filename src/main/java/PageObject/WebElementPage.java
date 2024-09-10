package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementPage {
    WebDriver driver;
    private By text1 = By.id("Text1");
    private By btn1 = By.id("Button1");
    private By file1 = By.id("File1");

    // Constructor
    public WebElementPage (WebDriver driver) {
        this.driver = driver;
    }

    public  void inputText1 (String text) {
        driver.findElement(text1).sendKeys(text);
    }
    public void clickonBtn1(){
        driver.findElement(btn1). click();
    }
    public Boolean btn1IsEnable(){
        return driver.findElement(btn1).isEnabled();
    }
    public void selectFile1(String path) {
        driver.findElement(file1).sendKeys(path);
    }
//    public String getFile1() {
//        return  driver.findElement(file1).getText();
//    }
}
