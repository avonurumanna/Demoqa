//import org.junit.jupiter.api.Assertions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StudentRegistrationTest extends BaseUISettings {

    public static final String RESOURCES_PATH = ".\\src\\main\\resources\\";
    public final String firstName = "Anna";
    public final String lastName = "Test";
    public final String email = "test@test.ru";
    public final String gender = "Female";
    public final String mobile = "8963566543";
    public final String monthOfBirth = "June";
    public final String yearOfBirth = "1999";
    public final String dayOfBirth = "10";
    public final String subjects = "English, Maths";
    public final String hobbies = "Sports, Reading, Music";
    public final String picture = "testPhoto.jpg";
    public final String currentAddress = "Central Park 45";
    public final String state = "NCR";
    public final String city = "Delhi";

    @Test
    public void checkStudentRegistrationWithAllParametersFilledExpectedAllParametersDisplaysOnPopUpTest() throws InterruptedException {
        automationPracticeForm.fillFirstName(firstName);
        automationPracticeForm.fillLastName(lastName);
        automationPracticeForm.fillEmail(email);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.setGender(gender);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.fillSubjectInput(subjects);
        automationPracticeForm.setHobbies(hobbies);
        automationPracticeForm.addPhoto(RESOURCES_PATH + picture);
        automationPracticeForm.fillCurrentAddress(currentAddress);
        automationPracticeForm.fillState(state);
        automationPracticeForm.selectCity(city);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isTrue();
        Assertions.assertThat(resultPopUp.getName())
                .as("Student name should be %s %s", firstName, lastName)
                .isEqualTo("%s %s", firstName, lastName);
        Assertions.assertThat(resultPopUp.getEmail())
                .as("Student email should be %s", email)
                .isEqualTo(email);
        Assertions.assertThat(resultPopUp.getGender())
                .as("Student gender should be %s", gender)
                .isEqualTo(gender);
        Assertions.assertThat(resultPopUp.getMobile())
                .as("Student mobile should be %s", mobile)
                .isEqualTo(mobile);
        Assertions.assertThat(resultPopUp.getDateOfBirth())
                .as("Student date of birth should be %s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth)
                .isEqualTo("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth);
        Assertions.assertThat(resultPopUp.getSubjects())
                .as("Student Subject should be %s", subjects)
                .isEqualTo(subjects);
        Assertions.assertThat(resultPopUp.getHobbies())
                .as("Student hobbies should be %s", hobbies)
                .isEqualTo(hobbies);
        Assertions.assertThat(resultPopUp.getPicture())
                .as("Student photo should be %s", picture)
                .isEqualTo(picture);
        Assertions.assertThat(resultPopUp.getAddress())
                .as("Student currentAddress should be %s", currentAddress)
                .isEqualTo(currentAddress);
        Assertions.assertThat(resultPopUp.getStateAndCities())
                .as("Student state and city should be ", state, city)
                .isEqualTo("%s %s", state, city);

    }

    @Test
    public void checkStudentRegistrationWithMandatoryParametersFilledExpectedAllParametersDisplaysOnPopUpTest() {
        automationPracticeForm.fillFirstName(firstName);
        automationPracticeForm.fillLastName(lastName);
        automationPracticeForm.setGender(gender);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isTrue();
        Assertions.assertThat(resultPopUp.getName())
                .as("Student name should be %s %s", firstName, lastName)
                .isEqualTo("%s %s", firstName, lastName);
        Assertions.assertThat(resultPopUp.getEmail())
                .as("Student email should be empty")
                .isEmpty();
        Assertions.assertThat(resultPopUp.getGender())
                .as("Student gender should be %s", gender)
                .isEqualTo(gender);
        Assertions.assertThat(resultPopUp.getMobile())
                .as("Student mobile should be %s", mobile)
                .isEqualTo(mobile);
        Assertions.assertThat(resultPopUp.getDateOfBirth())
                .as("Student date of birth should be %s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth)
                .isEqualTo("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth);
        Assertions.assertThat(resultPopUp.getSubjects())
                .as("Student Subject should be empty")
                .isEmpty();
        Assertions.assertThat(resultPopUp.getHobbies())
                .as("Student hobbies should be empty")
                .isEmpty();
        Assertions.assertThat(resultPopUp.getPicture())
                .as("Student photo should be empty")
                .isEmpty();
        Assertions.assertThat(resultPopUp.getAddress())
                .as("Student currentAddress should be empty")
                .isEmpty();
        Assertions.assertThat(resultPopUp.getStateAndCities())
                .as("Student state and city should be empty")
                .isEmpty();
    }

    @Test
    public void checkStudentRegistrationWithoutFirstNameExpectedPopUpIsNotDisplayedTest() {
        automationPracticeForm.fillLastName(lastName);
        automationPracticeForm.fillEmail(email);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.setGender(gender);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.fillSubjectInput(subjects);
        automationPracticeForm.clickSportsCheckBox();
        automationPracticeForm.clickReadingCheckBox();
        automationPracticeForm.clickMusicCheckBox();
        automationPracticeForm.addPhoto(RESOURCES_PATH + picture);
        automationPracticeForm.fillCurrentAddress(currentAddress);
        automationPracticeForm.fillState(state);
        automationPracticeForm.selectCity(city);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isFalse();
    }

    @Test
    public void checkStudentRegistrationWithoutLastNameExpectedPopUpIsNotDisplayedTest() {
        automationPracticeForm.fillFirstName(firstName);
        automationPracticeForm.fillEmail(email);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.setGender(gender);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.fillSubjectInput(subjects);
        automationPracticeForm.clickSportsCheckBox();
        automationPracticeForm.clickReadingCheckBox();
        automationPracticeForm.clickMusicCheckBox();
        automationPracticeForm.addPhoto(RESOURCES_PATH + picture);
        automationPracticeForm.fillCurrentAddress(currentAddress);
        automationPracticeForm.fillState(state);
        automationPracticeForm.selectCity(city);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isFalse();
    }

    @Test
    public void checkStudentRegistrationWithoutGenderExpectedPopUpIsNotDisplayedTest() {
        automationPracticeForm.fillFirstName(firstName);
        automationPracticeForm.fillLastName(lastName);
        automationPracticeForm.fillEmail(email);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.fillSubjectInput(subjects);
        automationPracticeForm.clickSportsCheckBox();
        automationPracticeForm.clickReadingCheckBox();
        automationPracticeForm.clickMusicCheckBox();
        automationPracticeForm.addPhoto(RESOURCES_PATH + picture);
        automationPracticeForm.fillCurrentAddress(currentAddress);
        automationPracticeForm.fillState(state);
        automationPracticeForm.selectCity(city);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"@test.com", "te.st@test", "тест@gmail.com"})
    public void checkStudentRegistrationWithIncorrectEmailExpectedPopUpIsNotDisplayedTest(String email) {
        automationPracticeForm.fillFirstName(firstName);
        automationPracticeForm.fillLastName(lastName);
        automationPracticeForm.fillEmail(email);
        automationPracticeForm.setGender(gender);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"896547121", "asdfbvcxz", ""})
    public void checkStudentRegistrationWithIncorrectMobileExpectedPopUpIsNotDisplayedTest(String mobile) {
        automationPracticeForm.fillFirstName(firstName);
        automationPracticeForm.fillLastName(lastName);
        automationPracticeForm.setGender(gender);
        automationPracticeForm.fillMobileNumber(mobile);
        automationPracticeForm.clickDateOfBirthPicker();
        automationPracticeForm.selectMonth(monthOfBirth);
        automationPracticeForm.selectYear(yearOfBirth);
        automationPracticeForm.clickOnDay(dayOfBirth);
        automationPracticeForm.clickSubmitButton();
        ResultPopUp resultPopUp = new ResultPopUp(driver);
        Assertions.assertThat(resultPopUp.headerIdDisplayed()).isFalse();
    }
}

