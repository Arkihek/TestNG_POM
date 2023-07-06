package tests.day12_testNG;

import org.testng.annotations.Test;

public class C02_Priority {

    /*
        Junit`de hangi testin once calisacagini ONGOREMEYIZ ve KONTROL EDEMEYIZ
        TestNG testleri natural order`a gore calistirir.(Yani harf sirasina gore)

        Eger siralamayi degistirmek isterseniz
        test method`larina priority atayabilirsiniz

        priority default olarak 0 degerini alir ***
        ve var olan priority degerlerine gore kucukten buyuge dogru calistirir

        eger priority degeri ayni olan methodlar varsa natural order`a bakar
     */

    @Test(priority = 1)
    public void amazonTest(){
        System.out.println("Amazon");
    }

    @Test
    public void youtubeTest(){
        System.out.println("Youtube");
    }

    @Test
    public void wiseTest(){
        System.out.println("Wise");
    }
}
