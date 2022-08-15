import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.*;

public class GMXServiceTest {

    private static final String GMX_URL = "https://gmx.com";
    private WebDriver driver;
    private POFactory poFactory;
    GMXLoginPage gmxLoginPage;
    GMXMailBoxPage gmxMailBoxPage;

    @BeforeClass
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        poFactory = new POFactory(driver);
        gmxLoginPage = poFactory.getPage(GMXLoginPage.class);
        driver.get(GMX_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Parameters({"correctUsername", "correctPassword"})
    @Test
    public void testLogInWithCorrectCredentials(String username, String password) {
        gmxLogIn(username, password);
        gmxMailBoxPage = poFactory.getPage(GMXMailBoxPage.class);
        gmxMailBoxPage.waitForPageLoadComplete(10);
        driver.switchTo().frame(gmxMailBoxPage.getHomeIframe());
        gmxMailBoxPage.waitVisibilityOfElement(10, gmxMailBoxPage.getUserinfoSpan());
        assertEquals(gmxMailBoxPage.getUserinfoSpan().getText(), "Advanced Prototype");

    }

    @Parameters({"username", "password"})
    @Test
    public void testLogInWithWrongCredentials(String username, String password) {
        gmxLogIn(username, password);
        gmxLoginPage.waitVisibilityOfElement(10, gmxLoginPage.getErrorMessage());
        assertTrue(gmxLoginPage.getErrorMessage().getText().contains("invalid email address / password combination"));
    }

    private void gmxLogIn(String username, String password) {
        driver.switchTo().frame(gmxLoginPage.getFirstIframe());
        driver.switchTo().frame(gmxLoginPage.getSecondIframe());
        gmxLoginPage.waitVisibilityOfElement(10, gmxLoginPage.getAgreeButton());
        gmxLoginPage.getAgreeButton().click();
        gmxLoginPage.waitVisibilityOfElement(10, gmxLoginPage.getLogInIcon());
        gmxLoginPage.getLogInIcon().click();
        gmxLoginPage.waitVisibilityOfElement(10, gmxLoginPage.getLogInButton());
        gmxLoginPage.getEmailInput().sendKeys(username);
        gmxLoginPage.getPasswordInput().sendKeys(password);
        gmxLoginPage.getLogInButton().click();
    }
}
