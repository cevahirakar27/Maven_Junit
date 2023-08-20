package day06_radiubutton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {

    //https://www.facebook.com

    //create account butonuna basin
    //radio buttons elemntlerini locate edin
    //secili degilse cinsiyet butonundan size uygun olani secin.

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
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");

        //yeni hesap olustur
      driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

      //radio button elemanlarini locate et
    WebElement kadin =driver.findElement(By.xpath("//input[@value='1']"));
    WebElement erkek = driver.findElement(By.xpath("//input[@value='2']"));
    WebElement ozel = driver.findElement(By.xpath("//*[text()='Özel']"));

    if (!kadin.isSelected()){
        kadin.click();
    }
    Thread.sleep(2000);


}


}
