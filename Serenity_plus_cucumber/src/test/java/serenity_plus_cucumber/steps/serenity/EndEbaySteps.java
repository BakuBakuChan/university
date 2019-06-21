package serenity_plus_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import serenity_plus_cucumber.pages.*;

import java.util.Random;

public class EndEbaySteps {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    SearchResultPage searchResultPage;
    ItemPage itemPage = new ItemPage();
    CartPage cartPage = new CartPage();
    Random random = new Random();


    @Step
    public void openMainPage() {
        mainPage.openMailPage();
    }

    @Step
    public void openLoginPage() {
        mainPage.clickOnSignInButton();
    }

    @Step
    public void signIn(String login, String password) {
        loginPage.enterLoginAndPassword(login, password);
    }

    @Step
    public void isLogin(String name) {
        Assert.assertTrue(mainPage.validateLogin(name));
    }

    @Step
    public void searchByText(String text) {

        searchResultPage = mainPage.enterTextInSearchField(text);
    }

    @Step
    public void searchByCategoriesInTop() {
        searchResultPage = mainPage.chooseOneCategoryInTheTopOfPage(random);
    }

    @Step
    public void openCategoriesMenu() {
        mainPage.openSearchByCategoryMeany();
    }

    @Step
    public void searchByCategoriesButton() {
        searchResultPage = mainPage.chooseOneCategoryFromSearchByCategoryMany(random).chooseOneSubCategory(random);
    }

    @Step
    public void searchByAllCategories() {

        searchResultPage = mainPage.chooseSeeAllCategory().chooseOneCategory(random);
    }


    @Step
    public void filterByOneParameterInOneChekbox() {
        searchResultPage.filterByOneParameterInOneCheckbox(random);
    }

    @Step
    public void filter() {
        searchResultPage.filterByOneParameterInOneRadiobutton(random);
    }

    @Step
    public void sort() {
        searchResultPage.sort(random);
    }

    @Step
    public void isSearched(String text) {
        Assert.assertTrue(searchResultPage.validateSearch(text));
    }

    @Step
    public void isSearchedCategory() {
        Assert.assertTrue(searchResultPage.validateSearchCategory());
    }

    @Step
    public void isSorted() {
        Assert.assertTrue(searchResultPage.validateSort());
    }

    @Step
    public void isFiltered() {

        Assert.assertTrue(searchResultPage.validateFilter());
    }

    @Step
    public void openItemPage() {
        itemPage = searchResultPage.goToItemPage(random);
    }

    @Step
    public void isItemPage() {

        Assert.assertTrue(itemPage.validateItemPage());
    }

    @Step
    public void addItemInCart() {
        itemPage.addInCart(random);
    }

    @Step
    public void isInCart() {

        Assert.assertTrue(cartPage.validateCartPage());
    }

    @Step
    public void removeFromCart() {
        cartPage.deleteObjectFromCart();
    }

    public void isRemoved() {

        Assert.assertTrue(cartPage.validateCartRemove());
    }

    @Step
    public void saveForLater() {
        cartPage.saveForLater();
    }

    @Step
    public void isSaved() {
        Assert.assertTrue(cartPage.validateCartSave());
    }

    @Step
    public void isCorrectTotal() {
        Assert.assertTrue(cartPage.validateTotalPrise());
    }

    @Step
    public void cleanCart(){
        cartPage.cleanCart();
    }
}
