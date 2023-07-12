package tests.day15_TestNGReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluNutellaTesti extends TestBaseRapor {



    @Test
    public void raporluTest(){

        extentTest = extentReports.createTest("Raporlu Nutella arama","Kullanici amazonda Nutella arayabilmeli");

        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici amazon anasayfaya gider");

        // Nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime") + Keys.ENTER);
        extentTest.info("Kullanici arama kutusuna Nutella yazip arama yapar.");

        // sonuclarin Nutella icerdigini
        String actualIcerik = amazonPage.sonucYaziElementi.getText();
        String expectedIcerik = "Kutella";


        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        extentTest.pass("Sonuclarin Nutella icerdigini test eder");

        // sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.closeDriver();


    }
}
