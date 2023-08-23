package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilices.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

       //b10 all test cases dosyasını indirelim.
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();

       //Dosyanın başarıyla indirilip indirilmediğini test edelim

        //"C:\Users\DELL      \Downloads\b10 all test cases, code.docx"
        String farkliYol =System.getProperty("user.home");
        String ortakYol ="/Downloads/b10 all test cases, code.docx";
        String dosyaYolu = farkliYol+ortakYol;
        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));





        String farkliYol1 =System.getProperty("user.home");
        String ortakYol1 ="/Downloads/b10 all test cases, code.docx";

        String dosyaYolu1 = farkliYol+ortakYol;
    }
}
