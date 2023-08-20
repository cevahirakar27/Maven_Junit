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

public class C04_CheckBox {

    //1) "https://the-internet.herokuapp.com/checkboxes

    WebDriver driver;
    @Before
    public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearnDown(){
       driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");


//checkbox 1 ve 2yi locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

      //ceheckbox1 secili degilse onay kutusunu tıklayinc
        Thread.sleep(1000);
        if (!checkBox1.isSelected()){
            checkBox1.click();

        }
        Thread.sleep(1000);
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(1000);

    }
}
