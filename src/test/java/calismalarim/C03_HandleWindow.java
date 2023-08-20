package calismalarim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilices.TestBase;

public class C03_HandleWindow extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //amazona gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        String getWindowHandle1 = driver.getWindowHandle();

        //arama kutusuna nutella yazip yeni bi tab acalim.
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("nutella");
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu2 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu2.sendKeys("nutella" +Keys.ENTER);

        Thread.sleep(2000);

        //ilk sayfaya geri donelim.
        driver.switchTo().window(getWindowHandle1);
        Thread.sleep(2000);







    }
}
