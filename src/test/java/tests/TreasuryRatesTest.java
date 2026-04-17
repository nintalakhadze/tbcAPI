package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.api.TreasuryApiSteps;
import steps.ui.TreasuryUiSteps;
import utils.BaseTest;

public class TreasuryRatesTest extends BaseTest {
    private TreasuryApiSteps treasuryApiSteps;
    private TreasuryUiSteps treasuryUiSteps;

    @BeforeMethod
    public void init() {
        treasuryApiSteps = new TreasuryApiSteps();
        treasuryUiSteps = new TreasuryUiSteps(page);
    }

    @Test
    public void validateTreasuryRatesApi() {
        treasuryApiSteps
                .getUsdGelTreasuryRate()
                .validateStatusCode()
                .printResponse()
                .validateUsdGelStructure();
    }

    @Test
    public void validateTreasuryRatesUi() {
        treasuryUiSteps
                .navigateToTreasuryPage()
                .capturePageText()
                .validateResponseStructureOnUi()
                .validateUsdGelData()
                .validateNumericFields();
    }
}