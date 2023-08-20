package day06_radiubutton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Aseertions {
WebDriver driver;
   @Before
   public void setUp(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


   }
   @After
    public void tearnDown(){
       driver.close();
   }
   @Test
    public void test01(){
       //eger test methodumuzsa hicbir test yoksa test calistiktan sonra
       //hicbir problemle karsilasilmadigini raporlamak icin test pasd yazisi cikar.
//eger testleri if ile yaparsak test FAILED olsa bile kodlar problemsiz calistigi icin
       //kod calismasi bittiginde ekranin solunda test Passsed yazacaktir
       driver.get("https://www.facebook.com");

       //url in https://www.amazon.com oldugunu test edin
  //     if (driver.getCurrentUrl().equals("https://www.amazon.com")){
  //         System.out.println("url testi pass");
  //     }else {
        //   System.out.println("url testi FAILED");
    //   }

       String expectedUrl="https://www.amazon.com";
       String actualUrl = driver.getCurrentUrl();
       Assert.assertEquals("Url bekleneden farkli "+expectedUrl,actualUrl);

       /*
       Assert ile yaptigimiz testlerde assertion failed olursa java kodlarin calisşmasinin durdurur
       //ve assert classi bizi hata konusnda bilgilendirir.boylece hatanin ne oldugunu arastirmammiza gerek kalmadan
       //Junit bize raporlamis olacak.
        */
   }

}
