package day10_actions;

import org.junit.Test;
import utilices.TestBase;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void test01(){
     driver.get("https://www.amazon.com");
     driver.navigate().refresh();
     driver.navigate().refresh();

    }
}
