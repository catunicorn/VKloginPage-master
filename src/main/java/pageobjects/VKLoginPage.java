package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import framework.WebDriverCommands;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.*;

public class VKLoginPage extends WebDriverCommands {

    private final String EMAIL_INPUT = "index_email"; //id
    private final String PASSWORD_INPUT = "index_pass"; //id
    private final String LOGIN_BUTTON = "index_login_button"; //id
    private final String SWITCH_LANGUAGE_BUTTON = "top_switch_lang"; //id
    private final String LOGIN_MESSAGE = "login_message"; //id
    private final String CAPTCHA_NAME = "recaptcha-checkbox-border"; //id
    private final String CAPTCHA_XPATH = ".//label[text()='Я не робот']"; //Xpath
    private final String FB_BUTTON = ".//*[@class='fb-login-button index_fb_continue_with_btn fb_iframe_widget']"; //class

    public VKLoginPage() {
    }

    private static VKLoginPage vkLoginPage = null;

    public static VKLoginPage getVKLoginPage() {
        if (vkLoginPage == null)
            vkLoginPage = new VKLoginPage();

        return vkLoginPage;
    }

    public VKLoginPage loginVKPage(String nameValue, String pwdValue) throws Exception {
        goToPage(VKUrl);
        $(Selectors.byId(EMAIL_INPUT)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(nameValue);
        $(Selectors.byId(PASSWORD_INPUT)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(pwdValue);
        $(Selectors.byId(LOGIN_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();

        return new VKLoginPage();
    }


    public VKLoginPage SwitchLanguage() throws Exception {
        goToPage(VKUrl);
        $(By.id(SWITCH_LANGUAGE_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();

        return new VKLoginPage();
    }

    public VKLoginPage ButtonTextChecking(String ButtonText) throws Exception {
        $(By.id(LOGIN_BUTTON)).waitUntil(Condition.exactText(ButtonText), CONSTANT_5_SECONDS);

        return new VKLoginPage();
    }

    public VKLoginPage FailedLoginChecking(String LoginMessage) throws Exception {
        $(By.id(LOGIN_MESSAGE)).waitUntil(Condition.exactText(LoginMessage), CONSTANT_5_SECONDS);

        return new VKLoginPage();
    }

    public VKLoginPage ClickCaptcha() throws Exception {
        Selenide.switchTo().frame($(By.xpath(".//div[@id=\'recaptcha0\']//iframe")));
        $(By.xpath(CAPTCHA_XPATH)).waitUntil(Condition.visible, CONSTANT_10_SECONDS);
        $(By.className(CAPTCHA_NAME)).click();

        return new VKLoginPage();
    }

    public VKLoginPage PressFBButton() throws Exception {
        goToPage(VKUrl);
        $(By.xpath(FB_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();
        Selenide.switchTo().window("Facebook");

        return new VKLoginPage();
    }


}
