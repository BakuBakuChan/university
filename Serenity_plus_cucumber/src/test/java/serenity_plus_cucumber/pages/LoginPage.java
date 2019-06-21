package serenity_plus_cucumber.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void enterLoginAndPassword(String login, String password) {
        $(By.id("userid")).val(login);
        $(By.id("pass")).val(password).pressEnter();
    }
}
