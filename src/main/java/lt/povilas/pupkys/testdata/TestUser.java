package lt.povilas.pupkys.testdata;

import static lt.povilas.pupkys.utils.RandomStringGenerator.getRandomString;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class TestUser {

    private String testPage;
    private String userName;
    private String password;
    private String keyName;
    private String currentKeyName;
    private String defaultKey;

    /**
     * Builds test user
     */
    public TestUser() {
        this.testPage = "https://home.openweathermap.org/";
        this.userName = "tt1585087@gmail.com";
        this.password = "Slaptazodis1";
        this.keyName = getRandomString();
        this.currentKeyName = keyName;
        this.defaultKey = "Default";
    }

    /**
     * @return String
     */
    public String getTestPage() {
        return testPage;
    }

    /**
     * @return String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return String
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * @return String
     */
    public String getCurrentKeyName() {
        return currentKeyName;
    }

    /**
     * @return String
     */
    public String getNewKeyName() {
        String newKeyName = getRandomString();
        currentKeyName = newKeyName;
        return newKeyName;
    }

    /**
     * @return String
     */
    public String getDefaultKey() {
        return defaultKey;
    }
}
