package lesson18;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Epic("Проверка блока MTS")
@Feature("Проверка отображения и функциональности форм")
public class CheckingTheBlockMtsTests extends TestBase {

    @DisplayName("Проверка надписей в незаполненных полях")
    @Story("Валидация отображения подсказок в полях")
    @ParameterizedTest(name = "У {0} должны присутствовать элементы: {1}, {2}, {3}")
    @CsvSource({
            "Услуги связи, Номер телефона, Сумма, E-mail для отправки чека",
            "Домашний интернет, Номер абонента, Сумма, E-mail для отправки чека",
            "Рассрочка, Номер счета на 44, Сумма, E-mail для отправки чека",
            "Задолженность, Номер счета на 2073, Сумма, E-mail для отправки чека"
    })
    void checkNotationsInBlankFields(String select, String number, String sum, String email) {
        Allure.step("Открываем главную страницу", mtsPage::baseUrl);
        Allure.step("Нажимаем кнопку 'Согласен'", mtsPage::buttonAgree);
        Allure.step("Открываем меню и выбираем услугу: " + select, () -> {
            mtsPage.clickButtonHeader()
                    .selectService(select);
        });
        Allure.step("Проверяем наличие полей: " + number + ", " + sum + ", " + email, () -> {
            mtsPage.checkFields(select, number, sum, email);
        });
    }

    @DisplayName("Проверка корректного отображения суммы")
    @Story("Валидация суммы оплаты")
    @Test
    void checkAmountDisplayedCorrectly() {
        Allure.step("Открываем главную страницу", mtsPage::baseUrl);
        Allure.step("Нажимаем кнопку 'Согласен'", mtsPage::buttonAgree);
        Allure.step("Заполняем поля: телефон, сумма, email", () -> {
            mtsPage.setValue("297777777", "150", "example@mail.com");
        });
        Allure.step("Получаем текст отображаемой суммы", () -> {
            String actualText = mtsPage.getTextSum();
            Assertions.assertEquals("150.00 BYN", actualText, "Сумма отображается некорректно");
        });
        Allure.step("Переключаемся на основной контент", mtsPage::switchToDefaultContent);
    }

    @DisplayName("Проверка корректного отображения суммы на кнопке")
    @Story("Валидация отображения суммы на кнопке")
    @Test
    void checkAmountOnButtonDisplayedCorrectly() {
        Allure.step("Открываем главную страницу", mtsPage::baseUrl);
        Allure.step("Нажимаем кнопку 'Согласен'", mtsPage::buttonAgree);
        Allure.step("Заполняем поля: телефон, сумма, email", () -> {
            mtsPage.setValue("297777777", "150", "example@mail.com");
        });
        Allure.step("Получаем текст с кнопки оплаты", () -> {
            String actualText = mtsPage.getTextSumButton();
            Assertions.assertEquals("Оплатить 150.00 BYN", actualText, "Текст на кнопке отображается некорректно");
        });
        Allure.step("Переключаемся на основной контент", mtsPage::switchToDefaultContent);
    }

    @DisplayName("Проверка корректного отображения номера телефона")
    @Story("Валидация отображения номера телефона")
    @Test
    void checkPhoneNumberDisplayedCorrectly() {
        Allure.step("Открываем главную страницу", mtsPage::baseUrl);
        Allure.step("Нажимаем кнопку 'Согласен'", mtsPage::buttonAgree);
        Allure.step("Заполняем поля: телефон, сумма, email", () -> {
            mtsPage.setValue("297777777", "150", "example@mail.com");
        });
        Allure.step("Получаем текст с номером телефона", () -> {
            String actualText = mtsPage.getTextPhoneNumber();
            Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", actualText, "Номер телефона отображается некорректно");
        });
        Allure.step("Переключаемся на основной контент", mtsPage::switchToDefaultContent);
    }

    @DisplayName("Проверка корректного отображения незаполненных полей")
    @Story("Валидация отображения подсказок для карты")
    @ParameterizedTest(name = "Проверяем поле: {0}")
    @CsvSource({
            "Номер карты, creditCard",
            "Срок действия, expirationDate",
            "CVC, cvc",
            "Имя держателя (как на карте), holder"
    })
    void cardDetailsCheck(String expectedLabel, String formControlName) {
        Allure.step("Открываем главную страницу", mtsPage::baseUrl);
        Allure.step("Нажимаем кнопку 'Согласен'", mtsPage::buttonAgree);
        Allure.step("Заполняем поля: телефон, сумма, email", () -> {
            mtsPage.setValue("297777777", "150", "example@mail.com");
        });
        Allure.step("Проверяем поле: " + expectedLabel, () -> {
            mtsPage.checkFieldsCardDetail(expectedLabel, formControlName);
        });
        Allure.step("Переключаемся на основной контент", mtsPage::switchToDefaultContent);
    }

    @DisplayName("Проверка наличия иконок платежных систем")
    @Story("Валидация видимости иконок платежных систем")
    @Test
    void checkIconsPaymentsSystem() {
        Allure.step("Открываем главную страницу", mtsPage::baseUrl);
        Allure.step("Нажимаем кнопку 'Согласен'", mtsPage::buttonAgree);
        Allure.step("Проверяем видимость иконок платежных систем", () -> {
            mtsPage.checkIconsVisibility();
        });
    }
}
