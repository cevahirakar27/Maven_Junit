package day06_radiubutton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforAfterClass {

    /*
    before ve after class notasyonlari sadece statik methodlar icin calisir
     */
  static   WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();

    }

    @Test
    //once bfore
    public void test01() {
        driver.get("https://www.facebook.com");
        //sonra after
    }

    @Test
    public void test02() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test03() {
        driver.get("https://www.kitapyurdu.com");

    }

}
