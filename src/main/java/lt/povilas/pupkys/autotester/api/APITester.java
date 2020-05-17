package lt.povilas.pupkys.autotester.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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
     */
    public void checkGoodApiResponse(String cityName, String apiKey) {
        Response response = RestAssured.given().
                when().
                get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey)).
                then().
                statusCode(HttpURLConnection.HTTP_OK).
                extract().response();
    }

    /**
     * Checks if response is HTTP_UNAUTHORIZED
     */
    public void checkBadApiResponse(String cityName, String apiKey) {
        Response response = RestAssured.given().
                when().
                get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey)).
                then().
                statusCode(HttpURLConnection.HTTP_UNAUTHORIZED).
                extract().response();
    }

    /**
     * Validates JSON response
     */
    public void checkAPIResponseData(String cityName, String apiKey) {
        Response response = RestAssured.given().
                when().
                get(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey)).
                then().
                statusCode(HttpURLConnection.HTTP_OK).
                body("name", equalTo(cityName)).
                body("sys.country", equalTo("LT")).
                body("any {it.key == 'id'}", is(notNullValue())).
                extract().response();
    }
}
