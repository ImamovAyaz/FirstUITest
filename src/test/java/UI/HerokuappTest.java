package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuappTest {
    public void OpenHerokuappTest()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> hrefList = new ArrayList();

        int hrefCount = driver.findElements(By.xpath("//li/a[@href]")).size();
        for (int i = 1; i < hrefCount + 1; i++) {
            String hrefText = driver.findElement(By.xpath("//li[" + i + "]/a[@href]")).getText();
            hrefList.add(hrefText);
            System.out.println(hrefList.get(i - 1));
        }

        driver.findElement(By.xpath("//li[10]/a[@href]")).click();
    }
}
