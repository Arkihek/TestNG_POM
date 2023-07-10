package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.ConfigReader;

public class C03_ConfigReader {

    @Test
    public void configReaderTest(){

        System.out.println(ConfigReader.getProperty("amazonUrl")); // https://www.amazon.com

        System.out.println(ConfigReader.getProperty("wiseurl")); // null
        // key yanlis yazilirsa configreader`daki properties objesi
        // yanlis yazilan key`i bulamaz ve null doner

        System.out.println(ConfigReader.getProperty("kullaniciAdi")); // rahmet

        System.out.println(ConfigReader.getProperty("password")); // 123456


    }
}
