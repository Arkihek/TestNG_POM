package tests.Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Q01_TestNotation {

    @Test
    public void ahmet(){
        System.out.println("Ahmet");
    }
    @Test (priority = -1)
    public void sevda(){
        System.out.println("Sevda");
    }
    @Test (priority = 30)
    public void esat (){
        System.out.println("Esat");
    }
    @Test
    public void yusuf(){
        System.out.println("Yusuf");
    }
    @Test
    public void ilknur(){
        System.out.println("İlknur");
    }
    @Test (dependsOnMethods = "ilknur")
    public void murat(){
        System.out.println("Murat Metin");
    }
}
