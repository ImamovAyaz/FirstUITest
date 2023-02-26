package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPage{
    WebDriver driver;
    private By rubberDucksButton = By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']");
    private By subcategoryButton = By.xpath("//nav[@id='site-menu']//a[@href and text()='Subcategory']");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openRubberDucks(){
        driver.findElement(rubberDucksButton).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void openRubberDucksSub(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(rubberDucksButton)).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(subcategoryButton).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
