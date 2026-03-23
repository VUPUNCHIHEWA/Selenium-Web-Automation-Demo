import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Go to site
            driver.get("https://www.saucedemo.com/");

            // 2. Fill Username and Password(By using Locators)
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            // 3. Click Login button
            driver.findElement(By.id("login-button")).click();

            // 4. Examine the login is successful
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            if (driver.getCurrentUrl().equals(expectedUrl)) {
                System.out.println("Login Test Passed!");
            } else {
                System.out.println("Login Test Failed!");
            }

        } finally {
            // Close the Browser
            driver.quit();
        }
    }
}
