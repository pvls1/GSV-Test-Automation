package lt.povilas.pupkys.autotester;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.net.HttpURLConnection;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class APITester {

    public void checkGoodApiResponse(String cityName, String apiKey) {
        Response response = RestAssured.get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey));
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_OK);
    }

    public void checkBadApiResponse(String cityName, String apiKey) {
        Response response = RestAssured.get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey));
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_UNAUTHORIZED);
    }
}
