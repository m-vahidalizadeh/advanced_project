package java_versions.java13;

public class PrimitiveVariablesDemo {

    public static void main(String[] args) {
        int classicInt = 5;
        // Inferred data type
        var myInt = 5;
        var myFloat = 5f;
        var myDouble = 5d;
        var myLong = 5L;
        // Conversions with wrappers
        String doubleValue = "156.5";
        Double doubleObj = Double.parseDouble(doubleValue);
        var byteValue = doubleObj.byteValue();
        var intValue = doubleObj.intValue();
        var floatValue = doubleObj.floatValue();
        var stringValue = doubleObj.toString();
        // Unsigned
        var unsigned = Integer.parseUnsignedInt("3000000");
        System.out.println("Unsigned value is: " + unsigned);
        var result = Integer.divideUnsigned(unsigned, 2);
        System.out.println("The result is " + result);
        // Object inferring
        var item = new ClothingItem();
        item.setType("Hat");
    }

}
