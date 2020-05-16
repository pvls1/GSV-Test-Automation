package lt.povilas.pupkys.autotester;

import com.codeborne.selenide.SelenideElement;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static lt.povilas.pupkys.utils.FileUtils.*;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTester extends WebTester {

    protected boolean isCookiesMessageDispayed() {
        SelenideElement se = $(By.xpath("//div[@class='stick-footer-panel']/descendant::p"));
        return se.isDisplayed();
    }

    private void acceptCookies() {
        if (isCookiesMessageDispayed()) {
            click("Allow all");
        }
    }

    @Override
    public void openInChrome(String url) {
        super.openInChrome(url);
        acceptCookies();
    }

    @Override
    public void openInFireFox(String url) {
        super.openInFireFox(url);
        acceptCookies();
    }

    @Override
    public void openInInternetExplorer(String url) {
        super.openInInternetExplorer(url);
        acceptCookies();
    }

    public void clickEdit(String text) {
        SelenideElement se = $(By.xpath("//a[@data-name='" + text + "']"));
        highlightElement(se);
        se.click();
    }

    public void saveAPIKeyToFile(String name) {
        SelenideElement se = $(By.xpath("//td[text()[normalize-space(.)='" + name + "']]/preceding-sibling::td/pre"));
        highlightElement(se);
        writeToFile(name + " " + se.getText());
    }

    public String loadAPIKeyFromFile() {
        return readFromFile();
    }

    public void saveAPIKeyAsJsonToFile(String... name) {
        JSONObject jsonObject = new JSONObject();
        for (String text : name) {
            SelenideElement se = $(By.xpath("//td[text()[normalize-space(.)='" + text + "']]/preceding-sibling::td/pre"));
            highlightElement(se);
            jsonObject.put(text, se.getText());
        }
        writeJsonToFile(jsonObject);
    }

    public String loadAPIAsJsonFromFile(String name) {
        JSONObject jsonObject = readJsonFromFile();
        return (String) jsonObject.get(name);
    }
}
