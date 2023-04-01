package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;

public class RubberDucksPage {
    public WebDriver driver;
    private By priceButton = By.xpath("//nav[@class='filter']/a[text()='Price']");
    private By nameButton = By.xpath("//nav[@class='filter']/a[text()='Name']");
    private By nameActiveButton = By.xpath("//span[@class='button active' and text()='Name']");
    private By popularityButton = By.xpath("//nav[@class='filter']/a[text()='Popularity']");
    private By popularityActiveButton = By.xpath("//span[@class='button active' and text()='Popularity']");
    private By dateButton = By.xpath("//nav[@class='filter']/a[text()='Date']");
    private By dateActiveButton = By.xpath("//span[@class='button active' and text()='Date']");
    private By duckId = By.xpath("//div[@class='codes']//span[@class='sku']");
    private By duckElement = By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']");
    private By subcategoryTitle = By.xpath("//h1[@class='title' and text()='Subcategory']");


    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByPrice() {
        int arrayLenght = driver.findElements(duckElement).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath(String.format("//div[@class='content']//li[@class='product row shadow hover-light'][%s]//div[@class='price-wrapper']", i + 1))).getText();
        }
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort, Collections.reverseOrder());
    }

    public String[] allDucksInPrice() {
        driver.findElement(priceButton).click();
        int arrayLenght = driver.findElements(duckElement).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath(String.format("//div[@class='content']//li[@class='product row shadow hover-light'][%s]//div[@class='price-wrapper']", i + 1))).getText();
        }
        return arr;
    }

    public String[] allDucksInName() {
        driver.findElement(nameButton).click();
        int arrayLenght = driver.findElements(duckElement).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath(String.format("//div[@class='content']//li[@class='product row shadow hover-light'][%s]//div[@class='name']", i + 1))).getText();
        }
        return arr;
    }

    public String[] allDucksInPopularity() {
        driver.findElement(popularityButton).click();
        String[] arr = new String[allDucksCount()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath(String.format("//div[@class='content']//li[@class='product row shadow hover-light'][%s]//div[contains(@class, 'sticker')]", i + 1))).getText();
        }
        return arr;
    }

    public String[] allDucksInDate() {
        driver.findElement(dateButton).click();
        String[] arr = new String[allDucksCount()];
        for (int i = 0; i < arr.length; i++) {
            driver.findElement(By.xpath(String.format("//div[@class='content']//li[@class='product row shadow hover-light'][%s]", i + 1))).click();
            arr[i] = driver.findElement(duckId).getText();
            driver.navigate().back();
        }
        return arr;
    }

    public int allDucksCount() {
        int arrayLenght = driver.findElements(duckElement).size();
        return arrayLenght;
    }

    public Boolean isSubcategoryitleVisible() {
        return driver.findElement(subcategoryTitle).isEnabled();
    }

    public Boolean isNameClicked() {
        return driver.findElement(nameActiveButton).isEnabled();
    }

    public Boolean isPopularityClicked() {
        return driver.findElement(popularityActiveButton).isEnabled();
    }

    public Boolean isDateClicked() {
        return driver.findElement(dateActiveButton).isEnabled();
    }

}
