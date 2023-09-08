package day17_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

public class C02_JsExecutor extends TestBase {

    //amazon sayfasına gidelim
    // back to school elementine kadar scroll yapalım.


    @Test
    public void test01() {


        //amazon sayfasına gidelim.
        driver.get("https://www.amazon.com");

        // back to school elementine kadar scroll yapalım.
        WebElement backToSchool = driver.findElement(By.xpath("(//*[.='Back to school'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",backToSchool);



    }
}
