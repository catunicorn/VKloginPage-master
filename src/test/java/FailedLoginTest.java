import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.VKLoginPage;

public class FailedLoginTest extends SeleniumTestCase {
    @Test(dataProvider = "testData", enabled = false)
    public void failedLogin(String nameValue, String pwdValue) throws Exception {
        VKLoginPage
                .getVKLoginPage();

    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {
                        "9111111111",
                        "qwerty"
                }
        };
    }
}
