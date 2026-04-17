package steps.ui;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import pages.TreasuryProductsPage;

public class TreasuryUiSteps {
    private final TreasuryProductsPage treasuryProductsPage;
    private String pageText;

    public TreasuryUiSteps(Page page) {
        this.treasuryProductsPage = new TreasuryProductsPage(page);
    }

    public TreasuryUiSteps navigateToTreasuryPage() {
        treasuryProductsPage.navigate();
        return this;
    }

    public TreasuryUiSteps capturePageText() {
        treasuryProductsPage.pageBody.waitFor();
        treasuryProductsPage.usdText.first().waitFor();
        pageText = treasuryProductsPage.pageBody.innerText();
        return this;
    }

    public TreasuryUiSteps validateResponseStructureOnUi() {
        Assert.assertTrue(
                pageText.contains("USD") || pageText.contains("აშშ"),
                "USD is not displayed"
        );
        Assert.assertTrue(pageText.contains("ყიდვა"), "Buy label is not displayed");
        Assert.assertTrue(pageText.contains("გაყიდვა"), "Sell label is not displayed");
        Assert.assertTrue(pageText.contains("განახლების დრო"), "Update time is not displayed");
        return this;
    }

    public TreasuryUiSteps validateUsdGelData() {
        Assert.assertTrue(
                pageText.contains("USD") || pageText.contains("აშშ"),
                "USD currency is not displayed"
        );
        Assert.assertTrue(
                pageText.contains("1 აშშ დოლარი") || pageText.contains("დოლარი"),
                "USD description is not displayed"
        );
        return this;
    }

    public TreasuryUiSteps validateNumericFields() {
        boolean containsNumber =
                pageText.matches("(?s).*\\d+\\.\\d+.*") || pageText.matches("(?s).*\\d+.*");

        Assert.assertTrue(containsNumber, "No numeric values found on treasury page");
        return this;
    }
}