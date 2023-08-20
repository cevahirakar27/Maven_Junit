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

public class C03_Iframe {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void ternDown() {
        driver.close();
    }


    //https://the-internet.herokuapp.com/iframe adresine gidin.
    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //"An Iframe containing testinin erisilebilir oldugunu test edin.
        WebElement erisilebilir = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(erisilebilir.isEnabled());
        System.out.println(erisilebilir.getText());


        //text box a merhaba dunya yazin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //text box i dogru locate etmemize ragmen bulamadi.cunku iframe var.once iframei
        //locate edip iframe gecmeliyiz
        driver.switchTo().frame(iframe);
      WebElement yazi= driver.findElement(By.xpath("//body[@id='tinymce']"));
       yazi.clear();
      yazi.sendKeys("MERHABA DUNYA");


        //text box in altinda bulunan "Elemental Selenium" linkinin textinin
        //gornur oldugunu dogrulayin ve konsola yazdirin.

        //yukarda iframe gecis yaptigimiz icin once iframeden cikmamiz lazim.
        driver.switchTo().defaultContent();

        WebElement elementalSeleniumYazisi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
     Assert.assertTrue(elementalSeleniumYazisi.isDisplayed());

    }
}