package seleniumtest.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
        public static void  main(String [] args ){
            String who="Davide Falessi";
            Integer min=1800;
            System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get("https://scholar.google.com/citations?hl=it&view_op=search_authors&mauthors=&btnG=");
            driver.findElement(By.xpath("//*[@id=\"gs_hdr_tsi\"]")).sendKeys(who);
            driver.findElement(By.xpath("//*[@id=\"gs_hdr_tsb\"]")).click();
            WebElement TxtBoxContent =driver.findElement(By.xpath("//*[@id=\"gsc_sa_ccl\"]/div/div/div/div[3]"));
            //System.out.println(TxtBoxContent.getText());
            check.extract(TxtBoxContent.getText(),min);
        }
    }
