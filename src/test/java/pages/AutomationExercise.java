package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExercise {


    public AutomationExercise() {
        PageFactory.initElements(Driver.getDriver(), this);
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
    public WebElement kontrollKästchenSignUpForOurNewsletter;

    @FindBy(id = "optin")
    public WebElement kontrollKästchenReceiveSpecialOffersFromOurPartners;

    @FindBy(id = "first_name")
    public WebElement vornameTextBox;

    @FindBy(id = "last_name")
    public WebElement nachnameTextBox;

    @FindBy(id = "company")
    public WebElement firmaTextBox;

    @FindBy(id = "address1")
    public WebElement adresse1TextBox;

    @FindBy(xpath = "//Input[@id='address2']")
    public WebElement adresse2TextBox;

    @FindBy(id = "country")
    public WebElement landSelect;

    @FindBy(id = "state")
    public WebElement bundeslandTextBox;

    @FindBy(id = "city")
    public WebElement stadtTextBox;

    @FindBy(id = "zipcode")
    public WebElement postleitzahlTextBox;

    @FindBy(id = "mobile_number")
    public WebElement handyNummerTextBox;

    @FindBy(xpath = "(//button[@class='btn btn-default'])[1]")
    public WebElement kontoErstellenSchaltfläche;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(linkText = "Continue")
    public WebElement continueSchaltflächeUnterAccountCreatedText;


    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedInAsText;

    @FindBy(xpath = "(//*[.=' Delete Account'])[1]")
    public WebElement deleteAccountLink;

    @FindBy(xpath = "//div[@class='page-header']")
    public WebElement deleteAccountText;

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
    public WebElement dateiAuswählenSchaltfläche;

    @FindBy(xpath = "//input[@class='btn btn-primary pull-left submit_form']")
    public WebElement submitSchaltfläche;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement successYourDetailsHaveBeenSubmittedSuccessfullyText;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElement homeSchaltflächeUnterGetInTouch;

    @FindBy(xpath = "//I[@class='fa fa-envelope']")
    public WebElement contactUsLink;

    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement featuresItemsText;

    @FindBy(xpath = "(//i[@class='fa fa-list'])[1]")
    public WebElement testCasesLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement testCasesText;

    @FindBy(xpath = "//i[@class='material-icons card_travel']")
    public WebElement productsLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement allProductsText;

    @FindBy(xpath = "(//i[@class='fa fa-plus-square'])[1]")
    public WebElement viewProductLinkFirstProduct;

    @FindBy(xpath = "(//p[.='Blue Top'])[1]")
    public WebElement productNameFirstProduct;

    @FindBy(xpath = "(//p[.='Men Tshirt'])[1]")
    public WebElement productNameSecondProduct;

    @FindBy(xpath = "//p[.='Category: Women > Tops']")
    public WebElement productCategoryFirstProduct;

    @FindBy(xpath = "(//h2[.='Rs. 500'])[1]")
    public WebElement productPriceFirstProduct;

    @FindBy(xpath = "(//h2[.='Rs. 400'])[1]")
    public WebElement productPriceSecondProduct;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement quantityBox;

    @FindBy(xpath = "//label[.='Quantity:']")
    public WebElement quantityText;


    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement addToChartSchaltfläche;

    @FindBy(xpath = "//b[.='Availability:']")
    public WebElement productAvailabilityFirstProduct;

    @FindBy(xpath = "//b[.='Condition:']")
    public WebElement productConditionFirstProduct;

    @FindBy(xpath = "//b[.='Brand:']")
    public WebElement productBrandFirstProduct;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchProductBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchProductSchaltfläche;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement searchedProductsText;

    @FindBy(xpath = "(//p[.='Premium Polo T-Shirts'])[1]")
    public WebElement poloProductText;

    @FindBy(xpath = "//h2[.='Subscription']")
    public WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    public WebElement eMailAdresseBoxUnterSubscription;

    @FindBy(xpath = "//i[@class='fa fa-shopping-cart']")
    public WebElement cartLink;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[1]")
    public WebElement addToCartFirstProduct;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingSchaltfläche;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[3]")
    public WebElement addToCartSecondProduct;

    @FindBy(xpath = "//U[.='View Cart']")
    public WebElement viewCartLinkUnterAdded;

    @FindBy(xpath = "//div[@class='footer-widget']")
    public WebElement footPage;

    @FindBy(className = "choose")
    public List<WebElement> viewProductsList;


    @FindBy(className = "disabled")
    public WebElement quantityProduct;


    @FindBy(xpath = "//a[.='Proceed To Checkout']")
    public WebElement proceedToCheckOutSchaltfläche;

    @FindBy(className = "form-control")
    public WebElement commentBox;

    @FindBy(xpath = "//a[.='Place Order']")
    public WebElement placeOrderSchaltfläche;


    @FindBy(xpath = "(//p[@class='text-center'])[2]")
    public WebElement registerLogInUnterCheckOut;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement nameOnCardzurBezahlung;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement homeLinkHomePage;

    @FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[1]")
    public WebElement firstAndLastNameUnterAdresseDetails;

    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[1]")
    public WebElement companyUnterAdresseDetails;

    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[2]")
    public WebElement adresseUnterAdresseDetails;

    @FindBy(xpath = "(//li[@class='address_city address_state_name address_postcode'])[1]")
    public WebElement cityStateZipCodeUnterAdresseDetails;

    @FindBy(xpath = "(//li[@class='address_country_name'])[1]")
    public WebElement countryUnterAdresseDetails;

    @FindBy(xpath = "(//li[@class='address_phone'])[1]")
    public WebElement phoneUnterAdresseDetails;

    // @FindBy (xpath = "")
    // public WebElement YourOrderHasBeenPlacedSuccessfullyText;

    @FindBy(className = "cart_quantity_delete")
    public WebElement xSchaltflächeUnterProceedToCheckOut;

    @FindBy(className = "active")
    public WebElement shoppingCartText;

    @FindBy(xpath = "//b[.='Cart is empty!']")
    public WebElement cartIsEmptyText;

    @FindBy(xpath = "//div[@class='panel panel-default']//i")
    public List<WebElement> kategorienList;

    @FindBy(xpath = "//div[@id='Women']//div[@class='panel-body']//a")
    public List<WebElement> anyCategoryLinkUnderWomenCategory;

    @FindBy(xpath = "//div[@id='Men']//div[@class='panel-body']//a")
    public List<WebElement> anyCategoryLinkUnderMenCategory;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement womenDressTopsSaareeTitleText;


    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked']//a")
    public List<WebElement> brandsList;

    @FindBy(xpath = "(//a[.='Dress '])[1]")
    public WebElement dressLink;

    @FindBy(xpath = "//h2[.='Women - Dress Products']")
    public WebElement womenDressProductsText;

    @FindBy(xpath = "(//span[@class='badge pull-right'])[1]")
    public WebElement categoryWomenLink;

    @FindBy(xpath = "(//span[@class='badge pull-right'])[2]")
    public WebElement categoryMenLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement menTshirtJeansProductTitleText;

    @FindBy(xpath = "//a[.='Tshirts ']")
    public WebElement tshirtsMenLink;

    @FindBy(xpath = "//h2[text()='Women - Tops Products']")
    public WebElement womenTopsProductsText;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

    // @FindBy (xpath = "")
    // public WebElement xxxxx;

}
