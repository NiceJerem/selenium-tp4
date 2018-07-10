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
        2.	Ouvrir le lien “Nintendo Switch” qui se trouve dans le menu Parcourir categories -> Jeux Videos et consoles
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
/*
        WebElement page =  driver.findElement(By.className("bxw-pageheader__title__subtext"));
        WebElement h1Element =  page.findElement(By.tagName("h1"));
        Assert.assertThat(h1Element.getText(), Is.is("LIVRES"));
        System.out.println(" Text :"+h1Element.getText());
        */
    }


    @After
    public void tearDown()
    {
        //driver.quit();
    }
}

