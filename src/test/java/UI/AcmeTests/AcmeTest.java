package UI.AcmeTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RubberDucksPage;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AcmeTest {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    private void setUp() {
        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterTest
    private void Quit() {
        driver.quit();
    }

    @Test
    @Description("Тест на открытие страницы Rubber Ducks")
    public void OpenRubberDucksTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.OpenRubberDucks();

        Assert.assertEquals("Rubber Ducks", driver.findElement(By.xpath("//h1[@class='title' and text()='Rubber Ducks']")).getText());
    }

    @Test
    @Description("Тест на открытие подкатегории Rubber Ducks - Subcategory")
    public void OpenSubcategoryTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.OpenRubberDucksSub();

        Assert.assertEquals("Subcategory", driver.findElement(By.xpath("//h1[@class='title' and text()='Subcategory']")).getText());
    }

    @Test
    @Description("Тест на сортировку уток на странице 'Subcategory' по названию (Name)")
    public void SubcategorySortByNameTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        mainPage.OpenRubberDucksSub();

        String[] arr = rubberDucksPage.allDucksInName();
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Name']")).isEnabled(), true,
                "Нажата кнопка Name");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Name");
    }

    @Test
    @Description("Тест на сортировку уток на странице 'Subcategory' по популярности (Popularity)")
    public void SubcategorySortByPopularityTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        mainPage.OpenRubberDucksSub();

        String[] arr = rubberDucksPage.allDucksInPopularity();
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Popularity']")).isEnabled(), true,
                "Нажата кнопка Popularity");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Popularity");
    }

    @Test
    @Description("Тест на сортировку уток на странице 'Subcategory' по дате создания (Date)")
    public void SubcategorySortByDateTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        mainPage.OpenRubberDucksSub();

        String[] arr = rubberDucksPage.allDucksInDate();
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='button active' and text()='Date']")).isEnabled(), true,
                "Нажата кнопка Date");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Date");
    }

    @Test
    @Description("Тест на соответствие лейбла цвету утки")
    public void SubcategoryCheckLabelTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.OpenRubberDucksSub();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@title='Green Duck']//div[@title='New']")).isEnabled(), true,
                "Зелёной утке соответствует лейб - New");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@title='Purple Duck']//div[@title='New']")).isEnabled(), true,
                "Розовой утке соответствует лейб - New");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@title='Yellow Duck']//div[@title='On Sale']")).isEnabled(), true,
                "Жёлтой утке соответствует лейб - Sale");
    }
}
