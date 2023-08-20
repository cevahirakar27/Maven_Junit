package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//    //https://the-internet.herokuapp.com/javascript_alerts

public class C01_Allerts {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {



        //herhangi bir web sitesine gidince veya bir web sitesinde herhangi bir iuyari ciktiginda
        //allert diyoruz.eger allert inspect yapiliyorsa otomasyon ile kullanilabilir.
        //locate edip istedigimiz islemleri yapabiliriz..bazen inspect yapilamaz.
        //exksta isleme ihtiyac vardir.java scscrıpt allertle rlocate edilemez

//"https://the-internet.herokuapp.com/javascript_alerts" gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
         driver.switchTo().alert().accept();
      //switchto:degistirr.
        //accept:okey

        //You successfully clicked an alert bu yazinin ciktigini test edin

       String expectedResult = "You successfully clicked an alert";
        WebElement sonucYzisi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi= sonucYzisi.getText();
        Assert.assertEquals(expectedResult,actualSonucYazisi);
    }
}
