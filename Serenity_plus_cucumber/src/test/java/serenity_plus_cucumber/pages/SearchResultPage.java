package serenity_plus_cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    private  String usedCategory;
    private  String usedFilter;
    private  String usedSort;
    private static final Logger LOGGER = Logger.getLogger(SearchResultPage.class.getName());

    void setUsedCategory(String usedCategory) {
        this.usedCategory = usedCategory;
    }


    public void filterByOneParameterInOneCheckbox(Random random) {
        ElementsCollection checkboxes = $$(By.xpath("//input[@type = 'checkbox']"));
        int number = random.nextInt(checkboxes.size());
        usedFilter = checkboxes.get(number).parent().find("span").getText();
        checkboxes.get(number).click();
    }

    public void filterByOneParameterInOneRadiobutton(Random random) {
        ElementsCollection radios = $$(By.xpath("//input[@type = 'radio']"));
        int number = random.nextInt(radios.size());
        usedFilter = radios.get(number).parent().find("span").getText();
        radios.get(number).parent().click();
    }

    public void filterByCarouselList(Random random) {
        ElementsCollection carousel = $$(By.className("srp-carousel-list__item--large-items"));
        int number = random.nextInt(carousel.size());
        usedFilter = carousel.get(number).find("div").getText();
        carousel.get(number).click();
    }

    public void sort(Random random) {
        $(By.xpath("//label[@id='w4-w3_btn_label']/following-sibling::button")).hover();
        ElementsCollection sortCriteria = $$(By.xpath("//div[@id = 'w4-w3']/descendant::a"));
        int number = random.nextInt(sortCriteria.size());
        usedSort = sortCriteria.get(number).find("span").getText();
        sortCriteria.get(number).click();
    }

    public ItemPage goToItemPage(Random random) {
        ElementsCollection items = $$(By.className("s-item__link"));
        int number = random.nextInt(items.size());
        ItemPage itemPage = new ItemPage();
        String name = items.get(number).find(By.className("s-item__title")).getText();
        itemPage.setItemName(name);
        items.get(number).click();
        return itemPage;
    }

    public boolean validateSearch(String text) {
        ElementsCollection items = $$(By.className("s-item__link"));
        if(items.stream().anyMatch(item->item.find(By.className("s-item__title")).getText().contains(text))){
            LOGGER.info("Test Pass");
            WebDriverRunner.driver().close();
            return true;
        } else {
            LOGGER.error("Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
    }

    public boolean validateSearchCategory() {
        String currentText = $(By.className("b-pageheader__text")).getText();
        String[] keyWords = new String[0];
        if (usedCategory.contains(" ") || usedCategory.contains(",")) {
            keyWords = usedCategory.split("[ ,]");
        }
        if((Arrays.stream(keyWords).anyMatch(word -> currentText.contains(word)))|| currentText.contains(usedCategory)){
            LOGGER.info("Test Pass");
            WebDriverRunner.driver().close();
            return true;
        } else {
            LOGGER.error("Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
    }

    public boolean validateFilter() {
        String currentText = $(By.xpath("//a[@class='srp-carousel-list__item-link']/div")).getText();
        currentText = currentText.substring(0,currentText.indexOf("\n"));
        if(currentText.equals(usedFilter)){
            LOGGER.info("Test Pass");
            WebDriverRunner.driver().close();
            return true;
        } else {
            LOGGER.error("Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
    }

    public boolean validateSort() {
        String currentText = $(By.cssSelector("#w4-w3 > button > div > div")).getText();
        if(currentText.equals(usedSort)){
            LOGGER.info("Test Pass");
            WebDriverRunner.driver().close();
            return true;
        } else {
            LOGGER.error("Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
    }
}
