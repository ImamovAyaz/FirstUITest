package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void OpenRubberDucks(){
        driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void OpenRubberDucksSub(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']"))).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Subcategory']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
