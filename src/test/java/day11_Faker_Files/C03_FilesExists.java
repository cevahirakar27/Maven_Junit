package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import utilices.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExists {

    @Test
    public void test01() {

        /*
        Bilgisayarımızdaki bir dosyanın varlığını test edebilmemiz için;
            1-Öncelikle dosyanın yolunu almamız gerekir(Dosya üzerine sağ klik yapıp yol olarak kopyala seçeneği ile
            dosyanın yolunu kopyalayabiliriz. Windows'un alt sürümlerinde sağ klik yaptığınızda yol olarak kopyala
            seçeneği çıkmıyor ise shift tuşuna basılı olarak sağ klik yaparsanız yol olarak kopyala seçeneği çıkar)
            2-Files.exists(Paths.get(dosyaYolu)) Files class'ından exists() methodu ile dosya yolunun
            varlığını test edebiliriz. Yukarıdaki kod bize true veya false döner. Dolayısıyla
            bu kodu direk Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))) şeklinde yazarak
            dosya varsa testim passed yoksa failed olur
         */


        String dosyaYolu ="C:\\Users\\DELL\\Desktop\\B171.txt";
        // "C:\\Users\DELL\Desktop\B171.txt"

        System.out.println(Files.exists(Paths.get(dosyaYolu)));  //C:\Users\DELL


    }

    @Test
    public void test02() {
        /*
        Bir server uzerinden bir dosya yolu almak istersek , her kullanicinin bilgisayarinin  ana yolu farkli olabilir ve serverdaki dosyanin
        yolu ortaktir.dolayisiyla System.getProperty(user.home) methodu ile biligisauarin ana yolunu alabilir. server daki
        ortak yol ile bunu birlestirip dosyanin yolunu alabiliriz.
         */


        //"C:\Users\DELL\Desktop\B171.txt"
        //Test01 methodundaki gibi dosyanin yolunu dogrulayalim.
        System.out.println(System.getProperty("user.home"));   //C:\Users\DELL
        String kendiYol = System.getProperty("user.home");  // herkeste farkli olan yol.
        String ortakYol ="\\DELL\\Desktop\\B171.txt"; //serverdaki dosyanin yolu    //\DELL\Desktop\B171.txt
        System.out.println(ortakYol);
        String dosyaYolu = kendiYol+ortakYol; // --> bu sekilde dosyanin yolunu aldik.
        System.out.println(dosyaYolu);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //C:\Users\DELL   ana yol farkli yol
        //   \DELL\Desktop\B171.txt    ortak yol    --tekrar bak.yanlis oldu

    }
}
