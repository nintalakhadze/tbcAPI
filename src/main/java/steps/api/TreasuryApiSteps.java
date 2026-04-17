package steps.api;

import data.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class TreasuryApiSteps {
    private Response response;

    public TreasuryApiSteps getUsdGelTreasuryRate() {
        response = RestAssured
                .given()
                .baseUri(Constants.API_BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get(Constants.TREASURY_USD_GEL_RATE_ENDPOINT);

        return this;
    }

    public TreasuryApiSteps validateStatusCode() {
        response.then().statusCode(200);
        return this;
    }

    public TreasuryApiSteps printResponse() {
        System.out.println(response.asPrettyString());
        return this;
    }

    public TreasuryApiSteps validateUsdGelStructure() {
        String body = response.asPrettyString();

        Assert.assertNotNull(body, "Response body is null");
        Assert.assertFalse(body.isBlank(), "Response body is empty");

        Assert.assertTrue(
                body.contains("USD") || body.contains("usd"),
                "USD not found in response"
        );

        Assert.assertTrue(
                body.contains("GEL") || body.contains("gel"),
                "GEL not found in response"
        );

        return this;
    }

    public Response getResponse() {
        return response;
    }
}