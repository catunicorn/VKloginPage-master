import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.FBLoginPage;
import pageobjects.VKLoginPage;


public class SwitchToFacebookTest extends SeleniumTestCase {
    @Test(dataProvider = "testData", enabled = false)
    public void switchToFacebook(String fbEmail, String fbPassword) throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .pressFBButton();
        FBLoginPage
                .getFBLoginPage()
                .fbFailedLogin(fbEmail, fbPassword)
                .failedLoginCheking();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {
                        "blahbl12345@mailforspam.com",
                        "myPass12345"
                }
        };
    }
}
