package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import data.Constants;

public class MoneyTransferPage {
    private final Page page;

    public final Locator systemsSection;
    public final Locator systemsContainer;
    public final Locator pageBody;

    public MoneyTransferPage(Page page) {
        this.page = page;
        this.systemsSection = page.locator("text=გზავნილის სისტემები");
        this.systemsContainer = page.locator("body");
        this.pageBody = page.locator("body");
    }

    public void navigate() {
        page.navigate(Constants.MONEY_TRANSFER_UI_URL);
    }

}

