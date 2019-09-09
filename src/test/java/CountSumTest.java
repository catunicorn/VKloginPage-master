import framework.SeleniumTestCase;
import org.testng.annotations.Test;
import pageobjects.VKAboutPage;
import pageobjects.VKLoginPage;
import pageobjects.VKProductsPage;

public class CountSumTest extends SeleniumTestCase {
    @Test(enabled = false)
    public void countSum() throws Exception {
        VKLoginPage
                .getVKLoginPage()
                .pressAllProductsButton();

        VKProductsPage
                .getVKProductsPage()
                .pressAboutCompanyButton();

        VKAboutPage
                .getVKAboutPage()
                .countSum()
                .countPublic();


    }

}