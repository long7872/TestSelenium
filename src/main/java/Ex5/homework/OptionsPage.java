package Ex5.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OptionsPage {
    private WebDriver driver;
    private By example1Link = By.xpath("//a[contains(text(),'Example 1')]");

    public OptionsPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoadingPage clickExample1() {
        driver.findElement(example1Link).click();
        return new LoadingPage(driver);
    }
}
