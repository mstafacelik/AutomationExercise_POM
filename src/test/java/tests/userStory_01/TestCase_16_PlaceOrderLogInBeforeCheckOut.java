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

import java.util.Random;

public class TestCase_16_PlaceOrderLogInBeforeCheckOut extends TestBaseRapor {

    AutomationExercise automationExercise;
    SoftAssert softAssert;
    Random random;
    Faker faker;
    Actions actions;

    @Test
    public void placeOrderLogInBeforeCheckOut(){

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


        softAssert.assertTrue(automationExercise.logoAutomationExercise.isDisplayed());
        extentTest.info("Es wurde überprüft, dass die Startseite erfolgreich sichtbar ist.");


        automationExercise.signupLoginLink.click();

        automationExercise.logInEMailAdresseBox
                .sendKeys(ConfigReader.getProperty("AECorrectEmailAdresse"),
                        Keys.TAB + ConfigReader.getProperty("AECorrectPassword"), Keys.TAB, Keys.ENTER);


        softAssert.assertTrue(automationExercise.loggedInAsText.isDisplayed());

        int productsSize = automationExercise.viewProductsList.size();


        for (int i = 0; i < 3; i++) {

            int randomProduct = random.nextInt(productsSize);
            automationExercise.viewProductsList.get(randomProduct).click();
            Driver.waitAndClick(automationExercise.addToChartSchaltfläche);
            Driver.waitAndClick(automationExercise.continueShoppingSchaltfläche);
            Driver.waitAndClick(automationExercise.homeLinkHomePage);

        }

        automationExercise.cartLink.click();

        softAssert.assertTrue(automationExercise.proceedToCheckOutSchaltfläche.isDisplayed());

        automationExercise.proceedToCheckOutSchaltfläche.click();

        String firstNameFaker = faker.name().firstName();
        String lastNameFaker = faker.name().lastName();
        String companyFaker = faker.company().name();
        String adresseFaker = faker.address().fullAddress();
        String country = "Canada";
        String stateFaker = faker.address().state();
        String cityFaker = faker.address().city();
        String zipCode = faker.address().zipCode();
        String phoneFaker = faker.phoneNumber().phoneNumber();


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


        automationExercise.commentBox
                .sendKeys(ConfigReader.getProperty("AECommentWhileCheckout"), Keys.TAB, Keys.ENTER);


        String creditCardnummer = faker.finance().creditCard();
        String creditCardnummerOhneMinus = creditCardnummer.replaceAll("-", "");

        String cvc = random.nextInt(99, 999) + "";

        automationExercise.nameOnCardzurBezahlung
                .sendKeys((CharSequence) faker.name().fullName(),
                        Keys.TAB, creditCardnummerOhneMinus,
                        Keys.TAB, cvc,
                        Keys.TAB, "02",
                        Keys.TAB, "2025",
                        Keys.TAB, Keys.ENTER);


        // softAssert.assertTrue(automationExercise.YourOrderHasBeenPlacedSuccessfullyText.isDisplayed());
        //  YourOrderHasBeenPlacedSuccessfullyText -->>nimm locate

        automationExercise.deleteAccountLink.click();
        extentTest.info("Es wurde auf die Schaltfläche „Delete Account“ geklickt.");


        softAssert.assertFalse(automationExercise.deleteAccountText.isDisplayed());
        extentTest.fail("Es wurde festgestellt, dass 'ACCOUNT DELETED!'  nicht sichtbar ist.");

        softAssert.assertFalse(automationExercise.optionsButton.isDisplayed());
        extentTest.fail("Es wurde festgestellt, dass es keine Schaltfläche „Continue“ gibt." +
                "Deswegen  konnte drauf nicht geklickt werden.");






        softAssert.assertAll();







    }
}
