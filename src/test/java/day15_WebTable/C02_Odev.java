package day15_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

import java.util.List;

public class C02_Odev extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
          driver.get("https://the-internet.herokuapp.com/tables");


        //  3.satirdaki 1. ve 2. sutun bilgilerini yazdiriniz. //--> position()>=1 and position()<=2

        List<WebElement> satir3satun1Sutun2 = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()<3]"));
        satir3satun1Sutun2.forEach(t-> System.out.println(t.getText()));

    }
}
