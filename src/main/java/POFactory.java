import org.openqa.selenium.WebDriver;

public class POFactory {

    WebDriver driver;

    public POFactory(WebDriver driver) {
        this.driver = driver;
    }

    public  <T extends BasePage> T getPage (Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
