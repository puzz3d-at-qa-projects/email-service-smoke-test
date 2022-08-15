import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginYahooPage extends BasePage {

    @FindBy(id = "#login-username")
    @CacheLookup
    private WebElement usernameInput;

    @FindBy(id = "#login-passwd")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(id = "#login-signin")
    @CacheLookup
    private WebElement logInButton;

    public LoginYahooPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
