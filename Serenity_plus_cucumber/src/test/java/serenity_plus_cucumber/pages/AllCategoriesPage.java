package serenity_plus_cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$;

public class AllCategoriesPage {

    public SearchResultPage chooseOneCategory(Random random) {
        ElementsCollection categories = $$(By.xpath("//li[@class = 'sub-category']/a"));
        int number = random.nextInt(categories.size());
        SearchResultPage searchResultPage =  new SearchResultPage();
        String name = categories.get(number).getText();
        searchResultPage.setUsedCategory(name);
        categories.get(number).click();
        return searchResultPage;
    }
}
