package pageobjects;

import com.codeborne.selenide.Condition;
import framework.WebDriverCommands;
import org.openqa.selenium.By;

import java.math.BigInteger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static framework.Constants.CONSTANT_5_SECONDS;


    public class VKAboutPage extends WebDriverCommands {
    private String STATISTIC_BLOCK = ".//*[contains(@class, 'stats_wr')]//div[%d]/div[1]"; //Xpath
    private final String OFFICIAL_PUBLIC = ".//div[@class='blog_about_link']"; //Xpath
    private final String JOBVK_BUTTON = ".//*[@class='ui_tab'][contains(text(), 'Работа ВКонтакте')]"; //Xpath


    public VKAboutPage() {
    }

    private static VKAboutPage vkAboutPage = null;

    public static VKAboutPage getVKAboutPage() {
        if (vkAboutPage == null)
            vkAboutPage = new VKAboutPage();

        return vkAboutPage;
    }

    public VKAboutPage countSum() throws Exception {

        int index = 1;

        BigInteger sum = BigInteger.valueOf(0);

        while ($(By.xpath(String.format(STATISTIC_BLOCK, index))).exists()) {

            String textFromElement = $(By.xpath(String.format(STATISTIC_BLOCK, index))).getText();

            if (textFromElement.contains("M")) {
                textFromElement = textFromElement.replace("M", "000000");
            }
            if (textFromElement.contains("B")) {
                textFromElement = textFromElement.replace("B", "000000000");
            }
            sum = sum.add(new BigInteger(textFromElement));

            index++;
        }


        System.out.println(sum);

        return this;
    }

    public VKAboutPage countPublic() throws Exception {

        int numberOfPublics = $$(By.xpath(OFFICIAL_PUBLIC)).size();
        System.out.println(numberOfPublics);

        return this;
    }

    public VKAboutPage pressJobInVKButton() throws Exception {
        $(By.xpath(JOBVK_BUTTON)).waitUntil(Condition.visible, CONSTANT_5_SECONDS).click();

        return new VKAboutPage();
    }
}
