package Ex5.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DynamicLoadingTests extends BaseTests {
    @Test
    @DisplayName("TC01-Element Load successfully")
    public void testElementLoadSuccessful() {
        OptionsPage optionsPage = homePage.clickDynamicLoading();
        LoadingPage loadingPage = optionsPage.clickExample1();
        loadingPage.clickStartButton();
        String loadedText = loadingPage.getFinishText();
        Assertions.assertTrue(loadedText.contains("Hello World!"), "Alert text is incorrect!");
    }
}
