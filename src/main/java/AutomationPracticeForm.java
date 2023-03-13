import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class AutomationPracticeForm extends BaseSettings {
    private static final String FEMALE_GENDER = "Female";
    private static final String MALE_GENDER = "Male";
    private static final String OTHER_GENDER = "Other";
    private static final String SPORTS_HOBBY = "Sports";
    private static final String READING_HOBBY = "Reading";
    private static final String MUSIC_HOBBY = "Music";
    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By emailInput = By.id("userEmail");
    private final By femaleGenderRadioButton = By.cssSelector("[for='gender-radio-2']");
    private final By maleGenderRadioButton = By.cssSelector("[for='gender-radio-1']");
    private final By otherGenderRadioButton = By.cssSelector("[for='gender-radio-3']");
    private final By mobileNumberInput = By.id("userNumber");
    private final By dateOfBirthPicker = By.id("dateOfBirthInput");
    private final By monthsDropDownList = By.className("react-datepicker__month-select");
    private final By yearsDropDownList = By.className("react-datepicker__year-select");
    private final By subjectsInput = By.id("subjectsInput");
    private final By sportsCheckBox = By.cssSelector("[for='hobbies-checkbox-1']");
    private final By readingCheckBox = By.cssSelector("[for='hobbies-checkbox-2']");
    private final By musicCheckBox = By.cssSelector("[for='hobbies-checkbox-3']");
    private final By pictureInput = By.id("uploadPicture");
    private final By currentAddressInput = By.id("currentAddress");
    private final By stateDropDownList = By.id("state");
    private final By cityDropDownList = By.id("city");
    private final By submitButton = By.id("submit");

    public AutomationPracticeForm(WebDriver driver) {
        super(driver);
    }

    public void setGender(String gender) {
        switch (gender) {
            case (FEMALE_GENDER):
                driver.findElement(femaleGenderRadioButton).click();
                break;
            case (MALE_GENDER):
                driver.findElement(maleGenderRadioButton).click();
                break;
            case (OTHER_GENDER):
                driver.findElement(otherGenderRadioButton).click();
                break;
        }
    }

    public void setHobbies(String hobbies) {
        String[] hobbiesArray = hobbies.split(", ");
        for (String hobby : hobbiesArray) {
            switch (hobby) {
                case (SPORTS_HOBBY):
                    driver.findElement(sportsCheckBox).click();
                    break;
                case (READING_HOBBY):
                    driver.findElement(readingCheckBox).click();
                    break;
                case (MUSIC_HOBBY):
                    driver.findElement(musicCheckBox).click();
                    break;
            }
        }
    }

    public void fillFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
    }

    public void clickDateOfBirthPicker() {
        driver.findElement(dateOfBirthPicker).click();
    }

    public void selectYear(String year) {
        Select years = new Select(driver.findElement(yearsDropDownList));
        years.selectByVisibleText(year);
    }

    public void selectMonth(String month) {
        Select months = new Select(driver.findElement(monthsDropDownList));
        months.selectByVisibleText(month);
    }

    public void clickOnDay(String day) {
        driver.findElement(By.className("react-datepicker__day--0" + day)).click();
    }

    public void fillSubjectInput(String subjects) {
        String[] subjectsArray = subjects.split(", ");
        for (String subject : subjectsArray) {
            driver.findElement(subjectsInput).sendKeys(subject);
            driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
        }
    }

    public void clickSportsCheckBox() {
        driver.findElement(sportsCheckBox).click();
    }

    public void clickReadingCheckBox() {
        driver.findElement(readingCheckBox).click();
    }

    public void clickMusicCheckBox() {
        driver.findElement(musicCheckBox).click();
    }

    public void addPhoto(String photoPath) {
        File file = new File(photoPath);
        driver.findElement(pictureInput).sendKeys(file.getAbsolutePath());
    }

    public void fillCurrentAddress(String currentAddress) {
        driver.findElement(currentAddressInput).sendKeys(currentAddress);
    }

    public void fillState(String state) {
        driver.findElement(stateDropDownList).click();
        driver.findElement(By.xpath(".//*[text() = '" + state + "']")).click();
    }

    public void selectCity(String city) {
        driver.findElement(cityDropDownList).click();
        driver.findElement(By.xpath(".//*[text() = '" + city + "']")).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }


}
