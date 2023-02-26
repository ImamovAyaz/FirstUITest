package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collections;

public class RubberDucksPage {
    WebDriver driver;
    private By priceButton = By.xpath("//nav[@class='filter']/a[text()='Price']");
    private By nameButton = By.xpath("//nav[@class='filter']/a[text()='Name']");
    private By popularityButton = By.xpath("//nav[@class='filter']/a[text()='Popularity']");
    private By dateButton = By.xpath("//nav[@class='filter']/a[text()='Date']");


    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByPrice() {
        int arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[@class='price-wrapper']")).getText();
        }
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort, Collections.reverseOrder());
    }

    public String[] allDucksInPrice(){
        driver.findElement(priceButton).click();
        int arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[@class='price-wrapper']")).getText();
        }
        return arr;
    }

    public String[] allDucksInName(){
        driver.findElement(nameButton).click();
        int arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[@class='name']")).getText();
        }
        return arr;
    }

    public String[] allDucksInPopularity(){
        driver.findElement(popularityButton).click();
        String[] arr = new String[allDucksCount()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[contains(@class, 'sticker')]")).getText();
        }
        return arr;
    }

    public String[] allDucksInDate(){
        driver.findElement(dateButton).click();
        String[] arr = new String[allDucksCount()];
        for (int i = 0; i < arr.length; i++) {
            driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]")).click();
            arr[i] = driver.findElement(By.xpath("//div[@class='codes']//span[@class='sku']")).getText();
            driver.navigate().back();
        }
        return arr;
    }

    public int allDucksCount(){
        int arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        return arrayLenght;
    }
}
