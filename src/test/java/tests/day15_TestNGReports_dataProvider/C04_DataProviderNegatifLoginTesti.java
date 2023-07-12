package tests.day15_TestNGReports_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_DataProviderNegatifLoginTesti extends TestBaseRapor {

    @DataProvider
    public static Object[][] kullaniciListesi(){
        String[][] kullaniciIsimSifreleri = {{"Sevda","12345"},{"Ihsan","1245"},{"Ahmet","121235"}};

        return kullaniciIsimSifreleri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void cokluNegatifLoginTesti(String kullaniciAdi,String password){
        extentTest = extentReports.createTest("Data Provider",kullaniciAdi+" login testi");

        // Qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Kullanici anasayfaya gider");

        // Liste olarak verilen kullanici adi ve sifreleri ile
        // giris yapilamadigini test edin.
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        // ilk login linkine tiklayin
        qualitydemyPage.loginButon.click();

        // kullanici adi ve sifresini yazip giris yapmayi deneyin
        qualitydemyPage.emailBox.sendKeys(kullaniciAdi);
        qualitydemyPage.passwordBox.sendKeys(password);
        qualitydemyPage.loginBox.click();
        extentTest.info("verilen "+kullaniciAdi+" ve sifreyi yazip login butonuna basar");

        // giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        extentTest.pass("Giris yapilamadigini test eder");


        // sayfayi kapatin
        Driver.closeDriver();
        extentTest.info("Siteyi kapatir");
    }
}
