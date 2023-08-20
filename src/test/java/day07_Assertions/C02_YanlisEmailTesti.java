package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_YanlisEmailTesti {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void ternDown(){
       // driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(1000);

        //siteye gitmiyor sonra yine bak
    }
}
