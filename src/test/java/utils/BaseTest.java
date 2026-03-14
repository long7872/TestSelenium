package utils;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void setUp() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-features=PasswordLeakDetection");
        // options.addArguments("--disable-save-password-bubble");
        // options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1024, 720));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
    }

    protected void openUrl(String url) {
        openUrl(url, true);
    }
    protected void openUrl(String url, Boolean enableLog) {
        driver.get(url);
        if (enableLog)
            System.out.println("\nTitle: " + driver.getTitle() + "\n");
    }

    protected abstract void test();

    protected WebElement type(WebElement element, String text) {
        return type(element, text, true);
    }
    protected WebElement type(WebElement element, String text, Boolean isClear) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        if (isClear) {
            element.clear();
        }
        element.sendKeys(text);
        return element;
    }

    protected WebElement getRadioButtonByValue(String value) {
        return driver.findElement(By.cssSelector("input[value='" + value + "']"));
    }

    protected WebElement getCheckboxLabel(String text) {
        WebElement label = driver.findElement(By.xpath("//label[text()='" + text + "']"));
        return label;
    }

    protected void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        element.click();
    }
    protected void safeClick(WebElement element) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected enum Mode { TEXT, VALUE, INDEX }
    protected Boolean selectOption(WebElement element, Mode mode, Boolean isMultiple, String... options) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        
        Select select = new Select(element);

        if (options.length < 1) return false;

        if (select.isMultiple() && isMultiple == true) {
            select.deselectAll();
            for (String option : options) {
                switch (mode) {
                    case TEXT:
                        select.selectByVisibleText(option);
                        break;
                    case VALUE:
                        select.selectByValue(option);
                        break;
                    case INDEX:
                        select.selectByIndex(Integer.parseInt(option));
                        break;
                }
            }
        } else if (!select.isMultiple() && isMultiple == false) {
            if (options.length != 1) 
                return false;
            
            switch (mode) {
                case TEXT:
                    select.selectByVisibleText(options[0]);
                    break;
                case VALUE:
                    select.selectByValue(options[0]);
                    break;
                case INDEX:
                    select.selectByIndex(Integer.parseInt(options[0]));
                    break;
            }
        }
        return true;
    }

    protected String getFilePathFromResources(String name) {
        try {
            return Paths.get(getClass().getClassLoader().getResource(name).toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void tearDown() {
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    protected void run() {
        setUp();
        test();
        tearDown();
    }
}