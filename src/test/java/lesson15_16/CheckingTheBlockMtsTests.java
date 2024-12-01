package lesson15_16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckingTheBlockMtsTests extends TestBase {

    @DisplayName("Проверка названия блока")
    @Test
    void checkNameBlock() {
        mtsPage.baseUrl()
                .buttonAgree();
        String logoText = mtsPage.getLogoText();
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", logoText);
    }

    @DisplayName("Проверка логотипа")
    @Test
    void checkLogo() {
        mtsPage.baseUrl()
                .buttonAgree();
        List<WebElement> listLogo = driver.findElements(By.cssSelector(" .pay__partners ul li"));
        for (WebElement logo : listLogo) {
            Assertions.assertTrue(logo.isDisplayed(), "Логотип не отобразился : " + logo.getAttribute("alt"));
        }
    }

    @DisplayName("Проверка работы ссылки")
    @Test
    void checkWorkLink() {
        mtsPage.baseUrl()
                .buttonAgree()
                .checkLink();
        String title = mtsPage.getTitle();
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", title);
    }

    @DisplayName("Проверка работы кнопки")
    @Test
    void checkWorkButton() {
        mtsPage.baseUrl()
                .buttonAgree()
                .setValue("297777777", "150", "example@mail.com");

        String actualText = mtsPage.getText();
        Assertions.assertTrue(actualText.contains("Безопасная оплата обеспечивается"),
                "Текст кнопки не содержит ожидаемую строку.");

        mtsPage.switchToDefaultContent();
    }
}







