import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFactoryTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() throws Exception{
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void testInteria() throws Exception{
        LoginFactory github = new LoginFactory(driver, "https://poczta.interia.pl/");
        github.login("test@interia.pl", "123");
        assertTrue(github.loginError("error"));
    }

    @Test
    public void testWpEmail() throws Exception{
        LoginFactory wp = new LoginFactory(driver, "https://stackoverflow.com/users/login");
        wp.login("test@gmail.com", "123");
        assertTrue(wp.loginError("error"));
    }

}
