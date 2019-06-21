package serenity_plus_cucumber.steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity_plus_cucumber.steps.serenity.EndEbaySteps;

public class DefinitionTweeterSteps {
    @Steps
    EndEbaySteps endEbaySteps = new EndEbaySteps();

    @Given("^user on the main ebay page$")
    public void openEbay() {
        endEbaySteps.openMainPage();
    }

    @And("^go to 'sign in page'$")
    public void goToLoginPage() {
        endEbaySteps.openLoginPage();
    }

    @When("^user enters login as \"([^\"]*)\", user enters password as \"([^\"]*)\"$")
    public void enterLoginAnaPassWord(String login, String password) {
        endEbaySteps.signIn(login, password);
    }

    @Then("^user name in top of the page must be equals to name as \"([^\"]*)\"$")
    public void validateLogin(String name) {
        endEbaySteps.isLogin(name);
        WebDriverRunner.driver().close();
    }

    @When("^user enters text as \"([^\"]*)\" in search field$")
    public void search(String text) {
        endEbaySteps.searchByText(text);
    }

    @Then("^user should have a page with goods with text as \"([^\"]*)\" in name$")
    public void validateSearch(String text) {
        endEbaySteps.isSearched(text);
        WebDriverRunner.driver().close();
    }

    @When("^user points on category name and clicks on some subcategory name$")
    public void searchByCategoryInTopOfPage() {
        endEbaySteps.searchByCategoriesInTop();
    }

    @Then("^user should have a page with goods with key word from subcategory name in goods name$")
    public void validateSearchByCategoryInTopOfPage() {
        endEbaySteps.isSearchedCategory();
        WebDriverRunner.driver().close();
    }

    @When("^user clicks on \"Shop by category\" button and clicks on some subcategory name and clicks on subcategory of previous subcategory$")
    public void searchByShopByCategoryButton() {
        endEbaySteps.openCategoriesMenu();
        endEbaySteps.searchByCategoriesButton();
    }

    @When("^user clicks on \"Shop by category\" button and clicks on \"see all categories\" and clicks on some subcategory name$")
    public void searchByShopByAllCategories() {
        endEbaySteps.openCategoriesMenu();
        endEbaySteps.searchByAllCategories();
    }

    @When("^chooses one of filters in checkbox$")
    public void filterCheckBox() {
        endEbaySteps.filterByOneParameterInOneChekbox();
    }

    @When("^chooses one of filters in radio button$")
    public void filterGoodsRadioButton() {
        endEbaySteps.filter();
    }

    @Then("^description of random good contains a filter value$")
    public void validateFilter() {
        endEbaySteps.isFiltered();
    }

    @When("^chooses one of sort criteria$")
    public void sort() {
        endEbaySteps.sort();
    }

    @Then("^description of random good match to sort criteria$")
    public void validateSort() {
        endEbaySteps.isSorted();
        WebDriverRunner.driver().close();
    }

    @When("^click on random good$")
    public void goToItem() {
        endEbaySteps.openItemPage();
    }

    @Then("^user should have a page with good full description$")
    public void validateItem() {
        endEbaySteps.isItemPage();
        WebDriverRunner.driver().close();
    }

    @When("^clicks on button \"Add to cart\"$")
    public void addInCard() {
        endEbaySteps.addItemInCart();
    }

    @Then("^good must be in the user`s \"Shopping cart\"$")
    public void validateCartPresent() {
        endEbaySteps.isInCart();
        endEbaySteps.cleanCart();
        WebDriverRunner.driver().close();
    }

    @When("^clicks on the button \"Remove\"$")
    public void removeFromCart() {
        endEbaySteps.removeFromCart();
    }

    @When("^click on the button \"Save for later\"$")
    public void saveForLater() {
        endEbaySteps.saveForLater();
    }

    @Then("^the good from \"Shopping cart\" must be replaced to \"Save for later\" category$")
    public void validateSaveForLater() {
        endEbaySteps.isSaved();
        endEbaySteps.cleanCart();
        WebDriverRunner.driver().close();
    }

    @Then("^there isn`t deleted good in the \"Shopping cart\"$")
    public void validateRemove() {
        endEbaySteps.isRemoved();
        endEbaySteps.cleanCart();
        WebDriverRunner.driver().close();
    }

    @Then("^\"total\" price tag at the cart page must be equal to the sum of products price in the cart$")
    public void validateTotal() {
        endEbaySteps.isCorrectTotal();
        endEbaySteps.cleanCart();
        WebDriverRunner.driver().close();
    }
}
