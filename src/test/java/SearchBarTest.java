
import static org.junit.jupiter.api.Assertions.*;

import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SearchBarTest {

    private static WebDriver driver;
    private SearchBarObject page;

    @BeforeAll
    public static void setup() throws Exception {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void testSearchRedditURL() throws Exception {
        page = new SearchBarObject(driver, "https://www.reddit.com");
        page.search("ziemniaki");
        assertTrue(page.currentURL("https://www.reddit.com/search/?q=ziemniaki"));
    }

    @Test
    public void testSearchInteriaURL() throws Exception {
        page = new SearchBarObject(driver, "https://interia.pl");
        page.search("ziemniaki");
        assertTrue(page.currentURL("https://szukaj.interia.pl/internet/?q=ziemniaki"));
    }

    @Test
    public void testSearchInteriaGetTitle() throws Exception {
        page = new SearchBarObject(driver, "https://interia.pl");
        page.search("pomidory");
        assertTrue(page.currentTitle("Pomidory - szukaj.interia.pl"));
    }


    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }



}

