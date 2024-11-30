package lesson15_16.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    public MtsPage clickButtonHeader() {
        buttonHeader.click();
        return this;
    }

    public MtsPage selectService(String serviceName) {
        WebElement selectedOption = driver.findElement(By.xpath("//option[@value='" + serviceName + "']"));
        selectedOption.click();
        return this;
    }

    public MtsPage checkFields(String serviceName, String... expectedLabels) {
        String formId = driver.findElement(By.xpath("//option[@value='" + serviceName + "']"))
                .getAttribute("data-open");

        List<WebElement> inputFields = driver.findElements(By.cssSelector("#" + formId + " input[type='text']"));

        for (WebElement field : inputFields) {
            String label = field.getAttribute("placeholder");
            assertTrue(Arrays.asList(expectedLabels).contains(label));
        }
        return this;
    }

    public String getTextSum() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'BYN')]")));
        return element.getText();
    }

    public String getTextSumButton() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.colored.disabled")));
        return element.getText();
    }

    public String getTextPhoneNumber() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.header__payment-info")));
        return element.getText();
    }

    public MtsPage checkFieldsCardDetail(String expectedLabel, String formControlName) {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='" + formControlName + "']" + "/following-sibling::label")));

        assertTrue(inputField.getText().contains(expectedLabel));
        return this;
    }

    public MtsPage checkIconsVisibility() {
        WebElement iframe = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cardsBrandsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cards-brands__container")));
        List<WebElement> paymentIcons = cardsBrandsContainer.findElements(By.tagName("img"));

        Assertions.assertEquals(5, paymentIcons.size());

        for (WebElement icon : paymentIcons) {
            wait.until(ExpectedConditions.visibilityOf(icon));
            Assertions.assertTrue(icon.isDisplayed());
        }
        return this;
    }

    public MtsPage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }
}

