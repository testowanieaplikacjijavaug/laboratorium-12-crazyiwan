import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFactory {
    public WebDriver driver;
    private final Wait<WebDriver> wait;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public LoginFactory(WebDriver driver, String siteURL) {
        this.driver = driver;
        driver.get(siteURL);
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver,this);

    }

    public void login(String myEmail, String myPassword){
        email.sendKeys(myEmail);
        password.sendKeys(myPassword, Keys.ENTER);

    }

    public boolean loginError(String error){
       return driver.getPageSource().contains(error);

    }

}
