package java_versions.java13;

public class ParsingStringValues {

    public static void main(String[] args) {
        var s1 = "Welcome to New york!";
        System.out.println("length of string: " + s1.length());

        int position = s1.indexOf("New");
        System.out.println("The position is " + position);

        var sub = s1.substring(11);
        System.out.println(sub);

        String s2 = "Welcome!          ";
        var len = s2.length();
        System.out.println(len);

        var trimmed = s2.trim();
        System.out.println(trimmed.length());
    }

}
