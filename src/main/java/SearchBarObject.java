import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBarObject {
    public WebDriver driver;
    private final Wait<WebDriver> wait;

    @FindBy(name = "q")
    private WebElement searchBar;

    public SearchBarObject(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void search(String text) throws InterruptedException{
        searchBar.sendKeys(text, Keys.ENTER);
        Thread.sleep(3000);
    }

    public boolean currentTitle(String title){
        System.out.println(driver.getTitle());
        return driver.getTitle().equals(title);

    }

    public boolean currentURL(String url){
        return driver.getCurrentUrl().contains(url);
    }



}
