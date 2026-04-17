package pojo;

import java.util.List;

public class MoneyTransferSystem {
    private String mtSystem;
    private String name;
    private String imageUrl;
    private List<String> currencies;

    public MoneyTransferSystem() {
    }

    public String getMtSystem() {
        return mtSystem;
    }

    public void setMtSystem(String mtSystem) {
        this.mtSystem = mtSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }
}
