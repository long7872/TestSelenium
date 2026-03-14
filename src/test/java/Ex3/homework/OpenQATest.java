package Ex3.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utils.BaseTest;

public class OpenQATest extends BaseTest {
    
    @Override
    protected void test() {
        openUrl("https://demoqa.com/automation-practice-form");

        type(driver.findElement(By.id("firstName")), "John");
        type(driver.findElement(By.id("lastName")), "Doe");

        type(driver.findElement(By.id("userEmail")), "johndoe@gmail.com");

        getRadioButtonByValue("Male").click();

        type(driver.findElement(By.id("userNumber")), "0355465723");

        type(driver.findElement(By.id("dateOfBirthInput")), "10 Mar 2026").sendKeys(Keys.ENTER);

        type(driver.findElement(By.id("subjectsInput")), "Maths").sendKeys(Keys.ENTER);
        
        safeClick(getCheckboxLabel("Sports"));
        safeClick(getCheckboxLabel("Music"));
        
        if (getFilePathFromResources("meme_pic.jpg") != null) {
            driver.findElement(By.id("uploadPicture"))
                .sendKeys(getFilePathFromResources("meme_pic.jpg"));
        } else {
            System.err.println("Error!");
            System.exit(0);
        }
        
        type(driver.findElement(By.id("currentAddress")), "Hoi An Quang Nam Da Nang");

        type(driver.findElement(By.id("react-select-3-input")), "NCR").sendKeys(Keys.ENTER);
        type(driver.findElement(By.id("react-select-4-input")), "Noida").sendKeys(Keys.ENTER);

        safeClick(driver.findElement(By.id("submit")));
        
        // openUrl("https://demoqa.com/automation-practice-form");
    }

    public static void main(String[] args) {
        new OpenQATest().run();
    }
}
