package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import quru.qa.pages.TextBoxPage;
import quru.qa.data.Locale;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SimpleJUnitSimpleTest {

    TextBoxPage textBoxPage = new TextBoxPage();


    @BeforeAll
    static void setUp()
    {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    static Stream <Arguments> checkClickElementsInMenuBarTest2(){
        return Stream.of(
                Arguments.of(quru.qa.data.Locale.EN,List.of("Text Box","Check Box", "Radio Button"))
                );
    }

    @CsvSource(value = {"1,checkbox","2,radio-button","3,webtables","4,buttons"})
    @ParameterizedTest (name = "Test to check demoqa menu items")
    void checkClickElementsInMenuBarTest(String menuItem, String url){
        textBoxPage
                .openPage()
                .checkMenuItem(menuItem,url);
    }

    @MethodSource
    @ParameterizedTest (name = "Test to check demoqa menu items text")
    void checkClickElementsInMenuBarTest2(Locale locale, List <String> testData){
        textBoxPage
                .openPage()
                .checkMenuItemText(testData);
    }

    @EnumSource (Locale.class)
    @ParameterizedTest (name = "Test to check demoqa menu items text")
    void checkClickElementsInMenuBarTest3(Locale locale){
        textBoxPage
                .openPage()
                .checkMenuItemText2();
    }
}
