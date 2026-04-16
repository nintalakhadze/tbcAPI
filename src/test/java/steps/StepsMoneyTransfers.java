package steps;

import data.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.MoneyTransferSystem;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;

public class StepsMoneyTransfers {
    private Response response;
    private List<MoneyTransferSystem> moneyTransferSystems;
    public StepsMoneyTransfers moneyTransfersApi() {
        response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .baseUri(Constants.API_BASE_URL)
                .when()
                .get(Constants.MONEY_TRANSFER_SYSTEMS_ENDPOINT);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("mtSystem", everyItem(not(emptyOrNullString())))
                .body("name", everyItem(not(emptyOrNullString())))
                .body("imageUrl", everyItem(not(emptyOrNullString())))
                .body("currencies.flatten()", everyItem(not(emptyOrNullString())));
        return this;
    }

    public StepsMoneyTransfers deserializedTransfers(){
        this.moneyTransferSystems = Arrays.asList(response.as(MoneyTransferSystem[].class));
        return this;
    }

    public List<MoneyTransferSystem> getMoneyTransferSystems() {
        return moneyTransferSystems;
    }
}
