import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.VKLoginPage;

public class FailedLogin extends SeleniumTestCase {
    @Test(dataProvider = "testData", enabled = false)
    public void FailedLogin(String nameValue, String pwdValue, String LoginMessage) throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .loginVKPage(nameValue, pwdValue)
                .ClickCaptcha()
                .FailedLoginChecking(LoginMessage);

    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {
                        "9111111111",
                        "qwerty",
                        "Не удаётся войти"
                }
        };
    }
}
