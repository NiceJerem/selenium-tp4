import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TP5 {
    WebDriver driver;

    @Before
    public void beforeTest()
    {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @Test
    public void t1()
    {
        WebElement barre= driver.findElement(By.name("q"));
        barre.sendKeys("france"+ Keys.ENTER);
    }

    @Test
    public void t2()
    {
        GooglePage page = new GooglePage(driver);
        page.FindWithBtn("france");
    }

    @Test
    public void t3()
    {
        GooglePage page = new GooglePage(driver);
        page.FindWithEnter("france");
    }

    @After
    public void tearDown()
    {

    }

}

