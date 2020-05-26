package java_versions.java14;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Menu(String name, BigDecimal price) {

    public String getFormattedItem() {
        return name + " costs $" + price.setScale(2, RoundingMode.CEILING);
    }

}
