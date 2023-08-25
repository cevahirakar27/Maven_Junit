package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

import java.nio.file.Files;

public class C06_UploadFile extends TestBase {

    //2. https://the-internet.herokuapp.com/upload adresine
    //gidelim
    //3. chooseFile butonuna basalim
    //4. Yuklemek istediginiz dosyayi secelim.
    //5. Upload butonuna basalim.
    //6. “File Uploaded!” textinin goruntulendigini test edelim


    @Test
    public void test01() {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim.
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));


        //4. Yuklemek istediginiz dosyayi secelim.
        //"C:\Users\DELL\Desktop\B171.txt"
        String farkliYol = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\B171.txt";
        String dosyaYolu = farkliYol+ortakKisim;
        dosyaSec.sendKeys(dosyaYolu);
        bekle(3);

        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isDisplayed());

    }
}
