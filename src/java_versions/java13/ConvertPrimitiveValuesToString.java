package java_versions.java13;

public class ConvertPrimitiveValuesToString {

    public static void main(String[] args) {
        int result = 10 + 12;
        String answer = "The answer is " + result;
        System.out.println(answer);

        String howMany = 20 + " things";
        System.out.println(howMany);

        var result2 = 10 + 20;
        System.out.println(result2);

        int intValue = 42;
        var fromInt = Integer.toString(intValue);
        System.out.println(fromInt);

        boolean boolValue = true;
        var fromBool = Boolean.toString(boolValue);
        System.out.println(fromBool);

        long longValue = 10_000_000;
        var fromLong = Long.toString(longValue);
        System.out.println(fromLong);
    }

}
