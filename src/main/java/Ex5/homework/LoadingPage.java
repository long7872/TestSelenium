package Ex5.homework;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoadingPage {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private By startButton = By.xpath("//button[contains(text(), 'Start')]");

    public LoadingPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public void clickStartButton() {
        driver.findElement(startButton).click();
    }
    public String getFinishText() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        return driver.findElement(By.id("finish")).getText();
    }
}
