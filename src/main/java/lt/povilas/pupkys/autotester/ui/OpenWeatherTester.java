package lt.povilas.pupkys.autotester.ui;

import com.codeborne.selenide.SelenideElement;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static lt.povilas.pupkys.utils.FileUtils.*;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTester extends AbstractWebTester {

    /**
     * Checks if cookies message is displayed
     *
     * @return boolean
     */
    protected boolean isCookiesMessageDisplayed() {
        SelenideElement se = $(By.xpath("//div[@class='stick-footer-panel']/descendant::p"));
        return se.isDisplayed();
    }

    /**
     * Accepts cookies if displayed
     */
    private void acceptCookies() {
        if (isCookiesMessageDisplayed()) {
            click("Allow all");
        }
    }

    /**
     * Opens Chrome browser and accepts cookies
     */
    @Override
    public void openInChrome(String url) {
        super.openInChrome(url);
        acceptCookies();
    }

    /**
     * Opens Firefox browser and accepts cookies
     */
    @Override
    public void openInFireFox(String url) {
        super.openInFireFox(url);
        acceptCookies();
    }

    /**
     * Opens Internet explorer browser and accepts cookies
     */
    @Override
    public void openInInternetExplorer(String url) {
        super.openInInternetExplorer(url);
        acceptCookies();
    }

    /**
     * Clicks edit by given text
     */
    public void clickEdit(String text) {
        SelenideElement se = $(By.xpath("//a[@data-name='" + text + "']"));
        highlightElement(se);
        se.click();
    }

    /**
     * Saves given API key to txt file
     */
    public void saveAPIKeyToFile(String name) {
        SelenideElement se = $(By.xpath("//td[text()[normalize-space(.)='" + name + "']]/preceding-sibling::td/pre"));
        highlightElement(se);
        writeToFile(name + " " + se.getText());
    }

    /**
     * Loads API key from txt file
     *
     * @return String
     */
    public String loadAPIKeyFromFile() {
        return readFromFile();
    }

    /**
     * Saves given string array to file as JSON
     */
    public void saveAPIKeyAsJsonToFile(String... name) {
        JSONObject jsonObject = new JSONObject();
        for (String text : name) {
            SelenideElement se = $(By.xpath("//td[text()[normalize-space(.)='" + text + "']]/preceding-sibling::td/pre"));
            highlightElement(se);
            jsonObject.put(text, se.getText());
        }
        writeJsonToFile(jsonObject);
    }

    /**
     * Reads API key from txt file
     *
     * @return String
     */
    public String loadAPIAsJsonFromFile(String name) {
        JSONObject jsonObject = readJsonFromFile();
        return (String) jsonObject.get(name);
    }
}
