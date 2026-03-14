package Ex3.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class TestPageTest extends BaseTest {
    
    @Override
    protected void test() {
        openUrl("https://testpages.eviltester.com/pages/forms/html-form/");

        type(driver.findElement(By.name("username")), "Long7872");
        type(driver.findElement(By.name("password")), "long1234");
        type(driver.findElement(By.name("comments")), "\nlong\ndep\ntrai", false);

        if (getFilePathFromResources("meme_pic.jpg") != null) {
            driver.findElement(By.name("filename"))
                .sendKeys(getFilePathFromResources("meme_pic.jpg"));
        } else {
            System.err.println("Error!");
            System.exit(0);
        }

        List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                safeClick(checkbox);
            }
            if (checkbox.getAttribute("value").equals("cb1")) {
                safeClick(checkbox);
            }
            if (checkbox.getAttribute("value").equals("cb3")) {
                safeClick(checkbox);
            }
        }

        safeClick(driver.findElement(By.cssSelector("input[type='radio'][value='rd2']")));

        selectOption(driver.findElement(By.name("multipleselect[]")), Mode.VALUE, true, "ms1", "ms2");

        selectOption(driver.findElement(By.name("dropdown")), Mode.VALUE, false, "dd2");

        safeClick(driver.findElement(By.cssSelector("input[type='submit'][value='submit']")));
    }

    public static void main(String[] args) {
        new TestPageTest().run();
    }
}
