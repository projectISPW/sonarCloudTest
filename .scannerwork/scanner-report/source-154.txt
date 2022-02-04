package seleniumtest.seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
//EDUARD OLENIC
public class ScholarQuotes {
    String who;
    int min;
    public boolean extract(String input){
        int start=10;
        String convert=input.substring(start);
        int converted=Integer.parseInt(convert);
        if(converted>min){
            System.out.printf("Number of quotes greater than %d , value: %d",min,converted);
            return true;
        }else{
            System.out.printf("Number of quotes smaller than %d , value: %d",min,converted);
            return false;
        }
    }
    //number of quotes
    @Test
    public void testQuotes( ){
        who="Davide Falessi";
        min=1800;
        System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://scholar.google.com/citations?hl=it&view_op=search_authors&mauthors=&btnG=");
        driver.findElement(By.xpath("//*[@id=\"gs_hdr_tsi\"]")).sendKeys(who);
        driver.findElement(By.xpath("//*[@id=\"gs_hdr_tsb\"]")).click();
        WebElement TxtBoxContent =driver.findElement(By.xpath("//*[@id=\"gsc_sa_ccl\"]/div/div/div/div[3]"));
        assertTrue (extract(TxtBoxContent.getText()));
        }
    }
