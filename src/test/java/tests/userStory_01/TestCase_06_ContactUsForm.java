package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;



public class TestCase_06_ContactUsForm extends TestBaseRapor {

    AutomationExercise automationExercise = new AutomationExercise();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();


    @Test
    public void ContactUsForm() {


        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");


        automationExercise.logoAutomationExercise.isDisplayed();
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");

        automationExercise.contactUsLink.click();
        Driver.wait(3);


        automationExercise.nameBoxUnterGetInTouch.sendKeys(faker.name().fullName(),
                Keys.TAB, faker.internet().emailAddress(),
                Keys.TAB, ConfigReader.getProperty("AESubjectContactUs"),
                Keys.TAB, ConfigReader.getProperty("AEMessageContactUs"));

        Driver.wait(2);


        String dateiPfad= "C:\\Users\\mstaf\\Desktop\\Beweis_Foto.jpg";

        automationExercise.dateiAuswählenSchaltfläche.sendKeys(dateiPfad);

        Driver.wait(2);
        automationExercise.submitSchaltfläche.click();

        Driver.wait(2);

        Driver.getDriver().switchTo().alert().accept();

        softAssert.assertTrue(automationExercise.successYourDetailsHaveBeenSubmittedSuccessfullyText.isDisplayed());

        automationExercise.homeSchaltflächeUnterGetInTouch.click();

        softAssert.assertTrue(automationExercise.featuresItemsText.isDisplayed());


    }


}
