package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_File extends TestBase {

    //https://the-internet.herokuapp.com/download adresine gidelim.
    // dummy.txt dosyasini indirelim.
    // dosyanin basariyla indirilip  indirilmedigini test edelim.


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        String farkliYol = System.getProperty("user.home");
        String ortakYol = "\\Downloads\\dummy (2).pdf";

        String dosyaYolu = farkliYol+ortakYol;

        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.out.println("Dosya bulunmadi");
        }
        // dummy.txt dosyasini indirelim.
        WebElement dummy = driver.findElement(By.xpath("//*[.='dummy (2).pdf']"));
        dummy.click();
        bekle(5);

        // dosyanin basariyla indirilip  indirilmedigini test edelim.

        // "C:\Users\DELL\Downloads\dummy (2).pdf"

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
