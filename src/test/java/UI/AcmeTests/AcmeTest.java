package UI.AcmeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.*;

public class AcmeTest {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterTest
    private void Quit() {
        driver.quit();
    }

    @Test
    public void OpenRubberDucksTest() {
        driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertEquals("Rubber Ducks", driver.findElement(By.xpath("//h1[@class='title' and text()='Rubber Ducks']")).getText());
    }

    @Test
    public void OpenSubcategoryTest() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']"))).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Subcategory']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Assert.assertEquals("Subcategory", driver.findElement(By.xpath("//h1[@class='title' and text()='Subcategory']")).getText());
    }

    @Test
    public void SubcategorySortTest() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Rubber Ducks']"))).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//nav[@id='site-menu']//a[@href and text()='Subcategory']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        int arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        String[] arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[@class='price-wrapper']")).getText();
        }
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort, Collections.reverseOrder());

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Price']")).isEnabled(), true,
                "При открытии страницы Subcategory товары отсортированы по полю Price");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Price");

        driver.findElement(By.xpath("//nav[@class='filter']/a[text()='Name']")).click();

        arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[@class='name']")).getText();
        }
        arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Name']")).isEnabled(), true,
                "Нажата кнопка Name");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Name");

        driver.findElement(By.xpath("//nav[@class='filter']/a[text()='Popularity']")).click();
        arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]//div[contains(@class, 'sticker')]")).getText();
        }
        arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Popularity']")).isEnabled(), true,
                "Нажата кнопка Popularity");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Popularity");

        driver.findElement(By.xpath("//nav[@class='filter']/a[text()='Date']")).click();
        arrayLenght = driver.findElements(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light']")).size();
        arr = new String[arrayLenght];

        for (int i = 0; i < arr.length; i++) {
            driver.findElement(By.xpath("//div[@class='content']//li[@class='product row shadow hover-light'][" + (i + 1) + "]")).click();
            arr[i] = driver.findElement(By.xpath("//div[@class='codes']//span[@class='sku']")).getText();
            driver.navigate().back();
        }
        arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Date']")).isEnabled(), true,
                "Нажата кнопка Date");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Date");
    }

    @Test
    public void SubcategoryCheckLabelTest() {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@title='Green Duck']//div[@title='New']")).isEnabled(), true,
                "Зелёной утке соответствует лейб - New");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@title='Purple Duck']//div[@title='New']")).isEnabled(), true,
                "Розовой утке соответствует лейб - New");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@title='Yellow Duck']//div[@title='On Sale']")).isEnabled(), true,
                "Жёлтой утке соответствует лейб - Sale");
    }
}
