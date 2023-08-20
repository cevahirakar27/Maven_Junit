package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilices.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //amazon anasayfaya gidip account menusunden create a list linkine tiklayin

        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        Actions action = new Actions(driver);
        WebElement actionLinki = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        action.moveToElement(actionLinki).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);



    }

}
