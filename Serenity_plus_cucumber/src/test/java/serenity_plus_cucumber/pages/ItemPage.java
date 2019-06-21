package serenity_plus_cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ItemPage {
    private static final Logger LOGGER = Logger.getLogger(ItemPage.class.getName());
    private String itemName;

    public CartPage addInCart(Random random) {
        ElementsCollection fieldsToIdentified = $$(By.className("msku-sel "));
        if (fieldsToIdentified.size() > 0) {
            fieldsToIdentified
                    .stream()
                    .forEach(field -> {
                        ElementsCollection options = field.findAll(By.tagName("option"));
                        int number = random.nextInt(options.size() - 1);
                        number += 1;
                        field.click();
                        options.get(number).click();
                    });
        }
        $(By.cssSelector("#isCartBtn_btn")).click();
        return new CartPage();
    }

    public boolean validateItemPage() {
        String name = title();
        name = name.substring(0, name.indexOf(" | eBay"));
        if (name.contains(itemName)) {
            LOGGER.info("Item is correct. Test Pass");
            WebDriverRunner.driver().close();
            return true;
        } else {
            LOGGER.error("Not correct item. Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
