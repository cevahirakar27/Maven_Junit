package day12_ExpilityWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilices.TestBase;

import java.time.Duration;

public class C02_ExpilityWait extends TestBase {

    //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2.Textbox’in etkin olmadigini(enabled) dogrulayın
    //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //5.Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void test01() {

        //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2.Textbox’in etkin olmadigini(enabled) dogrulayın.
        WebElement texbox= driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(texbox.isEnabled());


        //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin.
        WebElement enableButonu = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButonu.click();

        WebElement disable = driver.findElement(By.xpath("//*[.='Disable']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(disable));

        //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement yazi = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(yazi.isDisplayed());

        //5.Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(texbox.isEnabled());
    }
}
