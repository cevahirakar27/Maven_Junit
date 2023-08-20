package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilices.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //cizili alan uzerinde sag click yapalim
        Actions action = new Actions(driver);
        WebElement ciziliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        action.click(ciziliAlan).perform();

        //alertte cikan yazinin "You selected a context menu" oldugunu test edelim
     //   String expected="You selected a context menu";
       // String actualYzi= driver.switchTo().alert().getText();
        //Assert.assertEquals(expected,actualYzi);

        //tamam diyerek alerti kapatalim
     //   driver.switchTo().alert().accept();


        //elemental selenıum linkine tiklayalim.
        WebElement elementalSeleniumLinki= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
      String ilkSayfaWHDegeri= driver.getWindowHandle();
        elementalSeleniumLinki.click();

        Set<String>handleSeti= driver.getWindowHandles();
        String ikinciSayfaWHDegeri= "";
        System.out.println(handleSeti);
        for (String w: handleSeti){
            if (!w.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri=w;
            }

        }


        //acilan sayfada h1 taginda "Elemental Selenium" yazdigini
        //test edelim
        driver.switchTo().window(ikinciSayfaWHDegeri);

        WebElement yaziElementi= driver.findElement(By.xpath("//div[@class='navbar__inner']"));
        String expectedYazi="Elemental Selenium";
        String actualYazi= yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);







    }

}
