package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Odev {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1)  "https://www.google.com/" sayfasina gidin
        driver.get("https://www.google.com/");
        Thread.sleep(1000);


        //3) arama cubugunda nutella aratin
      WebElement aramaKutusu= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
      aramaKutusu.sendKeys("nutella" + Keys.ENTER);
      Thread.sleep(1000);

      //4) arama cubugnda kac sonuc oldugununyazdirin
      WebElement sonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuc.getText());  //Yaklaşık 240.000.000 sonuç bulundu.
        driver.close();


    }
}
