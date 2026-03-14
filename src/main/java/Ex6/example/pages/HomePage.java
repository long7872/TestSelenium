package Ex6.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ex5.example.pages.LoginPage;
import Ex5.homework.OptionsPage;

public class HomePage {
    private WebDriver driver;
    private By formLoginLink = By.linkText("Form Authentication");
    private By dynamicLoadingLink = By.linkText("Dynamic Loading"); 
    private By javaScriptAlertsLink = By.linkText("JavaScript Alerts");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickForm() {
        driver.findElement(formLoginLink).click();
        return new LoginPage(driver);
    }
    public OptionsPage clickDynamicLoading() {
        driver.findElement(dynamicLoadingLink).click();
        return new OptionsPage(driver);
    }
    public AlertPage clickJavaScriptAlerts() {
        driver.findElement(javaScriptAlertsLink).click();
        return new AlertPage(driver);
    }
}
