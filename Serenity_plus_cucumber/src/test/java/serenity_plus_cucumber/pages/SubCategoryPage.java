package serenity_plus_cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$;

public class SubCategoryPage {

    public SearchResultPage chooseOneSubCategory(Random random) {
        ElementsCollection subCategories = $$(By.cssSelector("#w1-w0 > ul > li > a"));
        int number = random.nextInt(subCategories.size());
        SearchResultPage searchResultPage = new SearchResultPage();
        subCategories.get(number).click();
        ElementsCollection subTree = $$(By.xpath("//ul[@class='b-accordion-subtree']/descendant::a"));
        if (subTree.size() > 0) {
            number = random.nextInt(subTree.size());
            subTree.get(number).click();
            searchResultPage.setUsedCategory(subTree.get(number).getText());
        }
        searchResultPage.setUsedCategory(subCategories.get(number).getText());
        return searchResultPage;
    }
}
