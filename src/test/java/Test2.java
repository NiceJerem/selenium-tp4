import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

    WebDriver driver;
    @Test
    public void t1()
    {
        driver = new ChromeDriver();
        driver.get("http://www.google.fr");
        driver.quit();
    }
}

