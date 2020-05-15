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

    public void getCurrentWeatherByCityName(String cityName, String apiKey) {
        Response response = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey);
        int code = response.getStatusCode();
        Assert.assertEquals(code, HttpURLConnection.HTTP_OK);
    }
}
