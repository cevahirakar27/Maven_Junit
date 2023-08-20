package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilices.TestBase;

public class C04_ActionsOdev extends TestBase {

    //https://demoqa.com/ url'ine gidin.
//Alerts, Frame & Windows Butonuna click yap
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
//New Tab butonunun görünür olduğunu doğrula
//New Tab butonuna click yap
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
//İlk Tab'a geri dön
//New Tab butonunun görünür olduğunu doğrula


    @Test
    public void test01() {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

       //Alerts, Frame & Windows Butonuna click yap.

     WebElement kutu =   driver.findElement(By.xpath("(//div[@class='card-body'])[3]"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        kutu.click();

       //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement yaziElementi = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        bekle(1);

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap.
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButonu = driver.findElement(By.cssSelector("#tabButton"));
        Assert.assertTrue(newTabButonu.isDisplayed());
        bekle(1);

       //New Tab butonuna click yap
        newTabButonu.click();
        bekle(1);

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());  //driver i yeni pencereye gecirdik
        WebElement yazi = driver.findElement(By.cssSelector("#sampleHeading"));
        Assert.assertTrue(yazi.isDisplayed());
        bekle(1);


        //İlk Tab'a geri dön
        window(0);  //test basede method olusturp onu cagirdik  ilk pencereye geri donduk
        bekle(1);

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTabButonu.isDisplayed());
    }
}
