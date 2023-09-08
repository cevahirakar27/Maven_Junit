package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import utilices.TestBase;

public class C01_ScreenShot extends TestBase {

    @Test
    public void test01() {

        // amazon sayfasina gidelim.sayfanin resmini alalim

        driver.get("https://www.amazon.com");

        String dosyaYolu ="src/test/java/utilices/screenSot/ekranGoruntusu.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;

    }
}
