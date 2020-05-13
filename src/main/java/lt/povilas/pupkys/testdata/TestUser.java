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

    public TestUser() {
        this.testPage = "https://home.openweathermap.org/";
        this.userName = "tt1585087@gmail.com";
        this.password = "Slaptazodis1";
        this.keyName = getRandomString();
        this.currentKeyName = keyName;
    }

    public String getTestPage() {
        return testPage;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getCurrentKeyName() {
        return currentKeyName;
    }

    public String getNewKeyName(){
        String newKeyName = getRandomString();
        currentKeyName = newKeyName;
        return newKeyName;
    }
}
