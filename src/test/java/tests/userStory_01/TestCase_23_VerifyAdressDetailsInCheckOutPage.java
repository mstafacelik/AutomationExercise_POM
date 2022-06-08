package tests.userStory_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class TestCase_23_VerifyAdressDetailsInCheckOutPage extends TestBaseRapor {
    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void verifyAdressDetailsInCheckOutPage() {

        automationExercise = new AutomationExercise();
        softAssert = new SoftAssert();
        random = new Random();
        faker = new Faker();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Test von AutomationExercise");

        Driver.getDriver();
        extentTest.info("Browser wurde gestartet.");


        Driver.getDriver().get(ConfigReader.getProperty("AutomationExerciseUrl"));
        extentTest.info("Es wurde zur URL „http://automationexercise.com“ navigiert.");

        automationExercise.signupLoginLink.click();
        automationExercise.newUserNameBox
                .sendKeys(faker.name().fullName(),
                        Keys.TAB, faker.internet().emailAddress(), Keys.TAB, Keys.ENTER);

        automationExercise.radioTitleMr.click();
        automationExercise.paswordBoxZumKontoErstellen.sendKeys(faker.internet().password());
        Driver.selectByIndex(automationExercise.geburtsdatumTagSelect, 16);
        Driver.selectByIndex(automationExercise.geburtsdatumMonatSelect, 10);
        Driver.selectByValue(automationExercise.geburtsdatumJahrSelect, "1991");
        extentTest.info("zur Registration wurde der Titel angekruezt und Passwort und," +
                " Geburtsdatum wurden eingegeben.");

        String firstNameFaker = faker.name().firstName();
        String lastNameFaker = faker.name().lastName();
        String companyFaker = faker.company().name();
        String adresseFaker = faker.address().fullAddress();
        String country = "Canada";
        String stateFaker = faker.address().state();
        String cityFaker = faker.address().city();
        String zipCode = faker.address().zipCode();
        String phoneFaker = faker.phoneNumber().phoneNumber();


        actions.click(automationExercise.vornameTextBox)
                .sendKeys(firstNameFaker, Keys.TAB, lastNameFaker, Keys.TAB, companyFaker, Keys.TAB, adresseFaker,
                        Keys.TAB, Keys.TAB, country, Keys.TAB, stateFaker, Keys.TAB, cityFaker, Keys.TAB, zipCode,
                        Keys.TAB, phoneFaker)
                .perform();

        Driver.wait(2);
        extentTest.info("zur Registration wurden die erforderlichen Daten eingegeben.");

        automationExercise.kontoErstellenSchaltfläche.click();
        extentTest.info("Es wurde auf die Schaltfläche „Create Account button“ geklickt.");


        Driver.wait(2);
        automationExercise.accountCreatedText.isDisplayed();
        extentTest.info("Es wurde überprüft, dass 'ACCOUNT CREATED!' ist sichtbar.");

        automationExercise.continueSchaltflächeUnterAccountCreatedText.click();
        extentTest.info("Es wurde auf die Schaltfläche „Continue“ geklickt.");

        Driver.wait(2);
        softAssert.assertTrue(automationExercise.loggedInAsText.isDisplayed());

        int productsSize = automationExercise.brandAllProductsList.size();


        for (int i = 0; i < 3; i++) {

            int randomProduct = random.nextInt(productsSize);
            automationExercise.viewProductsList.get(randomProduct).click();
            Driver.waitAndClick(automationExercise.addToChartSchaltfläche);
            Driver.waitAndClick(automationExercise.continueShoppingSchaltfläche);
            Driver.waitAndClick(automationExercise.homeLinkHomePage);

        }

        automationExercise.cartLink.click();
        Driver.waitForVisibility(automationExercise.proceedToCheckOutSchaltfläche, 5);
        softAssert.assertTrue(automationExercise.proceedToCheckOutSchaltfläche.isDisplayed());

        automationExercise.proceedToCheckOutSchaltfläche.click();

        String actulFullName = "Mr." + " " + firstNameFaker + " " + lastNameFaker;
        String expectedFullName = automationExercise.firstAndLastNameUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actulFullName, expectedFullName);

        String actulCompany = companyFaker;
        String expectedCompany = automationExercise.companyUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actulCompany, expectedCompany);

        String actualAdresse = adresseFaker;
        String expectedAdresse = automationExercise.adresseUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actualAdresse, expectedAdresse);


        String actualCountry = country;
        String expectedCountry = automationExercise.countryUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actualCountry, expectedCountry);

        String actualCityStateZipCode = cityFaker + " " + stateFaker + " " + zipCode;
        String expectedCityStateZipCode = automationExercise.cityStateZipCodeUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actualCityStateZipCode, expectedCityStateZipCode);

        String actualPhoneNummer = phoneFaker;
        String expectedPhoneNummer = automationExercise.phoneUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actualPhoneNummer, expectedPhoneNummer);

        //=======================

        String actulFullName2 = "Mr." + " " + firstNameFaker + " " + lastNameFaker;
        String expectedFullName2 = automationExercise.firstAndLastNameUnterAdresseDetailsVonBilligAdresse.getText();
        softAssert.assertEquals(actulFullName, expectedFullName);

        String actulCompany2 = companyFaker;
        String expectedCompany2 = automationExercise.companyUnterAdresseDetailsVonBilligAdresse.getText();
        softAssert.assertEquals(actulCompany, expectedCompany);

        String actualAdresse2 = adresseFaker;
        String expectedAdresse2 = automationExercise.adresseUnterAdresseDetailsVonBilligAdresse.getText();
        softAssert.assertEquals(actualAdresse, expectedAdresse);


        String actualCountry2 = country;
        String expectedCountry2 = automationExercise.countryUnterAdresseDetailsVonDeliveryAdresse.getText();
        softAssert.assertEquals(actualCountry, expectedCountry);

        String actualCityStateZipCode2 = cityFaker + " " + stateFaker + " " + zipCode;
        String expectedCityStateZipCode2 = automationExercise.cityStateZipCodeUnterAdresseDetailsVonBilligAdresse.getText();
        softAssert.assertEquals(actualCityStateZipCode, expectedCityStateZipCode);

        String actualPhoneNummer2 = phoneFaker;
        String expectedPhoneNummer2 = automationExercise.phoneUnterAdresseDetailsVonBilligAdresse.getText();
        softAssert.assertEquals(actualPhoneNummer, expectedPhoneNummer);


        automationExercise.deleteAccountLink.click();

        softAssert.assertFalse(automationExercise.deleteAccountText.isDisplayed());
        extentTest.fail("Es wurde festgestellt, dass 'ACCOUNT DELETED!'  nicht sichtbar ist.");

        softAssert.assertAll();


    }


}
