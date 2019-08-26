import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.FBLoginPage;
import pageobjects.VKLoginPage;


public class SwitchToFacebook extends SeleniumTestCase {
    @Test(dataProvider = "testData", enabled = true)
    public void SwitchToFacebook(String fbEmail, String fbPassword) throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .PressFBButton();
        FBLoginPage
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
