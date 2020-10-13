package java_versions.java15;

public class ShowFirstParagraph {

    public static void main(String[] args) {
        var longStream = """
                My name is Mohammad.
                My brother name is Ali.
                My father name is Majid.
                """;
        var index = longStream.indexOf(System.lineSeparator());
        var firstParagraph = longStream.substring(0, index);
        System.out.println(firstParagraph);
    }

}
