package Ex5.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formLoginLink = By.linkText("Form Authentication");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickForm() {
        driver.findElement(formLoginLink).click();
        return new LoginPage(driver);
    }
}
