package lt.povilas.pupkys.test;

import lt.povilas.pupkys.autotester.APITester;
import lt.povilas.pupkys.autotester.OpenWeatherTester;
import lt.povilas.pupkys.testdata.TestUser;
import org.testng.annotations.Test;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTesting {
    TestUser tu = new TestUser();
    OpenWeatherTester t = new OpenWeatherTester();
    APITester at = new APITester();

    @Test(description = "API Key testing", groups = {"ui", "all"})
    public void tc00001() {
        t.openInChrome(tu.getTestPage());
        t.setInput("Enter email", tu.getUserName());
        t.setInput("Password", tu.getPassword());
        t.click("Submit");
        t.click("API keys");
        t.setInput("Name", tu.getKeyName());
        t.click("Generate");
        t.isTextVisible("API key was created successfully");
        t.clickEdit(tu.getCurrentKeyName());
        t.setInput("Name", tu.getNewKeyName(), 1);
        t.click("Edit");
        t.isTextVisible("API key was edited successfully");
        t.isTextVisible(tu.getCurrentKeyName());
        t.saveAPIKeyAsJsonToFile(tu.getDefaultKey(), tu.getCurrentKeyName());
    }

    @Test(description = "API response testing", groups = {"api", "all"})
    public void tc00002() {
        at.checkGoodApiResponse("Vilnius", t.loadAPIAsJsonFromFile(tu.getDefaultKey()));
    }

    @Test(description = "API response testing", groups = {"api", "all"})
    public void tc00003() {
        at.checkBadApiResponse("Vilnius", "3acdf3793aa1e92b489");
    }
}
