import framework.SeleniumTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.VKLoginPage;


public class VKLanguageTest extends SeleniumTestCase {

    @Test(enabled = false)
    public void checkLanguageTest() throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .switchLanguage()
                .buttonTextChecking();
    }

}
