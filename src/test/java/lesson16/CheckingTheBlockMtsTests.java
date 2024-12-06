package lesson16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CheckingTheBlockMtsTests extends TestBase {


    @DisplayName("Проверка надписей в незаполенных полях")
    @ParameterizedTest(name = "У {0} должны присутствовать элементы: {1},{2},{3},")
    @CsvSource({
            "Услуги связи, Номер телефона, Сумма, E-mail для отправки чека",
            "Домашний интернет, Номер абонента, Сумма, E-mail для отправки чека",
            "Рассрочка, Номер счета на 44, Сумма, E-mail для отправки чека",
            "Задолженность, Номер счета на 2073, Сумма, E-mail для отправки чека"

    })
    void checkNotationsInBlankFields(String select, String number, String sum, String email) {
        mtsPage.baseUrl()
                .buttonAgree()
                .clickButtonHeader()
                .selectService(select)
                .checkFields(select, number, sum, email);
    }

    @DisplayName("Проверка корректного отображение суммы")
    @Test
    void checkAmountDisplayedCorrectly() {
        mtsPage.baseUrl()
                .buttonAgree()
                .setValue("297777777", "150", "example@mail.com");
        String actualText = mtsPage.getTextSum();
        Assertions.assertEquals("150.00 BYN", actualText);
        mtsPage.switchToDefaultContent();
    }


    @DisplayName("Проверка корректного отображение суммы на кнопке")
    @Test
    void checkAmountOnButtonDisplayedCorrectly() {
        mtsPage.baseUrl()
                .buttonAgree()
                .setValue("297777777", "150", "example@mail.com");
        String actualText = mtsPage.getTextSumButton();
        Assertions.assertEquals("Оплатить 150.00 BYN", actualText);
        mtsPage.switchToDefaultContent();
    }

    @DisplayName(value = "Проверка корректного отображение номера телефона")
    @Test
    void checkPhoneNumberDisplayedCorrectly() {
        mtsPage.baseUrl()
                .buttonAgree()
                .setValue("297777777", "150", "example@mail.com");
        String actualText = mtsPage.getTextPhoneNumber();
        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", actualText);
        mtsPage.switchToDefaultContent();
    }

    @DisplayName(value = "Проверка корректного отображения незаполненных полей")
    @ParameterizedTest(name = "Корректно отображается ({0}) ")
    @CsvSource({
            "Номер карты, creditCard",
            "Срок действия, expirationDate",
            "CVC, cvc",
            "Имя держателя (как на карте), holder"
    })
    void cardDetailsCheck(String expectedLabel, String formControlName) {
        mtsPage.baseUrl()
                .buttonAgree()
                .setValue("297777777", "150", "example@mail.com")
                .checkFieldsCardDetail(expectedLabel, formControlName);
        mtsPage.switchToDefaultContent();
    }

    @DisplayName(value = "Проверка наличие иконок платежных систем")
    @Test
    void checkIconsPaymentsSystem() {
        mtsPage.baseUrl()
                .buttonAgree()
                .setValue("297777777", "150", "example@mail.com")
                .checkIconsVisibility();
    }
}

