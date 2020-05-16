package lt.povilas.pupkys.autotester;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class WebTester {

    protected SelenideElement lastElement = null;
    protected JavascriptExecutor jsExec;

    /**
     * Opens Chrome browser and sets WebDriver
     */
    protected void openInChrome(String url) {
        System.setProperty("selenide.browser", "chrome");
        open(url);
        getWebDriver().manage().window().maximize();
        jsExec = (JavascriptExecutor) getWebDriver();
    }

    /**
     * Opens Firefox browser and sets WebDriver
     */
    protected void openInFireFox(String url) {
        System.setProperty("selenide.browser", "firefox");
        open(url);
        getWebDriver().manage().window().maximize();
        jsExec = (JavascriptExecutor) getWebDriver();
    }

    /**
     * Opens Internet explorer browser and sets WebDriver
     */
    protected void openInInternetExplorer(String url) {
        System.setProperty("selenide.browser", "ie");
        open(url);
        getWebDriver().manage().window().maximize();
        jsExec = (JavascriptExecutor) getWebDriver();
    }

    /**
     * Add border to web elements
     */
    protected void highlightElement(SelenideElement we) {
        unhighlightLast();
        lastElement = we;
        jsExec.executeScript("arguments[0].style.border='3px solid red'", we);
    }

    /**
     * Removes highlights from web elements
     */
    protected void unhighlightLast() {
        if (lastElement != null) {
            try {
                jsExec.executeScript("arguments[0].style.border=''", lastElement);
            } catch (Exception ignored) {
            } finally {
                lastElement = null;
            }
        }
    }

    /**
     * Finds web elements by given text
     *
     * @return list
     */
    protected List<SelenideElement> findElementsByText(String linkText) {
        String expectedText = linkText.trim();
        String a = "//a[text()[normalize-space(.)='" + expectedText + "']]";
        String button = "//button[text()[normalize-space(.)='" + expectedText + "']]";
        String label = "//label[text()[normalize-space(.)='" + expectedText + "']]";
        String input = "//input[@value[normalize-space(.)='" + expectedText + "']]";
        String td = "//td[text()[normalize-space(.)='" + expectedText + "']]";
        String span = "//span[text()[normalize-space(.)='" + expectedText + "']]";
        String div = "//div[text()[normalize-space(.)='" + expectedText + "']]";

        List<SelenideElement> htmlElements = new ArrayList<>();
        htmlElements.addAll($$(By.xpath(a)));
        htmlElements.addAll($$(By.xpath(button)));
        htmlElements.addAll($$(By.xpath(label)));
        htmlElements.addAll($$(By.xpath(input)));
        htmlElements.addAll($$(By.xpath(td)));
        htmlElements.addAll($$(By.xpath(span)));
        htmlElements.addAll($$(By.xpath(div)));

        return htmlElements;
    }

    /**
     * Finds input elements by given text
     *
     * @return list
     */
    protected List<SelenideElement> findInputElementsByXpath(String text) {
        String expectedText = text.trim();
        String input = "//input[@placeholder=\"" + expectedText + "\"]";
        String label = "//label[text()[normalize-space(.)=\"" + expectedText + "\"]]/../descendant::input";

        List<SelenideElement> htmlElements = new ArrayList<>();
        htmlElements.addAll($$(By.xpath(input)));
        htmlElements.addAll($$(By.xpath(label)));

        return htmlElements;
    }

    /**
     * Sets given text to given input field
     */
    public void setInput(String inputLabel, String text, int index) {
        SelenideElement se = findInputElementsByXpath(inputLabel).get(index);
        highlightElement(se);
        se.setValue(text);
    }

    /**
     * Sets given text to given input field
     */
    public void setInput(String inputLabel, String text) {
        setInput(inputLabel, text, 0);
    }

    /**
     * Clicks web element by given text
     */
    public void click(String text, int index) {
        SelenideElement se = findElementsByText(text).get(index);
        highlightElement(se);
        se.click();
    }

    /**
     * Clicks web element by given text
     */
    public void click(String text) {
        click(text, 0);
    }

    /**
     * Checks if given text is visible
     */
    public void isTextVisible(String text) {
        SelenideElement se = $(By.xpath("//*[text()[normalize-space(.)=\"" + text + "\"]]"));
        highlightElement(se);
        assertTrue("No match", se.isDisplayed());
    }
}
