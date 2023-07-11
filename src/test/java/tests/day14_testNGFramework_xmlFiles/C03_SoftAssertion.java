package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_SoftAssertion {

    @Test(groups = "mini regression1")
    public void nutellaTesti(){

        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // 1 - Soft Assert kullanmak icin obje olusturmaliyiz
        SoftAssert softAssert = new SoftAssert();

        // 2- Istedigimiz tum testleri Soft Assert objesini kullanarak yapin
        // title`in best icermedigini test edin
        String unExpectedIcerik = "best";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertFalse(actualTitle.contains(unExpectedIcerik),"Title istenmeyen icerik barindiriyor");

        //  url`in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farkli");

        // Nutella aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime") + Keys.ENTER);

        // arama sonuclarinin nutella icerdigini test edin
        String actualIcerik = amazonPage.sonucYaziElementi.getText();
        String expectedIcerik = "Nutella";

        softAssert.assertTrue(actualIcerik.contains(expectedIcerik),"Sonuclar Nutella icermiyor");

        // 3- Tum testlerimiz bittiginde
        //    softAssert objesinin not aldigi hatalari raporlamasini isteyelim

        softAssert.assertAll();

        /*
            softAssert.assertAll(); komutu
            yukarida yapilan tum testleri raporlar
            ve
            failed olan herhangi bir assertion varsa
            AssertionError verip calismayi durdurur.

            ancak tum hatalari assertAll() satirinda verir
            hatalarin yerini bulmamiz ve duzeltmemiz icin
            softAssert ile yapilan assertion`larda
            Mutlaka aciklama yazilmalidir.
         */

        Driver.closeDriver();

    }
}
