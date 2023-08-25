package day12_ExpilityWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilices.TestBase;

import java.time.Duration;

public class C01_Odev extends TestBase {

//3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

    //4.Remove butonuna basin.
    //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6.Add buttonuna basin
    //7.It’s back mesajinin gorundugunu test edin



    @Test
    public void test01() {

        //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Remove butonuna basin.
      WebElement remove = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        remove.click();
        bekle(2);

        //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       WebElement itIsGoneYazi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(remove.isDisplayed());


        //6.Add buttonuna basin
        WebElement addElementi = driver.findElement(By.xpath("(//*[@type='button'])[1]"));
        addElementi.click();

        //7.It’s back mesajinin gorundugunu test edin
        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
       Assert.assertTrue(itsBack.isDisplayed());


    }
}
