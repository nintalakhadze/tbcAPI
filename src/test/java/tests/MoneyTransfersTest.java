package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.api.MoneyTransferApiSteps;
import steps.ui.MoneyTransferUiSteps;
import utils.BaseTest;

import java.util.List;
import java.util.Map;

public class MoneyTransfersTest extends BaseTest {
    private MoneyTransferApiSteps moneyTransferApiSteps;
    private MoneyTransferUiSteps moneyTransferUiSteps;

    @BeforeMethod
    public void init() {
        moneyTransferApiSteps = new MoneyTransferApiSteps();
        moneyTransferUiSteps = new MoneyTransferUiSteps(page);
    }

    @Test
    public void validateMoneyTransferSystemsApiAndUi() {
        List<String> apiSystemNames = moneyTransferApiSteps
                .moneyTransfersApi()
                .deserializedTransfers()
                .validateBusinessRules()
                .getSystemNames();

        Map<String, List<String>> apiCurrencies = moneyTransferApiSteps.getSystemCurrenciesMap();

        moneyTransferUiSteps
                .navigateToMoneyTransferPage()
                .capturePageText()
                .assertAllApiSystemsDisplayed(apiSystemNames)
                .assertCurrenciesDisplayed(apiCurrencies);
    }
}