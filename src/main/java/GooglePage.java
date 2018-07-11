import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    WebDriver driver;

    @FindBy(name="q")
    private WebElement barreRecherche;

    @FindBy(id="hplogo")
    private WebElement logo;

    @FindBy(name="btnK")
    private WebElement btnFind;

    public GooglePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void FindWithEnter(String recherche)
    {
        barreRecherche.sendKeys(recherche + Keys.ENTER);
    }

    public void FindWithBtn(String recherche)
    {
        barreRecherche.sendKeys(recherche );
        logo.click();
        btnFind.click();
    }
}
