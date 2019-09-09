package pageobjects;

import framework.WebDriverCommands;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class VKJobPage extends WebDriverCommands {

    private final String QAJOB_NAME = "//*[contains(text(), 'Инженер по автоматизации тестирования в команду Игр')]"; //Xpath
    private final String ALLJOBS = ".//*[@class='blog_job_title']"; //Xpath

    public VKJobPage() {
    }

    private static VKJobPage vkJobPage = null;

    public static VKJobPage getVKJobPage() {
        if (vkJobPage == null)
            vkJobPage = new VKJobPage();

        return vkJobPage;
    }

    public VKJobPage searchForQAJob() throws Exception {
        Assert.assertEquals($(By.xpath(QAJOB_NAME)),$$(By.xpath(ALLJOBS)),
                "QA Automation engineer at Game Development Department Vacancy is not found");


        return this;
    }

}
