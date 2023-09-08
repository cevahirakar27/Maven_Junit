package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilices.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {
    // https://www.teknosa.com/ adresine gidin
   // arama cubuguna oppo yazip enter'a basınız
   // sonuc yazısını yazdiriniz
   // ilk urunun fotografını cekin
   // cikan ilk urune tiklayiniz
   // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
   // sepete ekleyiniz
   // sepetim'e git tilayiniz
   // "Siparis Ozeti" webelementinin text'ini yazdiriniz
   // Alisverisi tamamlayiniz
   // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz


    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        WebElement cookies = driver.findElement(By.xpath("(//*[@class='ins-editable ins-element-editable'])[3]"));
        try {
            cookies.click();
        } catch (Exception e) {
            System.out.println("Cookies bulunamadi");
        }


        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.id("search-input")).sendKeys("oppo"+ Keys.ENTER);
        bekle(1);

        // sonuc yazısını yazdiriniz.
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1[@class='plp-title']"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText());

        // ilk urunun fotografını cekin.
        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddhhmmss");
        String tarih = date.format(dtf);

        String dosyaYolu = "target/webElementEkranGoruntusu/ilkUrun "+tarih+".png";
        FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        bekle(1);

        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin.
        WebElement sepeteEkle = driver.findElement(By.xpath("//*[@id='addToCartButton']"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // sepete ekleyiniz
        sepeteEkle.click();
        bekle(2);

        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        bekle(2);


        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println(siparisOzeti.getText());
        bekle(3);


        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        bekle(3);



        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement teknosayaHosgeldiniz = driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println(teknosayaHosgeldiniz.getText());

    }


    }

