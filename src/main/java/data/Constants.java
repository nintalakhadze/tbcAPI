package data;

public class Constants {
    public static final String API_BASE_URL = "https://apigw.tbcbank.ge";
    public static final String UI_BASE_URL = "https://tbcbank.ge";

    public static final String MONEY_TRANSFER_SYSTEMS_ENDPOINT =
            "/api/v1/moneyTransfer/systems?locale=ka-GE";

    public static final String MONEY_TRANSFER_UI_URL =
            UI_BASE_URL + "/ka/other-products/money-transfers";

    public static final String TREASURY_PRODUCTS_UI_URL =
            UI_BASE_URL + "/ka/treasury-products";

    public static final String TREASURY_COMMERCIAL_LIST_ENDPOINT =
            "/api/v1/exchangeRates/commercialList?locale=ka-GE";

    public static final String TREASURY_FORWARD_RATES_ENDPOINT =
            "/api/v1/forwardRates/getForwardRates?locale=ka-GE";

    public static final String TREASURY_USD_GEL_RATE_ENDPOINT =
            "/api/v1/exchangeRates/getExchangeRate?Iso1=USD&Iso2=GEL";
}
