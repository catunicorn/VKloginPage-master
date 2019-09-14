package pageobjects;

import framework.WebDriverCommands;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static framework.Constants.VKUrl;


public class VKWarCrisisPage extends WebDriverCommands {
    private final String war_crisis_page = "war_crisis";
    private final String STAR = ".//div[@class='apps_install_header']//span[@class='app_rate fl_l full']"; //Xpath
    private final String HALF_STAR = ".//div[@class='apps_install_header']//span[@class='app_rate fl_l half']"; //Xpath

    public VKWarCrisisPage() {
    }

    private static VKWarCrisisPage vkWarCrisisPage = null;

    public static VKWarCrisisPage getVKWarCrisisPage() {
        if (vkWarCrisisPage == null)
            vkWarCrisisPage = new VKWarCrisisPage();

        return vkWarCrisisPage;
    }

    public VKWarCrisisPage openWarCrisisPage () throws Exception {
        goToPage(VKUrl+war_crisis_page);

        return this;
    }

    public VKWarCrisisPage countingStars () throws Exception {
        double numberOfStars = (double) $$(By.xpath(STAR)).size();
        if ($(By.xpath(HALF_STAR)).exists()){
            numberOfStars = numberOfStars + 0.5;
        }
        System.out.println(numberOfStars);

        return this;
    }
}
