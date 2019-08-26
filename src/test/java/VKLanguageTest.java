import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.VKLoginPage;


public class VKLanguageTest extends SeleniumTestCase {

    @Test(dataProvider = "testData", enabled = false)
    public void CheckLanguageTest(String englishButton) throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .SwitchLanguage()
                .ButtonTextChecking(englishButton);
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {
                        "Log in"
                }
        };
    }


}
