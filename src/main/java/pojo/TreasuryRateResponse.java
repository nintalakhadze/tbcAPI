package pojo;

import java.util.List;

public class TreasuryRateResponse {
    private List<TreasuryRateItem> data;

    public TreasuryRateResponse() {
    }

    public List<TreasuryRateItem> getData() {
        return data;
    }

    public void setData(List<TreasuryRateItem> data) {
        this.data = data;
    }
}