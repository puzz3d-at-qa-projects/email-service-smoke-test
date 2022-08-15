import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GMXLoginPage extends BasePage{

    // two iFrames and an "agree" button locators in order to close popup window
    @FindBy(xpath = "//iframe[@class = 'permission-core-iframe']")
    private WebElement firstIframe;

    @FindBy(xpath = "//iframe[contains(@src, 'plus.gmx')]")
    private WebElement secondIframe;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    @CacheLookup
    private WebElement agreeButton;

    @FindBy(xpath = "//a[@id='login-button']")
    @CacheLookup
    private WebElement logInIcon;

    @FindBy(css = "input#login-email")
    @CacheLookup
    private WebElement emailInput;

    @FindBy(css = "input#login-password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(css = ".login-submit")
    @CacheLookup
    private WebElement logInButton;

    @FindBy(xpath = "//div[contains(@class, 'error')]/div/p")
    private WebElement errorMessage;

    public GMXLoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstIframe() {
        return firstIframe;
    }

    public WebElement getSecondIframe() {
        return secondIframe;
    }

    public WebElement getAgreeButton() {
        return agreeButton;
    }

    public WebElement getLogInIcon() {
        return logInIcon;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
