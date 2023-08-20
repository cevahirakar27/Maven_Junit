package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1) http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2) signin butonuna tiklayin
       WebElement signinButonu = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signinButonu.click();
        Thread.sleep(1000);

        //3)login alanina "username" yazdirin.
    WebElement loginButonu = driver.findElement(By.xpath("//input[@type='text']"));
    loginButonu.sendKeys("username");
    Thread.sleep(1000);

    //4)Password alanina "password" yazdirin
   WebElement passwordButonu = driver.findElement(By.xpath("//input[@id='user_password']"));
   passwordButonu.sendKeys("password");
   Thread.sleep(1000);

   //5) Sign in butonuna tiklayin
   WebElement signInButonu = driver.findElement(By.xpath("//input[@type='submit']"));
   signInButonu.click();
   driver.navigate().back();
   Thread.sleep(1000);

   //6) Online Banking butonuna tiklayin
       WebElement onlineBanking= driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking.click();
        Thread.sleep(1000);

   //7) Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        Thread.sleep(1000);

   //8) amount kismina yatirmak istediginiz herhangi bir miktari girin
      WebElement amount =  driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("5");
        Thread.sleep(1000);

   //9) tarih kismina "2020-09-10" yazdirin.
   WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
   date.sendKeys("2020-09-10");
   Thread.sleep(1000);

   //10) Pay butonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        Thread.sleep(1000);


   //11) "The Payment was successfully submitted" mesajinin ciktigini kontrol edin.
   WebElement sonucYzisi = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
       if (sonucYzisi.isDisplayed()){
           System.out.println("TESD PASSED");
       }else {
           System.out.println("TEST FAILED");
       }
       driver.close();

    }
}
