package lt.povilas.pupkys.test;

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

    @Test(description = "API Key testing", groups = "main")
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
        t.saveAPIKeyToFile(tu.getCurrentKeyName());
    }
}
