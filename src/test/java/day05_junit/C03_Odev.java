package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Odev {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1) "https://www.saucedemo.com" Adresine gidim.
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);

        //2) Username kutusuna "standart_user" yazdirin
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("standard_user");
        Thread.sleep(1000);

        //3) password kutusuna "secret_sauce" yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(1000);

        //4)Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);

        //5) ilk urunun sayfasina gidin
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();
        Thread.sleep(1000);

        //6) Add to cart bolumune gidin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);

        //7)Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_badge")).click();
        Thread.sleep(1000);
        driver.close();


    }
}
