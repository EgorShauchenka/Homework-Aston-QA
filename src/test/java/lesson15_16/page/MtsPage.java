package lesson15_16.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPage {

    WebDriver driver;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String BASE_URL = "https://www.mts.by/";

    @FindBy(css = "#cookie-agree")
    private WebElement buttonAgree;

    @FindBy(css = ".pay__wrapper h2")
    private WebElement logoText;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement serviceLink;

    @FindBy(xpath = "//div[@class='pay__forms']/form[@id='pay-connection']//button[text()='Продолжить']")
    private WebElement button;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    private WebElement amount;

    @FindBy(id = "connection-email")
    private WebElement email;

    @FindBy(css = ".select__header")
    private WebElement buttonHeader;

    public MtsPage baseUrl() {
        driver.get(BASE_URL);
        return this;
    }

    public MtsPage buttonAgree() {
        if (buttonAgree.isDisplayed()) {
            buttonAgree.click();
        }
        return this;
    }

    public String getLogoText() {
        return logoText.getText();
    }

    public MtsPage checkLink() {
        Assertions.assertNotNull(serviceLink);
        serviceLink.isDisplayed();
        serviceLink.click();
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public MtsPage setValue(String phone, String amount, String email) {
        phoneNumber.sendKeys(phone);
        this.amount.sendKeys(amount);
        this.email.sendKeys(email);
        button.click();
        return this;
    }

    public String getText() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Безопасная оплата обеспечивается')]")));
        return element.getText();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}