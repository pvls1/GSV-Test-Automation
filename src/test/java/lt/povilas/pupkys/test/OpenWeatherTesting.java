package lt.povilas.pupkys.test;

import lt.povilas.pupkys.autotester.WebTester;
import org.testng.annotations.Test;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTesting {
    WebTester t = new WebTester();

    @Test
    public void tc00001() throws Exception {
        t.openInChrome("https://home.openweathermap.org/");
        t.setInput("Enter email", "tt1585087@gmail.com");
        t.setInput("Password", "Slaptazodis1");
        t.click("Submit");
        t.click("API keys");
        t.setInput("Name", "newAPIKey");
        t.click("Generate");
        t.isTextVisible("API key was created successfully");


    }
}
