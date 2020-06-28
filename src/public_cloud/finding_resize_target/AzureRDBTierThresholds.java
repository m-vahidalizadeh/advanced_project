package public_cloud.finding_resize_target;

public class AzureRDBTierThresholds {

    private long dtuMax;
    /*
    Storage unit is mb.
     */
    private long storageMax;

    public AzureRDBTierThresholds(long dtuMax, long storageMax) {
        this.dtuMax = dtuMax;
        this.storageMax = storageMax;
    }

    public long getDtuMax() {
        return dtuMax;
    }

    public long getStorageMax() {
        return storageMax;
    }
}
