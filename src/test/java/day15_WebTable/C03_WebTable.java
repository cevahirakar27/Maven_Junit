package day15_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilices.TestBase;

import java.util.List;

public class C03_WebTable extends TestBase {


    //https://the-internet.herokuapp.com/tables sayfasına gidelim
   //Task 1 : Table1’i print edin
   //Task 2 : 3. Row' datalarını print edin  Task 3 : Son row daki dataları print edin
   //Task 4 : 5. Column datalarini print edin
   //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
   //Parameter 2 = column numarasi
   //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin.


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin.
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("table1.getText() = " + table1.getText());
        System.out.println("*****************************");

        //Task 2 : 3. Row' datalarını print edin.
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tbody[1]//tr[3]"));
        System.out.println("ucuncuSatir = "  + ucuncuSatir.getText());
        System.out.println("*****************************************");
        
        // Task 3 : 3. row daki dataları print edin.
        WebElement ucuncuSutunBasligi = driver.findElement(By.xpath("(//table)[1]//th[3]"));
        System.out.println("ucuncuSutunBasligi = " + ucuncuSutunBasligi.getText());

      List< WebElement> ucuncuStirHucreleri = driver.findElements(By.xpath("(//table)[1]//td[3]"));
        ucuncuStirHucreleri.forEach(t-> System.out.println(t.getText()));
        System.out.println("**************************************");

        //Task 4 :  son satir datalarini print edin.
        WebElement sonSatir = driver.findElement(By.xpath("(//table)[1]//tbody//tr[last()]"));
        System.out.println("sonSatir = " + sonSatir.getText());
        System.out.println("***************************************");

        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin.

        printData(2,3);

    }

    private void printData(int satir, int sutun) {
        WebElement satir2Sutun3 = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));
        System.out.println("satir2Sutun3 = " + satir2Sutun3.getText());
    }

}
