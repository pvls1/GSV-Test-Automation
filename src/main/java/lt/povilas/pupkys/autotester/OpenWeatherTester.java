package lt.povilas.pupkys.autotester;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static lt.povilas.pupkys.utils.FileUtils.readFromFile;
import static lt.povilas.pupkys.utils.FileUtils.writeToFile;

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

    public void openChrome(String url) {
        openInChrome(url);
        acceptCookies();
    }

    public void openFirefox(String url) {
        openInFireFox(url);
        acceptCookies();
    }

    public void openExplorer(String url) {
        openInInternetExplorer(url);
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
        writeToFile(se.getText());
    }

    public String loadAPIKeyFromFile() {
        return readFromFile();
    }
}
