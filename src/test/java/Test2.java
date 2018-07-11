import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test2 {

    WebDriver driver;

    @Before
    public void beforeTest()
    {
        driver = new ChromeDriver();
        driver.get("http://www.amazon.fr");
    }

    @Test
    public void t1()
    {
        String idDivMenu="nav-link-shopall";
        WebElement divMenu =  driver.findElement(By.id(idDivMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(divMenu);
        WebDriverWait wait = new WebDriverWait(driver,5);
        actions.build().perform();
        WebElement span = driver.findElement(By.cssSelector("span[data-nav-panelkey=\"VideogamesConsolesPanel\"]"));
        wait.until(ExpectedConditions.visibilityOf(span));
        actions.moveToElement(span);
        actions.build().perform();
        WebElement link =  driver.findElement(By.xpath("//span[text()=\"Nintendo Switch\"]"));
        link.click();
        //

        //WebElement jeuxElement =  driver.findElement(By.xpath("//span[text()=\"Jeux\"]"));
        WebElement jeuxElement =  driver.findElement(By.linkText("Jeux"));
        jeuxElement.click();

        //mainResults
        WebElement results =  driver.findElement(By.id("mainResults"));
        List <WebElement> ListResults =  results.findElements(By.tagName("li"));
        ListResults.get(0).findElement(By.tagName("h2")).click();


        //add-to-cart-button
        WebElement btnAddToCart =  driver.findElement(By.id("add-to-cart-button"));
        btnAddToCart.click();

        //hlb-view-cart-announce
         driver.findElement(By.id("hlb-view-cart-announce")).click();

        driver.findElement(By.id("a-autoid-0")).click();;

        WebElement drop = driver.findElement(By.id("a-popover-1"));//By.xpath("//a[text()=\"2\"]"));
        String hidden= drop.getAttribute("aria-hidden");
        System.out.println("hidden :"+hidden);
        //-----------------------------
        // Bon Quand meme
        //WebElement qte2 = drop.findElement(By.linkText("2"));
        //actions.moveToElement(qte2).click();;
        //actions.build().perform();
        //-----------------------------
        Select quantitySelect = new Select(driver.findElement(By.name("quantity")));
        quantitySelect.selectByValue("2");
        //-----------
        WebElement result =  driver.findElement(By.id("sc-subtotal-amount-activecart"));
        System.out.println(result.getText());
        wait.until(ExpectedConditions.textToBe(By.id("sc-subtotal-amount-activecart"),"EUR 99,98"));
        result =  driver.findElement(By.id("sc-subtotal-amount-activecart"));
        //------------------------------------------------------------------------------
        FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);

        fwait.until(driver ->{
            String sousTotal = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
            return sousTotal.contains("(2 articles):");
        });

        Assert.assertThat(result.getText(),Is.is("EUR 99,98"));
        System.out.println(result.getText());
        System.out.println("OK");

    }


    @After
    public void tearDown()
    {
        //driver.quit();
    }
}

