package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

public class C07 extends TestBase {

    @Test
    public void task06() {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        bekle(1);
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();

        // -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String metin = driver.switchTo().alert().getText();
        System.out.println("Açıklama: " + metin);
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        bekle(1);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        driver.switchTo().alert().dismiss();

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        bekle(1);
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        driver.switchTo().alert().sendKeys("TURAN");
        driver.switchTo().alert().accept();


        //Konsola Yazdır
        WebElement yazdir = driver.findElement(By.xpath("//*[@id='demo1']"));
        System.out.println("Sonuç: " + yazdir.getText());

        //İsim Doğrula
        String excepted = "Hello TURAN How are you today";
        Assert.assertEquals(excepted, yazdir.getText());
    }
}