package lesson15_16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import lesson15_16.page.MtsPage;

import java.time.Duration;

public class TestBase {
    protected MtsPage mtsPage;
    protected WebDriver driver;

    @BeforeEach
    public void setUP() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mtsPage = PageFactory.initElements(driver, MtsPage.class);
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }
}

