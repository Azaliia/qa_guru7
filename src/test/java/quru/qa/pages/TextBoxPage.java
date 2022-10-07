package quru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.webdriver.Url;
import com.codeborne.selenide.conditions.webdriver.UrlContaining;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TextBoxPage {

    private SelenideElement
            menuItem = $("#item");

    public TextBoxPage openPage(){
        open("/text-box");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public TextBoxPage checkMenuItem(String menuItemNumber, String expectUrl){
        $("#item-"+menuItemNumber).click();
        Assertions.assertEquals("https://demoqa.com/"+expectUrl,url());
        return this;
    }

    public TextBoxPage checkMenuItemText(List<String> testData){
        $$("li.btn").containsAll(testData);
        return this;
    }

    public TextBoxPage checkMenuItemText2(){
        $$("li.btn").contains("Text Box");
        return this;
    }
}
