import framework.SeleniumTestCase;
import org.testng.annotations.Test;
import pageobjects.VKLoginPage;
import pageobjects.VKTermsPage;

public class DisplayTextTest extends SeleniumTestCase {
    @Test(enabled = false)
    public void displayText() throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .pressTermsButton();
        VKTermsPage
                .getVKTermsPage()
                .findTextBlock();




    }

}