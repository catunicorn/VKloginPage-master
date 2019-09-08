package pageobjects;

import com.codeborne.selenide.Condition;
import framework.WebDriverCommands;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.CONSTANT_5_SECONDS;


public class VKProductsPage extends WebDriverCommands {

    private final String ABOUTCOMPANY_BUTTON = ".//*[@class='ui_tab'][contains(text(), 'О компании')]"; //Xpath

    public VKProductsPage() {
    }

    private static VKProductsPage vkProductsPage = null;

    public static VKProductsPage getVKProductsPage() {
        if (vkProductsPage == null)
            vkProductsPage = new VKProductsPage();

        return vkProductsPage;
    }

    public VKProductsPage pressAboutCompanyButton() throws Exception {
        $(By.xpath(ABOUTCOMPANY_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();

        return new VKProductsPage();

    }
}
