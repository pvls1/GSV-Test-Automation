package lt.povilas.pupkys.test;

import lt.povilas.pupkys.autotester.api.APITester;
import lt.povilas.pupkys.autotester.ui.OpenWeatherTester;
import lt.povilas.pupkys.testdata.TestConfig;
import lt.povilas.pupkys.utils.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTesting {
    private TestConfig tu = new TestConfig();
    private OpenWeatherTester t = new OpenWeatherTester();
    private APITester at = new APITester();

    /**
     * After test suite completed opens test report
     */
    @AfterSuite(groups = {"ui", "api", "all"})
    public void showReport() {
        FileUtils.openReport();
    }

    /**
     * This test case log ins in to page,
     * generates new API key, edits it and save Default and the new generated key to txt file
     */
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

    /**
     * This test case checks if api response is HTTP_OK
     */
    @Test(description = "Good API response", groups = {"api", "all"})
    public void tc00002() {
        at.checkGoodApiResponse("Vilnius", t.loadAPIAsJsonFromFile(tu.getDefaultKey()));
    }

    /**
     * This test case checks if api response is HTTP_UNAUTHORIZED
     */
    @Test(description = "Bad API response", groups = {"api", "all"})
    public void tc00003() {
        at.checkBadApiResponse("Vilnius", "3acdf3793aa1e92b489");
    }

    /**
     * This test case checks validates JSON response
     */
    @Test(description = "Validate API response data", groups = {"api", "all"})
    public void tc00004() {
        at.checkAPIResponseData("Vilnius", t.loadAPIAsJsonFromFile(tu.getDefaultKey()));
    }
}
