package day09_handeleWindow_Testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        //1) amazona gidin
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //2) url in amazon icerdiginin test edin.
        String istenenKelime = "amazon";
        String ilkSayfaWindowHande= driver.getWindowHandle();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));


        //3) yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciWindowHandle=driver.getWindowHandle();


        //4) title in Best Buy icerdigini test edelim
        String actualTitle = driver.getTitle();
        String arananKelime = "Best Buy";
        Assert.assertTrue(actualTitle.contains(arananKelime));

        //5) ilk sayfaya donup java aratalim
        driver.switchTo().window(ilkSayfaWindowHande);
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);



        //6) arama sonuclarinin java icerdigini test edelim.
        WebElement sonucYzi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi= sonucYzi.getText();
        String aradigimizKelime="java";
        Assert.assertTrue(sonucYazisi.contains(aradigimizKelime));



        //7) yeniden Betbuy in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciWindowHandle);

        //8) logonun gorundugunu test edelim
        WebElement logoElementiGorunurlugu = driver.findElement(By.xpath("//img[@class='logo'][1]"));
        Assert.assertTrue(logoElementiGorunurlugu.isDisplayed());


        Thread.sleep(3000);
    }
}