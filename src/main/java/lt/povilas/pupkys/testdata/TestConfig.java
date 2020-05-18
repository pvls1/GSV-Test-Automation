package lt.povilas.pupkys.testdata;

import static lt.povilas.pupkys.utils.RandomStringGenerator.getRandomString;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class TestConfig {

    private String testPage;
    private String userName;
    private String password;
    private String keyName;
    private String currentKeyName;
    private String defaultKey;

    /**
     * Builds test user
     */
    public TestConfig() {
        this.testPage = "https://home.openweathermap.org/";
        this.userName = "tt1585087@gmail.com";
        this.password = "Slaptazodis1";
        this.keyName = getRandomString();
        this.currentKeyName = keyName;
        this.defaultKey = "Default";
    }

    /**
     * @return test page
     */
    public String getTestPage() {
        return testPage;
    }

    /**
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the key name
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * @return the current key name
     */
    public String getCurrentKeyName() {
        return currentKeyName;
    }

    /**
     * @return the new key name
     */
    public String getNewKeyName() {
        String newKeyName = getRandomString();
        currentKeyName = newKeyName;
        return newKeyName;
    }

    /**
     * @return the default key
     */
    public String getDefaultKey() {
        return defaultKey;
    }
}
