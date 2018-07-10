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
        /*
        3.	Ouvrir la categorie Jeux
        4.	Dans la liste de resultats, ouvrir le N1 de ventes (Mario Kart)
        5.	Ajouter le jeu au panier
        6.	Ouvrir le panier
        7.	Changer la quantité a 2
        8.	Vérifier que le prix est de EUR 99,98
        */
        String idDivMenu="nav-link-shopall";
        WebElement divMenu =  driver.findElement(By.id(idDivMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(divMenu);
        WebDriverWait wait = new WebDriverWait(driver,5);
        actions.build().perform();
        WebElement span = driver.findElement(By.cssSelector("span[data-nav-panelkey=\"VideogamesConsolesPanel\"]"));//data-nav-panelkey="VideogamesConsolesPanel"
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
        WebElement btnViewCart =  driver.findElement(By.id("hlb-view-cart-announce"));
        btnViewCart.click();

        WebElement comboQte =  driver.findElement(By.id("a-autoid-0"));
        comboQte.click();
        WebElement drop = driver.findElement(By.id("a-popover-1"));//By.xpath("//a[text()=\"2\"]"));
        //WebElement qte2 = drop.findElement(By.id("dropdown2_1"));//////a[data-value="{"stringVal":"2"}"]
        String hidden= drop.getAttribute("aria-hidden");
        System.out.println("hidden :"+hidden);
        WebElement qte2 = drop.findElement(By.linkText("2"));
        //data-value="{"stringVal":"2"}"
        actions.moveToElement(qte2);
        actions.click();
        actions.build().perform();

        WebElement result =  driver.findElement(By.id("sc-subtotal-amount-activecart"));
        System.out.println(result.getText());
        wait.until(ExpectedConditions.textToBe(By.id("sc-subtotal-amount-activecart"),"EUR 99,98"));
        result =  driver.findElement(By.id("sc-subtotal-amount-activecart"));
        Assert.assertThat(result.getText(),Is.is("EUR 99,98"));
        System.out.println("OK");


    }


    @After
    public void tearDown()
    {
        //driver.quit();
    }
}

