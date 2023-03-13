import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseUISettings {
    private final String url = "https://demoqa.com/automation-practice-form";
    protected WebDriver driver;
    protected AutomationPracticeForm automationPracticeForm;

    @BeforeEach
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        automationPracticeForm = new AutomationPracticeForm(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
