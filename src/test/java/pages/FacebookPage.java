package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id="email")
    public WebElement postaKutusu;

    @FindBy(id="pass")
    public WebElement sifreKutusu;

    @FindBy(name = "login")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement hataMesaji;
}
