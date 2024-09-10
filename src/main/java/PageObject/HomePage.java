package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By tiltemessa = By.xpath("//h2");

    private By testBtn = By.xpath("//button[@class='dropbtn' and contains(text(), 'Tests')]");
    private By webElemntloca = By.xpath("//a[@href='/Home/WebElements']");

    private By excercisesBtn = By.xpath("//button[@class='dropbtn' and contains(text(), 'Excercises')]");

    private By loginBtn = By.xpath("//a[@href='/Identity/Account/Login']");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTilte() {
        return driver.findElement(tiltemessa).getText();
    }
    // Method to navigate to the home page (if needed)
    public void navigateToHomePage(String url) {
        driver.get(url);
    }
    public String getTests(){
        return driver.findElement(testBtn).getText();
    }
    public void clickonTests() {
        driver.findElement(testBtn).click();
    }
    public void clickonWebElement() {
        driver.findElement(webElemntloca).click();
    }
    public String getExcercises(){
        return driver.findElement(excercisesBtn).getText();
    }
    public void clickonExcercises(){
        driver.findElement(excercisesBtn).click();
    }
    public void clickonLogin() {
        driver.findElement(loginBtn).click();
    }

}
