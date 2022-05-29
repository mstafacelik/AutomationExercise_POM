package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercise {


    public AutomationExercise(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='logo pull-left']")
    public WebElement logoAutomationExercise;

    @FindBy(xpath = "(//*[.=' Signup / Login'])[1]")
    public WebElement signupLoginLink;

    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement newUserSignUpText;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement newUserNameBox;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement newUserEMailAdresseBox;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement logInEMailAdresseBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement logInPasswordBoxHomePage;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement loginSchaltfläche;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement signUpSchaltfläche;

    @FindBy(xpath = "//b[.='Enter Account Information']")
    public WebElement enterAccountInfotmationText;

    @FindBy(id = "id_gender1")
    public WebElement radioTitleMr;

    @FindBy(id = "password")
    public WebElement paswordBoxZumKontoErstellen;

    @FindBy(id = "days")
    public WebElement geburtsdatumTagSelect;

    @FindBy(id = "months")
    public WebElement geburtsdatumMonatSelect;

    @FindBy(id = "years")
    public WebElement geburtsdatumJahrSelect;

    @FindBy(id = "newsletter")
    public WebElement  kontrollKästchenSignUpForOurNewsletter;

    @FindBy(id = "optin")
    public WebElement  kontrollKästchenReceiveSpecialOffersFromOurPartners;

    @FindBy(id = "first_name")
    public WebElement  vornameTextBox;

    @FindBy(id = "last_name")
    public WebElement  nachnameTextBox;

    @FindBy(id = "company")
    public WebElement  firmaTextBox;

    @FindBy(id = "address1")
    public WebElement   adresse1TextBox;

    @FindBy(xpath = "//Input[@id='address2']")
    public WebElement   adresse2TextBox;

    @FindBy(id = "country")
    public WebElement  landSelect;

    @FindBy(id = "state")
    public WebElement  bundeslandTextBox;

    @FindBy(id = "city")
    public WebElement  stadtTextBox;

    @FindBy(id = "zipcode")
    public WebElement postleitzahlTextBox ;

    @FindBy(id = "mobile_number")
    public WebElement handyNummerTextBox ;

    @FindBy(xpath = "(//button[@class='btn btn-default'])[1]")
    public WebElement kontoErstellenSchaltfläche ;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(linkText = "Continue")
    public WebElement continueSchaltflächeFürLöschen;


    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedInAsText;

    @FindBy(xpath = "(//*[.=' Delete Account'])[1]")
    public  WebElement deleteAccountLink;

    @FindBy(xpath = "//div[@class='page-header']")
    public  WebElement deleteAccountText;

    @FindBy(xpath = "//button[@class='btn btn-primary js-tooltip']")
    public WebElement optionsButton;

    @FindBy(xpath = "//p[.='Email Address already exist!']")
    public WebElement eMailAdresseBereitsVergebenText;

    @FindBy(xpath = "//h2[.='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//*[.='Your email or password is incorrect!']")
    public WebElement yourEmailOrPasswordIsIncorrectText;

    @FindBy(partialLinkText = "//I[@class='fa fa-lock']")
    public WebElement logOutLink;

    @FindBy(xpath = "(//h2[@class='title text-center'])[2]")
    public WebElement contactUsLinkgetInTouchText;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement nameBoxUnterGetInTouch;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement  dateiAuswählenSchaltfläche;

    @FindBy(xpath = "//input[@class='btn btn-primary pull-left submit_form']")
    public WebElement  submitSchaltfläche;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement  successYourDetailsHaveBeenSubmittedSuccessfullyText;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElement  homeSchaltflächeUnterGetInTouch;

    @FindBy(xpath = "//I[@class='fa fa-envelope']")
    public WebElement contactUsLink;

    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement featuresItemsText;





}
