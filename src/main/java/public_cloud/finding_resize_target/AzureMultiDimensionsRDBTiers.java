package public_cloud.finding_resize_target;

import java.util.*;

public class AzureMultiDimensionsRDBTiers {

    private Map<AzureRDBTiers, AzureRDBTierThresholds> tiersThresholdMap;
    private PriorityQueue<AzureRDBTierWithPrice> tiersSortedByPrice;
    private Map<AzureRDBTiers, PriorityQueue<Long>> dtuOptions;
    private Map<AzureRDBTiers, PriorityQueue<Long>> storageOptions;
    private final static long GB = 1024L;
    private final static long TB = GB * GB;

    AzureMultiDimensionsRDBTiers() {
        tiersThresholdMap = new HashMap<>();
        tiersSortedByPrice = new PriorityQueue<>();
        dtuOptions = new HashMap<>();
        storageOptions = new HashMap<>();
        initializeTiers();
    }

    private void initializeTiers() {
        // This should be done dynamically
        /*
        Basic DTU: 5 to 5 Storage: 100 mb to 2 GB (2048 mb)
        Standard DTU: 5 to 5 Storage: 100 mb to 250 GB (256_000 mb)
        Premium DTU: 5 to 5 Storage: 100 mb to 1 TB (1_048_576 mb)
         */
        tiersThresholdMap.put(AzureRDBTiers.BASIC, new AzureRDBTierThresholds(5, 2048));
        tiersThresholdMap.put(AzureRDBTiers.STANDARD, new AzureRDBTierThresholds(3000, 256_000));
        tiersThresholdMap.put(AzureRDBTiers.PREMIUM, new AzureRDBTierThresholds(4000, 1_048_576));
        /*
        Basic: 1 USD
        STANDARD: 1.50 USD
        PREMIUM: 3.72
         */
        tiersSortedByPrice.add(new AzureRDBTierWithPrice(AzureRDBTiers.BASIC, 1));
        tiersSortedByPrice.add(new AzureRDBTierWithPrice(AzureRDBTiers.STANDARD, 1.50));
        tiersSortedByPrice.add(new AzureRDBTierWithPrice(AzureRDBTiers.PREMIUM, 3.72));
        /*
        Storage steps
        BASIC
        100mb, 500mb, 1GB, 2GB
        STANDARD
        250GB, 300GB, 400GB, 500GB, 750GB, 1TB
        PREMIUM
        250GB, 300GB, 400GB, 500GB, 750GB, 1TB, 2TB,3TB, 4TB
         */
        storageOptions.put(AzureRDBTiers.BASIC, new PriorityQueue<>(List.of(100L, 500L, 1 * GB, 2 * GB)));
        storageOptions.put(AzureRDBTiers.STANDARD, new PriorityQueue<>(List.of(250 * GB, 300 * GB, 400 * GB, 500 * GB, 750 * GB, 1 * TB)));
        storageOptions.put(AzureRDBTiers.PREMIUM, new PriorityQueue<>(List.of(250 * GB, 300 * GB, 400 * GB, 500 * GB, 750 * GB, 1 * TB, 2 * TB, 3 * TB, 4 * TB)));
        /*
        DTU steps
        BASIC
        5
        STANDARD
        10,20,50,100,400,800,1600,3000
        PREMIUM
        125,250,500,1000,1750,4000
         */
        dtuOptions.put(AzureRDBTiers.BASIC, new PriorityQueue<>(List.of(5L)));
        dtuOptions.put(AzureRDBTiers.STANDARD, new PriorityQueue<>(List.of(10L, 20L, 50L, 100L, 400L, 800L, 1600L, 3000L)));
        dtuOptions.put(AzureRDBTiers.PREMIUM, new PriorityQueue<>(List.of(125L, 250L, 500L, 1000L, 1750L, 4000L)));
    }

    /**
     * Gets the min tier which can fit the demand.
     *
     * @param dtuDemand     dtuDemand in units
     * @param storageDemand storage demand in mb
     * @return The min tier which can fit demand
     */
    public Optional<AzureRDBTiers> findMinTier(long dtuDemand, long storageDemand) {
        PriorityQueue<AzureRDBTierWithPrice> tempTiersSortedByPrice = new PriorityQueue<>(tiersSortedByPrice);
        while (!tempTiersSortedByPrice.isEmpty()) {
            AzureRDBTiers tier = tempTiersSortedByPrice.poll().getTier();
            if (canSatisfyBothDemands(dtuDemand, storageDemand, tier)) return Optional.of(tier);
        }
        return Optional.empty();
    }

    private boolean canSatisfyBothDemands(long dtuDemand, long storageDemand, AzureRDBTiers tier) {
        AzureRDBTierThresholds tierAzureRDBTierThresholds = tiersThresholdMap.get(tier);
        return dtuDemand <= tierAzureRDBTierThresholds.getDtuMax() && storageDemand <= tierAzureRDBTierThresholds.getStorageMax();
    }

    public Optional<Long> getDesiredDtuDemand(long dtuDemand, AzureRDBTiers desiredTier) {
        PriorityQueue<Long> availableDTUOptions = new PriorityQueue<>(dtuOptions.get(desiredTier));
        while (!availableDTUOptions.isEmpty()) {
            long currentDTUOption = availableDTUOptions.poll();
            if (dtuDemand <= currentDTUOption) return Optional.of(currentDTUOption);
        }
        return Optional.empty();
    }

    public Optional<Long> getDesiredStorageDemand(long storageDemand, AzureRDBTiers desiredTier) {
        PriorityQueue<Long> availableStorageOptions = new PriorityQueue<>(storageOptions.get(desiredTier));
        while (!availableStorageOptions.isEmpty()) {
            long currentStorageOption = availableStorageOptions.poll();
            if (storageDemand <= currentStorageOption) return Optional.of(currentStorageOption);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        AzureMultiDimensionsRDBTiers m = new AzureMultiDimensionsRDBTiers();
        AzureRDBTiers result1 = m.findMinTier(4, 1024).get();
        System.out.println(result1);
        AzureRDBTiers result2 = m.findMinTier(200, 10_240).get();
        System.out.println(result2);
        AzureRDBTiers result3 = m.findMinTier(3001, 102400).get();
        System.out.println(result3);
    }

}
