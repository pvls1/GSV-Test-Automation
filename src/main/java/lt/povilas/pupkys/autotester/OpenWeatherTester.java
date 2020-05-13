package lt.povilas.pupkys.autotester;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static lt.povilas.pupkys.utils.FileUtils.saveStringToFile;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class OpenWeatherTester extends WebTester {

    public void clickEdit(String text) {
        SelenideElement se = $(By.xpath("//a[@data-name='" + text + "']"));
        highlightElement(se);
        se.click();
    }

    public void saveAPIKey(String name) {
        SelenideElement se = $(By.xpath("//td[text()[normalize-space(.)='" + name + "']]/preceding-sibling::td/pre"));
        highlightElement(se);
        saveStringToFile(se.getText());
    }
}
