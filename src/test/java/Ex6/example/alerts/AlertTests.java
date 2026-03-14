package Ex6.example.alerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Ex6.example.BaseTests;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickButtonJSALert();
        alertPage.acceptJSAlert();
        Assertions.assertEquals(alertPage.getAlertResult(), "You successfully clicked an alert", "Result alert is incorrect!");
    }
    @Test
    public void testConfirmAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickButtonJSConfirm();
        String text = alertPage.getAlertText();
        alertPage.clickToCancel();
        Assertions.assertEquals(text, "I am a JS Confirm", "Alert text is incorrect!");
        Assertions.assertEquals(alertPage.getAlertResult(), "You clicked: Cancel", "Result alert is incorrect!");
        alertPage.clickButtonJSConfirm();
        alertPage.acceptJSAlert();
        Assertions.assertEquals(alertPage.getAlertResult(), "You clicked: Ok", "Result alert is incorrect!");
    }
    @Test
    public void testPromptAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickButtonJSPrompt();
        String alertText = alertPage.getAlertText();
        String textToInput = "ltbtra@vku.udn.vn";
        alertPage.sendTextToAlert(textToInput);
        alertPage.acceptJSAlert();
        Assertions.assertEquals(alertText, "I am a JS prompt", "Alert text is incorrect!");
        Assertions.assertEquals(alertPage.getAlertResult(), "You entered: "+textToInput, "Result alert is incorrect!");
        alertPage.clickButtonJSPrompt();
        alertPage.acceptJSAlert();
        Assertions.assertEquals(alertPage.getAlertResult(), "You entered:", "Result alert is incorrect!");
        alertPage.clickButtonJSPrompt();
        alertPage.clickToCancel();
        Assertions.assertEquals(alertPage.getAlertResult(), "You entered: null", "Result alert is incorrect!");
    }
}
