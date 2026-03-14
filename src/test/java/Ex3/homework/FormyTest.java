package Ex3.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utils.BaseTest;

public class FormyTest extends BaseTest {
    
    @Override
    protected void test() {
        openUrl("https://formy-project.herokuapp.com/form");

        type(driver.findElement(By.id("first-name")), "Long");
        type(driver.findElement(By.id("last-name")), "Khánh");
        type(driver.findElement(By.id("job-title")), "Student");
        safeClick(driver.findElement(By.id("radio-button-2")));
        safeClick(driver.findElement(By.id("checkbox-1")));
        selectOption(driver.findElement(By.id("select-menu")), Mode.VALUE, false, "1");
        type(driver.findElement(By.id("datepicker")), "03/12/2026").sendKeys(Keys.ENTER);

        safeClick(driver.findElement(By.linkText("Submit")));
    }

    public static void main(String[] args) {
        new FormyTest().run();
    }
}
