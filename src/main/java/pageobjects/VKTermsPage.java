package pageobjects;

import com.codeborne.selenide.Condition;
import framework.WebDriverCommands;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.CONSTANT_5_SECONDS;


public class VKTermsPage extends WebDriverCommands {

    private final String TEXT_BLOCK = ".//b[text()= '2.4.']/.."; //Xpath

    public VKTermsPage() {
    }

    private static VKTermsPage vkTermsPage = null;

    public static VKTermsPage getVKTermsPage() {
        if (vkTermsPage == null)
            vkTermsPage = new VKTermsPage();

        return vkTermsPage;
    }

    public VKTermsPage findTextBlock() {
        String paragraph = $(By.xpath(TEXT_BLOCK)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).getText();
        System.out.println(paragraph.substring(paragraph.indexOf("Администрация Сайта рекомендует")));


        return this;
    }
}
