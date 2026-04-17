package steps.ui;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import pages.MoneyTransferPage;

import java.util.List;
import java.util.Map;

public class MoneyTransferUiSteps {
    private final MoneyTransferPage moneyTransferPage;
    private String pageText;

    public MoneyTransferUiSteps(Page page) {
        this.moneyTransferPage = new MoneyTransferPage(page);
    }

    public MoneyTransferUiSteps navigateToMoneyTransferPage() {
        moneyTransferPage.navigate();
        return this;
    }

    public MoneyTransferUiSteps capturePageText() {
        moneyTransferPage.systemsSection.first().waitFor();
        pageText = moneyTransferPage.pageBody.innerText();
        return this;
    }

    public MoneyTransferUiSteps assertAllApiSystemsDisplayed(List<String> apiSystemNames) {
        for (String systemName : apiSystemNames) {
            Assert.assertTrue(
                    pageText.contains(systemName),
                    "API system is not displayed on UI: " + systemName
            );
        }
        return this;
    }

    public MoneyTransferUiSteps assertCurrenciesDisplayed(Map<String, List<String>> apiCurrenciesBySystem) {
        for (Map.Entry<String, List<String>> entry : apiCurrenciesBySystem.entrySet()) {
            String systemName = entry.getKey();
            List<String> currencies = entry.getValue();

            Assert.assertTrue(pageText.contains(systemName),
                    "System name not found in UI text: " + systemName);

            for (String currency : currencies) {
                Assert.assertTrue(
                        pageText.contains(currency),
                        "Currency " + currency + " for system " + systemName + " is not displayed in UI"
                );
            }
        }
        return this;
    }
}