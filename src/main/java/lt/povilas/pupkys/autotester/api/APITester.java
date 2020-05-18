package lt.povilas.pupkys.autotester.api;

import io.restassured.RestAssured;
import lt.povilas.pupkys.autotester.Tester;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class APITester extends Tester {

    /**
     * Checks if response is HTTP_OK
     *
     * @param cityName the name of the city to be tested
     * @param apiKey   the api key
     */
    public void checkGoodApiResponse(String cityName, String apiKey) {
        RestAssured.given().
                when().
                get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey)).
                then().
                statusCode(HttpURLConnection.HTTP_OK);
    }

    /**
     * Checks if response is HTTP_UNAUTHORIZED
     *
     * @param cityName the name of the city to be tested
     * @param apiKey   the api key
     */
    public void checkBadApiResponse(String cityName, String apiKey) {
        RestAssured.given().
                when().
                get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey)).
                then().
                statusCode(HttpURLConnection.HTTP_UNAUTHORIZED);
    }

    /**
     * Validates JSON response
     *
     * @param cityName the name of the city to be tested
     * @param apiKey   the api key
     */
    public void checkAPIResponseData(String cityName, String apiKey) {
        RestAssured.given().
                when().
                get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey)).
                then().
                statusCode(HttpURLConnection.HTTP_OK).
                body("name", equalTo(cityName)).
                body("sys.country", equalTo("LT")).
                body("any {it.key == 'id'}", is(notNullValue()));
    }
}
