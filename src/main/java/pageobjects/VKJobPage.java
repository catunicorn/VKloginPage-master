package pageobjects;

import com.codeborne.selenide.Selectors;
import framework.WebDriverCommands;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;


public class VKJobPage extends WebDriverCommands {

    private final String QAJOB_NAME = "//*[contains(text(), 'Инженер по автоматизации тестирования (Команда Игр)')]"; //Xpath
    private final String assertJob_Message = "QA Automation Engineer at Game Development Department is found";

    public VKJobPage() {
    }

    private static VKJobPage vkJobPage = null;

    public static VKJobPage getVKJobPage() {
        if (vkJobPage == null)
            vkJobPage = new VKJobPage();

        return vkJobPage;
    }

    public VKJobPage searchForQAJob() throws Exception {
        Assert.assertTrue($$(Selectors.byXpath(QAJOB_NAME)).size() == 0,
                assertJob_Message);


        return this;
    }

}
