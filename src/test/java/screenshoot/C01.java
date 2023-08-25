package screenshoot;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilices.TestBase;

import java.io.File;
import java.io.IOException;

public class C01 extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazona gidelim ekran resmini alalim.
        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "target/amazon.jpg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {

        //facebok a gidelim. ekran resmini alalim.

        driver.get("https://www.facebook.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu ="target/facebook.jpg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
