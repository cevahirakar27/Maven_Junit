package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void ternDown(){
        driver.close();
    }

    @Test
    public  void test01() throws InterruptedException {
        //1)  https://www.bestbuy.com/ adresine gidin

        Thread.sleep(1000);
    }


        //2) sayfa url sinin  https://www.bestbuy.com/ a esit oldugunu test edin
    @Test
                public void test02(){

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }


        //3) title nin facebook icermedigini test edin
    @Test
    public void test03() {

        String istenmeyenKelime = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }



        //4) sol ust kosede BestBuy logosunun gorundugunu test edin.
    @Test
    public void test04(){
        WebElement logoGorunurlugu = driver.findElement(By.xpath("//img[@width='80'][1]"));
        Assert.assertTrue(logoGorunurlugu.isDisplayed());

    }
    @Test
    public void test05(){
        WebElement francaisGorunurlugu= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisGorunurlugu.isDisplayed());
    }
}
