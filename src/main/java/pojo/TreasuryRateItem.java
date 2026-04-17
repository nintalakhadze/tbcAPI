package pojo;

public class TreasuryRateItem {
    private String currencyPair;
    private String period;
    private Double buyRate;
    private Double sellRate;
    private Double officialRate;

    public TreasuryRateItem() {
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Double buyRate) {
        this.buyRate = buyRate;
    }

    public Double getSellRate() {
        return sellRate;
    }

    public void setSellRate(Double sellRate) {
        this.sellRate = sellRate;
    }

    public Double getOfficialRate() {
        return officialRate;
    }

    public void setOfficialRate(Double officialRate) {
        this.officialRate = officialRate;
    }
}