import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GMXMailBoxPage extends BasePage{


    @FindBy(xpath = "//iframe[@name='home']")
    @CacheLookup
    private WebElement homeIframe;

    @FindBy(css = "a.mail_compose")
    @CacheLookup
    private WebElement composeButton;

    @FindBy(css = "span.userinfo-name")
    private WebElement userinfoSpan;


    public GMXMailBoxPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHomeIframe() {
        return homeIframe;
    }

    public WebElement getComposeButton() {
        return composeButton;
    }

    public WebElement getUserinfoSpan() {
        return userinfoSpan;
    }
}
