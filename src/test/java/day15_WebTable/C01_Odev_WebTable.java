package day15_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

public class C01_Odev_WebTable extends TestBase {


    //https://the-internet.herokuapp.com/tables sayfasına gidelim
    //  3.satirdaki 1. ve 2. sutun bilgilerini yazdiriniz. //--> position()>=1 and position()<=2


    @Test
    public void tes01() {



        //https://the-internet.herokuapp.com/tables sayfasına gidelim
      //  driver.get("https://the-internet.herokuapp.com/tables");


        //  3.satirdaki 1. ve 2. sutun bilgilerini yazdiriniz. //--> position()>=1 and position()<=2


        driver.get("https://the-internet.herokuapp.com/tables");

        // 3. satırdaki 1. sütun bilgisini al
        WebElement cell1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[1]"));
        System.out.println("3. satır, 1. sütun: " + cell1.getText());

        // 3. satırdaki 2. sütun bilgisini al
        WebElement cell2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));
        System.out.println("3. satır, 2. sütun: " + cell2.getText());

    }


}
