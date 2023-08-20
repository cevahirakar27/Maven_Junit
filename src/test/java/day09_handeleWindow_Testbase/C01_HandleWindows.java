package day09_handeleWindow_Testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {

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
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        String ilkSayfaHandeleDegeri= driver.getWindowHandle(); // [91408B528948360A23E4A3139170CAA9]


        //nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);


        //ilk urunun resmini tiklayarak farkli bir tab olarak acin
      WebElement ilkUrunResmi= driver.findElement(By.xpath("//img[@class='s-image'][1]"));
      driver.switchTo().newWindow(WindowType.TAB);
      Thread.sleep(2000);
      /*
      bu komutu kullandigimizda driver otomatik olarak new taba gecer.yeni tabda gorevi gerceklestirmek icin
      adimlari bastan almamiz lazim.
       */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        WebElement ilkUrunResmi2= driver.findElement(By.xpath("//img[@class='s-image'][1]"));
        ilkUrunResmi2.click();

        //yeni tabda acilan urunun basligini yazdirin yazdirin.
        WebElement ilkUrunBasli= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(ilkUrunBasli.getText());
        //Nutella Hazelnut Spread with Cocoa for Breakfast, 26.5 oz Jar


        //ilk sayfaya gecelim.
        driver.switchTo().window(ilkSayfaHandeleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
}
