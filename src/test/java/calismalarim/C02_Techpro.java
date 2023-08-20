package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Techpro {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techproeducation.com");

        //Arama kutusunda java aratalim
        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        Thread.sleep(2000);

        //çıkan seçeneklerden full stack java developer seçeneğine tıklayatım
    List<WebElement> liste2 =   driver.findElements(By.linkText("Full Stack Java Developer"));
        System.out.println(liste2.get(3).getText());
        Thread.sleep(2000);

        List<WebElement> liste = driver.findElements(By.tagName("a"));
        System.out.println(liste.size());
      for (WebElement w: liste){
          if (!w.getText().isEmpty()){
              System.out.println(w.getText());
          }
      }
      driver.close();


    }
}
