package pageobjects;

import com.codeborne.selenide.Condition;
import framework.WebDriverCommands;
import org.openqa.selenium.By;

import java.math.BigInteger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static framework.Constants.CONSTANT_5_SECONDS;


public class VKAboutPage extends WebDriverCommands {
    private final String STATISTIC_BLOCK1 = ".//*[contains(@class, 'stats_wr')]//div[1]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK2 = ".//*[contains(@class, 'stats_wr')]//div[2]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK3 = ".//*[contains(@class, 'stats_wr')]//div[3]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK4 = ".//*[contains(@class, 'stats_wr')]//div[4]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK5 = ".//*[contains(@class, 'stats_wr')]//div[5]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK6 = ".//*[contains(@class, 'stats_wr')]//div[6]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK7 = ".//*[contains(@class, 'stats_wr')]//div[7]/div[1]"; //Xpath
    private final String STATISTIC_BLOCK8 = ".//*[contains(@class, 'stats_wr')]//div[8]/div[1]"; //Xpath
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
        final String a = $(By.xpath(STATISTIC_BLOCK1)).getText();
        final String b = $(By.xpath(STATISTIC_BLOCK2)).getText();
        final String c = $(By.xpath(STATISTIC_BLOCK3)).getText();
        final String d = $(By.xpath(STATISTIC_BLOCK4)).getText();
        final String e = $(By.xpath(STATISTIC_BLOCK5)).getText();
        final String f = $(By.xpath(STATISTIC_BLOCK6)).getText();
        final String g = $(By.xpath(STATISTIC_BLOCK7)).getText();
        final String h = $(By.xpath(STATISTIC_BLOCK8)).getText();

        String[] statisticNumbers;
        statisticNumbers = new String[8];
        statisticNumbers[0] = a;
        statisticNumbers[1] = b;
        statisticNumbers[2] = c;
        statisticNumbers[3] = d;
        statisticNumbers[4] = e;
        statisticNumbers[5] = f;
        statisticNumbers[6] = g;
        statisticNumbers[7] = h;

        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 0; i < 8; i++) {

            if (statisticNumbers[i].contains("M")) {
                statisticNumbers[i] = statisticNumbers[i].replace("M", "000000");
            }
            if (statisticNumbers[i].contains("B")) {
                statisticNumbers[i] = statisticNumbers[i].replace("B", "000000000");
            }
            sum = sum.add(new BigInteger(statisticNumbers[i]));
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
