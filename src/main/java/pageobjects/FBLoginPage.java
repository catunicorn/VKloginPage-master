package pageobjects;

import org.openqa.selenium.By;
import framework.WebDriverCommands;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import static framework.Constants.*;

public class FBLoginPage extends WebDriverCommands {

    private static FBLoginPage fbLoginPage = null;
    private static String FB_EMAIL_ID = "email"; //id
    private static String FB_EMAIL = "blahbl12345@mailforspam.com";
    private static String FB_PASSWORD_ID = "pass"; //id
    private static String FB_PASSWORD = "myPass12345";
    private static String FB_LOGIN_BUTTON_ID = "loginbutton"; //id
    private static String ERROR_MESSAGE = ".//div[@class='fsl fwb fcb']";
    private static String ERROR_TEXT = "Неверный электронный адрес";



    public FBLoginPage() {
    }

    public static FBLoginPage getFBLoginPage() {
        if (fbLoginPage == null)
            fbLoginPage = new FBLoginPage();

        return fbLoginPage;
    }

    public static FBLoginPage fbFailedLogin(String fbEmail, String fbPassword) {
        $(By.id(FB_EMAIL_ID)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(FB_EMAIL);
        $(By.id(FB_PASSWORD_ID)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).setValue(FB_PASSWORD);
        $(By.id(FB_LOGIN_BUTTON_ID)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();


        return new FBLoginPage();

    }

    public static FBLoginPage failedLoginCheking() {
        $(By.xpath(ERROR_MESSAGE)).waitUntil(Condition.exactText(ERROR_TEXT), CONSTANT_5_SECONDS);

        return new FBLoginPage();
    }
}

