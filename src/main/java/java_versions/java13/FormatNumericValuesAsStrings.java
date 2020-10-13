package java_versions.java13;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatNumericValuesAsStrings {

    public static void main(String[] args) {
        var doubleValue = 10_000_000.53;

        var numF = NumberFormat.getNumberInstance();
        System.out.println("Number: " + numF.format(doubleValue));

        var intF = NumberFormat.getIntegerInstance();
        System.out.println("Number: " + intF.format(doubleValue));

        intF.setGroupingUsed(false);
        System.out.println("Number: " + intF.format(doubleValue));

        var locale = Locale.getDefault();
        var localeFormatter = NumberFormat.getNumberInstance(locale);
        System.out.println("Number: " + localeFormatter.format(doubleValue));

        var locale2 = new Locale("fa", "IR");
        var localeFormatter2 = NumberFormat.getNumberInstance(locale2);
        System.out.println("Number: " + localeFormatter2.format(doubleValue));

        var currencyFormatter = NumberFormat.getCurrencyInstance(locale2);
        System.out.println(currencyFormatter.format(doubleValue));

        var df = new DecimalFormat("$00.00");
        System.out.println(df.format(1));
    }

}
