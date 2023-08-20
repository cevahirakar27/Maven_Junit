package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_AmazonAlisverisYap {

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
      driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //amazon.com a gidip All menusunden Books u secip java aratalim

        WebElement addm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        addm.click();
        Select select = new Select(addm);
        select.selectByValue("search-alias=stripbooks-intl-ship");
        Thread.sleep(1000);

      //  select.selectByIndex(2);
       // select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("java" +Keys.ENTER);
        Thread.sleep(1000);

        WebElement sonucYazisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());  //1-16 of over 20,000 results for "java"

        //1-16 of over 20,000 results for "java"
        //sonuc yazisinin icinde java gectigini dogrula


        String expected = "java";
        Assert.assertTrue(sonucYazisi.getText().contains(expected));


        //bu yazinin eriseilebilir oldugunu dogrulayalim
        Assert.assertTrue(sonucYazisi.isEnabled());


    }
}
