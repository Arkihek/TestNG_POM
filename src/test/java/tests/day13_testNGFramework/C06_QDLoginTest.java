package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_QDLoginTest {

    @Test(groups = {"smoke","mini regression1","regression"})
    public void test01(){

        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin
        QualitydemyPage qualitydemy = new QualitydemyPage();
        qualitydemy.loginButon.click();

        // 3- Kullanici email’i olarak valid email girin
        qualitydemy.emailBox.sendKeys(ConfigReader.getProperty("qdID"));

        // 4- Kullanici sifresi olarak valid sifre girin

        qualitydemy.passwordBox.sendKeys(ConfigReader.getProperty("qdPassword"));

        // 5- Login butonuna basarak login olun
        qualitydemy.loginBox.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualitydemy.basariliGirisKontrolElementi.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }


}
