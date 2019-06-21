package serenity_plus_cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final Logger LOGGER = Logger.getLogger(MainPage.class.getName());

    public void openMailPage() {
        System.setProperty("webdriver.chrome.driver",
                "src\\test\\resources\\features\\chromedriver.exe");
        open("https://www.ebay.com/");
    }

    public LoginPage clickOnSignInButton() {
        $(By.linkText("Sign in")).click();
        return new LoginPage();
    }

    public SearchResultPage enterTextInSearchField(String searchText) {
        $(By.xpath("//input[@placeholder='Search for anything']")).val(searchText).pressEnter();
        return new SearchResultPage();
    }

    public SearchResultPage chooseOneCategoryInTheTopOfPage(Random random) {
        ElementsCollection categories = $$(By.xpath("//ul[@class = 'hl-cat-nav__container']/li"));

        int number =  (random.nextInt(categories.size() - 2));
        number+=2;
        categories.get(number).hover();
        ElementsCollection subCategories =  categories.get(number)
                .findAll(By.tagName("a"));

        int item = random.nextInt(subCategories.size());

        SearchResultPage searchResultPage =  new SearchResultPage();
        String subCategoryName = subCategories.get(item).innerText();
        searchResultPage.setUsedCategory(subCategoryName);

        subCategories.get(item).click();

        return searchResultPage;
    }

    public void openSearchByCategoryMeany() {
        $(By.id("gh-shop-a")).click();
    }

    public SubCategoryPage chooseOneCategoryFromSearchByCategoryMany(Random random) {
        ElementsCollection categories = $$(By.xpath("//table[@id='gh-sbc']/descendant::ul/descendant::a"));
        int number = random.nextInt(categories.size());
        categories.get(number).click();
        return new SubCategoryPage();
    }

    public AllCategoriesPage chooseSeeAllCategory() {
        $(By.xpath("//table[@id='gh-sbc']/descendant::a[@id='gh-shop-see-all']")).click();
        return new AllCategoriesPage();
    }

    public boolean validateLogin(String name){
        String currentName = $(By.cssSelector("#gh-ug > b:nth-child(1)")).getText();
        if (currentName.equals(name)
        ) {
            LOGGER.info("Login was successful. Test Pass");
            WebDriverRunner.driver().close();
            return true;
        } else {
            LOGGER.error("Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
    }
}