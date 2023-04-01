package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPage {
    public WebDriver driver;
    private By rubberDucksButton = By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']");
    private By subcategoryButton = By.xpath("//nav[@id='site-menu']//a[@href and text()='Subcategory']");
    private By rubberDucksTitle = By.xpath("//h1[@class='title' and text()='Rubber Ducks']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRubberDucks() {
        driver.findElement(rubberDucksButton).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void openRubberDucksSub() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(rubberDucksButton)).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(subcategoryButton).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public Boolean isRubberDucksTitleVisible() {
        return driver.findElement(rubberDucksTitle).isEnabled();
    }

    public Boolean isColorDuckAndTitle(String color, String title) {
        return driver.findElement(By.xpath("//a[@title='" + color + " Duck']//div[@title='" + title + "']")).isEnabled();
    }
}
