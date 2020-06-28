package public_cloud.finding_resize_target;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import public_cloud.finding_resize_target.AzureMultiDimensionsRDBTiers;
import public_cloud.finding_resize_target.AzureRDBTiers;

public class AzureMultiDimensionsRDBTiersTest {

    AzureMultiDimensionsRDBTiers m;
    private final static long GB = 1024L;
    private final static long TB = GB * GB;

    @BeforeEach
    public void initialize() {
        m = new AzureMultiDimensionsRDBTiers();
    }

    /**
     * BASIC:
     * DTU (0 to 5), Storage mb (100 mb to 2 gb)
     * 0, 100
     * 2, 1024 (1 gb)
     * 5, 2048 (2 gb)
     */
    @Test
    public void testFindMinTierBasic() {
        Assertions.assertEquals(AzureRDBTiers.BASIC, m.findMinTier(0, 100).get());
        Assertions.assertEquals(AzureRDBTiers.BASIC, m.findMinTier(2, 1024).get());
        Assertions.assertEquals(AzureRDBTiers.BASIC, m.findMinTier(5, 2048).get());
    }

    /**
     * STANDARD:
     * DTU (10 to 3000), Storage mb (100 mb to 250 gb)
     * 6, 1024 (1 gb)
     * 10, 1024 (1 gb)
     * 2500, 102_400 (100 gb)
     * 3000, 256_000 (250 gb)
     */
    @Test
    public void testFindMinTierStandard() {
        Assertions.assertEquals(AzureRDBTiers.STANDARD, m.findMinTier(6, 1024).get());
        Assertions.assertEquals(AzureRDBTiers.STANDARD, m.findMinTier(10, 1024).get());
        Assertions.assertEquals(AzureRDBTiers.STANDARD, m.findMinTier(2500, 102_400).get());
        Assertions.assertEquals(AzureRDBTiers.STANDARD, m.findMinTier(3000, 256_000).get());
    }

    /**
     * PREMIUM:
     * DTU (125 to 4000), Storage mb (100 mb to 1 tb)
     * 3001, 100
     * 4, 256_100 (250.1 gb)
     * 3900, 1_000_000 (976.56 gb)
     * 4000, 1_048_576 (1 tb)
     */
    @Test
    public void testFindMinTierPremium() {
        Assertions.assertEquals(AzureRDBTiers.PREMIUM, m.findMinTier(3001, 100).get());
        Assertions.assertEquals(AzureRDBTiers.PREMIUM, m.findMinTier(4, 256_100).get());
        Assertions.assertEquals(AzureRDBTiers.PREMIUM, m.findMinTier(3900, 1_000_000).get());
        Assertions.assertEquals(AzureRDBTiers.PREMIUM, m.findMinTier(4000, 1_048_576).get());
    }

    /**
     * Storage steps
     * BASIC
     * 100mb, 500mb, 1GB, 2GB
     * STANDARD
     * 250GB, 300GB, 400GB, 500GB, 750GB, 1TB
     * PREMIUM
     * 250GB, 300GB, 400GB, 500GB, 750GB, 1TB, 2TB,3TB, 4TB
     */
    @Test
    public void testGetDesiredStorageDemand() {
        Assertions.assertEquals(250 * GB, m.getDesiredStorageDemand(200, AzureRDBTiers.STANDARD).get());
        Assertions.assertEquals(250 * GB, m.getDesiredStorageDemand(1, AzureRDBTiers.STANDARD).get());
    }

    /**
     * DTU steps
     * BASIC
     * 5
     * STANDARD
     * 10,20,50,100,400,800,1600,3000
     * PREMIUM
     * 125,250,500,1000,1750,4000
     */
    @Test
    public void testGetDesiredDtuDemand() {
        Assertions.assertEquals(3000L, m.getDesiredDtuDemand(1650, AzureRDBTiers.STANDARD).get());
        Assertions.assertEquals(4000L, m.getDesiredDtuDemand(3900, AzureRDBTiers.PREMIUM).get());
    }

}
