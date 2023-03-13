import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ResultPopUp extends BaseSettings {

    private final By header = By.id("example-modal-sizes-title-lg");
    private final By name = By.xpath(".//td[text() = 'Student Name']/following::td[1]");
    private final By email = By.xpath(".//td[text() = 'Student Email']/following::td[1]");
    private final By gender = By.xpath(".//td[text() = 'Gender']/following::td[1]");
    private final By mobile = By.xpath(".//td[text() = 'Mobile']/following::td[1]");
    private final By dateOfBirth = By.xpath(".//td[text() = 'Date of Birth']/following::td[1]");
    private final By subjects = By.xpath(".//td[text() = 'Subjects']/following::td[1]");
    private final By hobbies = By.xpath(".//td[text() = 'Hobbies']/following::td[1]");
    private final By picture = By.xpath(".//td[text() = 'Picture']/following::td[1]");
    private final By address = By.xpath(".//td[text() = 'Address']/following::td[1]");
    private final By stateAndCities = By.xpath(".//td[text() = 'State and City']/following::td[1]");

    public ResultPopUp(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        return driver.findElement(name).getText();
    }

    public String getEmail() {
        return driver.findElement(email).getText();
    }

    public String getGender() {
        return driver.findElement(gender).getText();
    }

    public String getMobile() {
        return driver.findElement(mobile).getText();
    }

    public String getDateOfBirth() {
        return driver.findElement(dateOfBirth).getText();
    }

    public String getSubjects() {
        return driver.findElement(subjects).getText();
    }

    public String getHobbies() {
        return driver.findElement(hobbies).getText();
    }

    public String getPicture() {
        return driver.findElement(picture).getText();
    }

    public String getAddress() {
        return driver.findElement(address).getText();
    }

    public String getStateAndCities() {
        return driver.findElement(stateAndCities).getText();
    }

    public boolean headerIdDisplayed() {
        try {
            driver.findElement(header);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
