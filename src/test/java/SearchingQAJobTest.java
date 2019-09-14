import framework.SeleniumTestCase;
import org.testng.annotations.Test;
import pageobjects.VKJobPage;
import pageobjects.VKLoginPage;
import pageobjects.VKProductsPage;


public class SearchingQAJobTest extends SeleniumTestCase {
    @Test(enabled = false)
    public void searchQAJob() throws Exception {

        VKLoginPage
                .getVKLoginPage()
                .pressAllProductsButton();

        VKProductsPage
                .getVKProductsPage()
                .pressJobInVKButton();

        VKJobPage
                .getVKJobPage()
                .searchForQAJob();


    }
}