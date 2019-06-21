package serenity_plus_cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private static final Logger LOGGER = Logger.getLogger(CartPage.class.getName());
    private String firstItemName;


    public void deleteObjectFromCart() {
        firstItemName = $(By.xpath("//span[@class = 'BOLD']")).getText();
        $(By.xpath("//button[@data-test-id='cart-remove-item']")).click();
    }


    public void saveForLater() {
        firstItemName = $(By.xpath("//span[@class = 'BOLD']")).getText();
        $(By.xpath("//button[@data-test-id='cart-to-sfl']")).click();
    }

    public boolean validateCartPage() {
        if (WebDriverRunner.url().equalsIgnoreCase(
                "https://cart.ebay.com/")) {
            LOGGER.info("Cart Page opened. Test Pass");
            return true;
        } else {
            LOGGER.error("Cart Page do not opened. Test Failed");
            return false;
        }
    }

    public boolean validateCartRemove() {
        String deletedItemReferenceXPath = "//a[text() ='" + firstItemName + "']";
        if ($(By.xpath(deletedItemReferenceXPath)).parent().getText().contains(" was removed from your cart.")) {
            LOGGER.info("Cart Page opened. Item was deleted. Test Pass");
            return true;
        } else {
            LOGGER.info("Cart Page do not opened. Test Failed");
            return false;
        }
    }

    public boolean validateCartSave() {
        if ($(By.xpath("//a[@data-test-id='sfl-item-link']/span")).getText().equals(firstItemName)
        ) {
            LOGGER.info("Cart Page opened. Item was added to save for later. Test Pass");
            return true;
        } else {
            LOGGER.info("Cart Page do not opened. Test Failed");
            return false;
        }
    }

    public boolean validateTotalPrise() {
        if (WebDriverRunner.url().equalsIgnoreCase(
                "https://cart.ebay.com/")
        ) {
            double itemTotal = Double.parseDouble($(By.xpath("//*[@data-test-id='ITEM_TOTAL']")).getText().substring(4));
            ElementsCollection items = $$(By.xpath("//div[@class='item-price']/span/span"));
            double itemSum = 0;
            for (SelenideElement item : items) {
                itemSum += Double.parseDouble(item.getText().substring(4));
            }
            if ((itemTotal == itemSum)) {
                LOGGER.info("Cart Page opened. Item was added to save for later. Test Pass");
                return true;
            }
            WebDriverRunner.driver().close();
        } else {
            LOGGER.info("Cart Page do not opened. Test Failed");
            WebDriverRunner.driver().close();
            return false;
        }
        return false;
    }

    public void cleanCart() {
        $$(By.xpath("//button[@data-test-id='cart-remove-item']"))
                .stream()
                .forEach(itemButton -> itemButton.click());
        LOGGER.info("Clean cart.");
        $$(By.xpath("//button[@data-test-id='sfl-remove-item']"))
                .stream()
                .forEach(itemButton -> itemButton.click());
        LOGGER.info("Clean save for later");
    }
}