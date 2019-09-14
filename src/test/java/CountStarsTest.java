import framework.SeleniumTestCase;
import org.testng.annotations.Test;
import pageobjects.VKWarCrisisPage;

public class CountStarsTest extends SeleniumTestCase {
    @Test(enabled = true)
    public void countStars() throws Exception {
        VKWarCrisisPage
                .getVKWarCrisisPage()
                .openWarCrisisPage()
                .countingStars();


    }

}