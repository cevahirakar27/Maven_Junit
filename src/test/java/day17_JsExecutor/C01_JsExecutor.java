package day17_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

public class C01_JsExecutor extends TestBase {
    @Test
    public void test01() {

        //amazon sayfasına gidelim.
        // sell butonuna click yapalım.

        driver.get("https://www.amazon.com");

        WebElement sellButonu = driver.findElement(By.xpath("//*[.='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellButonu);

    }
}
