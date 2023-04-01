package UI.AcmeTests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RubberDucksPage;

import java.util.Arrays;

public class AcmeTest extends TestBase {

    @Test
    @Description("Тест на открытие страницы Rubber Ducks")
    public void OpenRubberDucksTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openRubberDucks();

        Assert.assertTrue(mainPage.isRubberDucksTitleVisible(), "Имеется заголовок 'Rubber Ducks'");
    }

    @Test
    @Description("Тест на открытие подкатегории Rubber Ducks - Subcategory")
    public void OpenSubcategoryTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);

        mainPage.openRubberDucksSub();

        Assert.assertTrue(rubberDucksPage.isSubcategoryitleVisible(), "Имеется заголовок 'Subcategory'");
    }

    @Test
    @Description("Тест на сортировку уток на странице 'Subcategory' по названию (Name)")
    public void SubcategorySortByNameTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        mainPage.openRubberDucksSub();

        String[] arr = rubberDucksPage.allDucksInName();
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertTrue(rubberDucksPage.isNameClicked(), "Нажата кнопка 'Name'");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю 'Name'");

    }

    @Test
    @Description("Тест на сортировку уток на странице 'Subcategory' по популярности (Popularity)")
    public void SubcategorySortByPopularityTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        mainPage.openRubberDucksSub();

        String[] arr = rubberDucksPage.allDucksInPopularity();
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertEquals(rubberDucksPage.isPopularityClicked(), true, "Нажата кнопка 'Popularity'");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю 'Popularity'");
    }

    @Test
    @Description("Тест на сортировку уток на странице 'Subcategory' по дате создания (Date)")
    public void SubcategorySortByDateTest() {
        MainPage mainPage = new MainPage(driver);
        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        mainPage.openRubberDucksSub();

        String[] arr = rubberDucksPage.allDucksInDate();
        String[] arrSort = arr.clone();
        Arrays.sort(arrSort);

        Assert.assertTrue(rubberDucksPage.isDateClicked(), "Нажата кнопка Date");
        Assert.assertEquals(arr, arrSort, "Успешно отсортировано по полю Date");
    }

    @Test
    @Description("Тест на соответствие лейбла цвету утки")
    public void CheckLabelTest() {
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isColorDuckAndTitle("Green","New"));
        Assert.assertTrue(mainPage.isColorDuckAndTitle("Purple","New"));
        Assert.assertTrue(mainPage.isColorDuckAndTitle("Yellow","On Sale"));
    }
}
