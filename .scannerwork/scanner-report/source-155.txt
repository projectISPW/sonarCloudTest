package seleniumtest.seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

//FRANCESCO D'AMATA
public class TopItialianUniversity {
    private  String which;
    private  int numUniversity;//max number is 8
    private  String [] topUniversities;
    private  void setTopUniversities(){
        System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/search?q=top+universita+italiane+2021&rlz=1C1GEWG_itIT949IT949&oq=top+universita+italiane+2021&aqs=chrome..69i57.8432j0j7&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        String inner;
        for(int i=1;i<=numUniversity;i++){
            inner=String.format("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[2]/ul/li[%d]",i);
            topUniversities[i-1]=driver.findElement(By.xpath(inner)).getText();
        }
    }
    private boolean check(){
        boolean bool=false;
        int index=0;
        while(!bool && index<topUniversities.length){
            bool=topUniversities[index++].contains(which);
        }
        return bool;
    }
    @Test
    public void testUiniversities(){
        which="Roma";
        numUniversity=8;
        topUniversities=new String[numUniversity];
        setTopUniversities();
        assertTrue(check());
    }
}
