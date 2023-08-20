package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilices.TestBase;

public class C05_ActionsOdev extends TestBase {

    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    //- Çizimden sonra clear butonuna basınız
    //- Sayfayi kapatiniz


    @Test
    public void test01() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement cizimAlani = driver.findElement(By.xpath("//canvas[@width='831']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(cizimAlani).clickAndHold().moveByOffset(100, 100).release().perform();
        bekle(2);

        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
        bekle(2);

        //- Sayfayi kapatiniz.
        driver.close();


    }
}
