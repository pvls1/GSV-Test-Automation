package lt.povilas.pupkys.test;

import lt.povilas.pupkys.autotester.OpenWeatherTester;
import lt.povilas.pupkys.testdata.TestUser;
import org.testng.annotations.Test;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTesting {
    TestUser ts = new TestUser();
    OpenWeatherTester t = new OpenWeatherTester();

    @Test(description = "API Key testing", groups = "main")
    public void tc00001() {
        t.openInChrome(ts.getTestPage());
        t.setInput("Enter email", ts.getUserName());
        t.setInput("Password", ts.getPassword());
        t.click("Submit");
        t.click("API keys");
        t.setInput("Name", ts.getKeyName());
        t.click("Generate");
        t.isTextVisible("API key was created successfully");
        t.clickEdit(ts.getCurrentKeyName());
        t.setInput("Name", ts.getNewKeyName(), 1);
        t.click("Edit");
        t.isTextVisible("API key was edited successfully");
        t.isTextVisible(ts.getCurrentKeyName());
        t.saveAPIKeyToFile(ts.getCurrentKeyName());
    }
}
