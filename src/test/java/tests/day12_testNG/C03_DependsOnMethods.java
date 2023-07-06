package tests.day12_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_DependsOnMethods {
    // amazon anasayfaya gidin
    // 3 farkli test methodu olusturup, su testleri yapin
    // 1- url`in amazon icerdigini test edin
    // 2- Nutella aratip sonucun nutella icerdigini test edin
    // 3- ilk urune click yapip, acilan sayfadaki urun isminin Nutella icerdigini test edin.

    @Test(priority = 1)
    public void urlTest(){
        Driver.getDriver().get("https://www.amazon.com");

        // 1- url`in amazon icerdigini test edin
        String expectedUrl = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(priority = 2)
    public void nutellaAramaTest(){
        // 2- Nutella aratip sonucun nutella icerdigini test edin

        WebElement aramaKutusuElement = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElement.sendKeys("Nutella" + Keys.ENTER);

        WebElement aramaSonucElement = Driver.getDriver().findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik = "Nutella";
        String actualIcerik = aramaSonucElement.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }

    @Test(priority = 3)
    public void urunIsimTest(){
        // 3- ilk urune click yapip, acilan sayfadaki urun isminin Nutella icerdigini test edin.

        Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]")).click();
        WebElement urunIsimElement = Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIsim = "Nutella";
        String actualIsim = urunIsimElement.getText();

        Assert.assertTrue(actualIsim.contains(expectedIsim));

        Driver.closeDriver();

    }
}
