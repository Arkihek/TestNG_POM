package tests.day13_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NutellaAramaTesti {

    @Test
    public void nutellaAramaTest() {

        // amazon ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime") + Keys.ENTER);

        // sonuclarin nutella icerdigini test edin
        String expectedIcerik = ConfigReader.getProperty("amazonArananKelime");
        String actualIcerik = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        // sayfayi kapatin
        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
}
