package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import data.Constants;

public class TreasuryProductsPage {
    private final Page page;

    public final Locator pageBody;
    public final Locator usdText;
    public final Locator buyText;
    public final Locator sellText;
    public final Locator updateTimeText;

    public TreasuryProductsPage(Page page) {
        this.page = page;
        this.pageBody = page.locator("body");
        this.usdText = page.locator("text=USD");
        this.buyText = page.locator("text=ყიდვა");
        this.sellText = page.locator("text=გაყიდვა");
        this.updateTimeText = page.locator("text=განახლების დრო");
    }

    public void navigate() {
        page.navigate(Constants.TREASURY_PRODUCTS_UI_URL);
    }
}