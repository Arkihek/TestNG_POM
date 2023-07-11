package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_QDNegativeLoginTesti {

    // 1- https://www.qualitydemy.com/ anasayfasina gidin
    // 2- login linkine basin
    // 3- Kullanvalid 3 farkli test method’u olusturun.
    // - gecerli username, gecersiz password
    // - gecersiz username, gecerli password
    // - gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test(groups = "smoke")
    public void gecersizPasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemy = new QualitydemyPage();

        qualitydemy.loginButon.click();

        qualitydemy.emailBox.sendKeys(ConfigReader.getProperty("qdID"));
        qualitydemy.passwordBox.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemy.loginBox.click();

        Assert.assertTrue(qualitydemy.emailBox.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void gecersizUsernameTest(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButon.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdGecersizID"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdPassword"));
        qualitydemyPage.loginBox.click();

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void gecersizUsernameVePasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButon.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdGecersizID"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginBox.click();

        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }


}
