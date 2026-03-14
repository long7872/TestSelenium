package Ex3.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class SauceTest extends BaseTest {
    
    @Override
    protected void test() {
        openUrl("https://www.saucedemo.com/");

        String[] usernames = {
            "standard_user", 
            "locked_out_user", 
            "problem_user", 
            "performance_glitch_user", 
            "error_user", 
            "visual_user"
        };
        String password = "secret_sauce";

        for (int i=0; i<usernames.length; i++) {
            type(driver.findElement(By.id("user-name")), usernames[i]);
            type(driver.findElement(By.id("password")), password);
            safeClick(By.id("login-button"));

            if (driver.getCurrentUrl().contains("inventory.html")) {
                safeClick(By.id("react-burger-menu-btn"));
                safeClick(By.id("logout_sidebar_link"));
                System.out.println("LOG: username: " + usernames[i] + ", password: " + password + " ==> Correctly");
            } else {
                WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
                String text = error.getText();
                if (text.contains("has been locked out")) 
                    System.err.println("LOG: username: " + usernames[i] + ", password: " + password + " ==> Locked Out User");
                else 
                    System.err.println("LOG: username: " + usernames[i] + ", password: " + password + " ==> Uncorrectly");
            }
        }
    }

    public static void main(String[] args) {
        new SauceTest().run();
    }
}
