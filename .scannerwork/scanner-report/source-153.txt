package seleniumtest.seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

//CRISTINA MIRABELLI
public class BinaryConverter {
    Integer input;
    String binary;
    @Test
    public void  testBinary() {
        input=555;
        binary=Integer.toBinaryString(input);
        String local;
        System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rapidtables.com/convert/number/decimal-to-binary.html");
        driver.findElement(By.xpath("//*[@id=\"x\"]")).sendKeys(""+input);
        driver.findElement(By.xpath("//*[@id=\"calcform\"]/div[3]/button[1]")).click();
        local=driver.findElement(By.xpath("//*[@id=\"y\"]")).getAttribute("value");
        System.out.println("comparing .:    "+binary+"  ,   "+local);
        assertTrue(binary.equals(local));
    }
}
