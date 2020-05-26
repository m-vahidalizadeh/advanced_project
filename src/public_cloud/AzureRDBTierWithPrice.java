package public_cloud;

public class AzureRDBTierWithPrice implements Comparable<AzureRDBTierWithPrice> {

    private AzureRDBTiers tier;
    private Double costPerDtu;

    public AzureRDBTierWithPrice(AzureRDBTiers tier, double costPerDtu) {
        this.tier = tier;
        this.costPerDtu = costPerDtu;
    }

    public AzureRDBTiers getTier() {
        return tier;
    }

    public Double getCostPerDtu() {
        return costPerDtu;
    }

    @Override
    public int compareTo(AzureRDBTierWithPrice t) {
        return getCostPerDtu().compareTo(t.getCostPerDtu());
    }

}
