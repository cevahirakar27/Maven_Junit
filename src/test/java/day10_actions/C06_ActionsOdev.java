package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

public class C06_ActionsOdev extends TestBase {

    //http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    //-Çıkan alert'te iptal butonuna basınız
    //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    //-Çıkan mesajı konsola yazdırınız
    //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız


    @Test
    public void test01() {
        //http://demo.automationtesting.in/Alerts.htmlc sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        bekle(1);

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();
        bekle(1);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        bekle(1);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız.
        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        bekle(1);

        driver.findElement(By.xpath("//*[text()='click the button to display a confirm box ']")).click();

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        bekle(1);


        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız.
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        bekle(1);
        driver.findElement(By.xpath("//*[text()='click the button to demonstrate the prompt box ']")).click();
        bekle(1);



        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız.
        driver.switchTo().alert().sendKeys("CEVAHIR");
        bekle(1);
        driver.switchTo().alert().accept();
        bekle(1);

        //-Çıkan mesajı konsola yazdırınız.
        WebElement sonucyazisi = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println("SONUC YAZİSİ : " +sonucyazisi.getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello CEVAHIR How are you today",sonucyazisi.getText());
    }
}
