package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_HandleDropDown {

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
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
       WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));


        //1)index kullanarak Option1 i secin ve yazdirin
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        //select.selectByIndex(); //index kullanarak
        //select.selectByValue(); //value kullanarak
       // select.selectByVisibleText(); gorunur olarak

        //2)value kullanarak option2 yi secin ve yazdirin.
         // select.deselectByIndex();
         // select.deselectByValue();

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //System.out.println(select.getFirstSelectedOption().getText());

        // 3tane secenek oldugunu dogrulayin.
        List<WebElement>actualOptionSayisi=select.getOptions();
        System.out.println(actualOptionSayisi.size());

        int expectedOption= 3;
    if (expectedOption==3){
        System.out.println("true");
    }else {
        System.out.println("false");
    }

    }
}
