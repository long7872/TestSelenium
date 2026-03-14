package Ex5.example.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Ex5.example.BaseTests;
import Ex5.example.pages.LoginPage;
import Ex5.example.pages.SecureAreaPage;

public class LoginTests extends BaseTests {
    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessful() {
        LoginPage loginPage = homePage.clickForm();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("You logged into a secure area!"), "Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC02-Login failed with invalid username")
    public void testLoginWithInvalidUsername() {
        LoginPage loginPage = homePage.clickForm();
        loginPage.setUsername("gg");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Your username is invalid!"), "Alert text is incorrect!");
    }
    @Test
    @DisplayName("TC03-Login failed with wrong password")
    public void testLoginWithWrongPassword() {
        LoginPage loginPage = homePage.clickForm();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("gg!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("Your password is invalid!"), "Alert text is incorrect!");
    }
}
