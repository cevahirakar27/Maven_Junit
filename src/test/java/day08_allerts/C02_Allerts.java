package day08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {



   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


    @Test
    //bir method olsturun.acceptAlert
    //1.butona tiklayin uyaridaki ok butonuna tiklayin ve result mesajinin
    //You successfully clicked an alert oldugunu test edin.

    public void acceptAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
       driver.switchTo().alert().accept();
      String expectedResult="You successfully clicked an alert";
       WebElement sonucYzi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonucYzi.getText();

        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test

    //bir method olusturun dismissAlert
    //2.butona tiklayin uyaridaki cansel butonuna tiklayin ve result mesajinin
    //successfuly icermedigini test edin

    public void dismissAlert(){
      driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
      driver.switchTo().alert().dismiss();
      String expectedSonuc="successfuly";
      WebElement sonucYazisi= driver.findElement(By.xpath("//p[@id='result']"));
      String actualYazi=sonucYazisi.getText();
      Assert.assertFalse(actualYazi.contains(expectedSonuc));

    }

    @Test
    //3.method olusturun test03()
    //sitedeki 3.butona basin.kutucuga "abcd" yazin ve cikan Result sonuc yazisini yazdirin
    public void test03(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("abcd");
        driver.switchTo().alert().accept();
        
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisi.getText();
        System.out.println("actualSonucYazisi = " + actualSonucYazisi);   //You entered: abcd


    }
}
