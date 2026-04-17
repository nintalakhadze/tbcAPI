package steps.api;

import data.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.MoneyTransferSystem;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;

public class MoneyTransferApiSteps {
    private Response response;
    private List<MoneyTransferSystem> moneyTransferSystems;

    public MoneyTransferApiSteps moneyTransfersApi() {
        response = RestAssured
                .given()
                .baseUri(Constants.API_BASE_URL)
                .accept(ContentType.JSON)
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

    public MoneyTransferApiSteps deserializedTransfers() {
        this.moneyTransferSystems = Arrays.asList(response.as(MoneyTransferSystem[].class));
        return this;
    }

    public MoneyTransferApiSteps validateBusinessRules() {
        Assert.assertNotNull(moneyTransferSystems, "Money transfer systems list is null");
        Assert.assertFalse(moneyTransferSystems.isEmpty(), "Money transfer systems list is empty");

        for (MoneyTransferSystem system : moneyTransferSystems) {
            Assert.assertNotNull(system.getMtSystem(), "mtSystem is null");
            Assert.assertFalse(system.getMtSystem().trim().isEmpty(), "mtSystem is empty");

            Assert.assertNotNull(system.getName(), "name is null");
            Assert.assertFalse(system.getName().trim().isEmpty(), "name is empty");

            String imageUrl = system.getImageUrl();
            Assert.assertNotNull(imageUrl, "imageUrl is null");
            Assert.assertFalse(imageUrl.isBlank(), "imageUrl is empty");

            boolean isValidImageUrl =
                    imageUrl.startsWith("http") ||
                            imageUrl.startsWith("/");

            Assert.assertTrue(isValidImageUrl, "Invalid imageUrl format: " + imageUrl);

            Assert.assertNotNull(system.getCurrencies(), "currencies is null");
            Assert.assertFalse(system.getCurrencies().isEmpty(), "currencies list is empty");

            for (String currency : system.getCurrencies()) {
                Assert.assertNotNull(currency, "currency is null");
                Assert.assertFalse(currency.trim().isEmpty(), "currency is empty");
                Assert.assertTrue(currency.matches("^[A-Z]{3}$"),
                        "Currency is not in expected format: " + currency);
            }
        }

        List<String> names = getSystemNames();
        Set<String> uniqueNames = new HashSet<>(names);
        Assert.assertEquals(uniqueNames.size(), names.size(), "Duplicate system names found");

        return this;
    }

    public List<MoneyTransferSystem> getSystemsList() {
        return moneyTransferSystems;
    }

    public List<String> getSystemNames() {
        return moneyTransferSystems.stream()
                .map(MoneyTransferSystem::getName)
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> getSystemCurrenciesMap() {
        return moneyTransferSystems.stream()
                .collect(Collectors.toMap(
                        MoneyTransferSystem::getName,
                        MoneyTransferSystem::getCurrencies
                ));
    }
}