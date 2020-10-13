package java_versions.java15;

public class StringBlockDemo {

    public static void main(String[] args) {
        var xml1 = new StringBuilder()
                .append("<person>")
                .append(System.lineSeparator())
                .append("<firstName>Mohammad</firstName>")
                .append(System.lineSeparator())
                .append("<lastName>Vahidalizadeh</lastName>")
                .append(System.lineSeparator())
                .append("</person>").toString();
        System.out.println(xml1);

        var textBlock = """
                <person>
                    <firstName>Mohammad</firstName>
                    <lastName>Vahidalizadeh</lastName>
                </person>
                """;
        System.out.println(textBlock);
        System.out.println(textBlock.trim().toUpperCase());

        var firstName = "Mohammad";
        var lastName = "Vahidalizadeh";
        var formattedString = """
                <person>
                    <firstName>%s</firstName>
                    <lastName>%s</lastName>
                </person>
                """.formatted(firstName, lastName);
        System.out.println(formattedString);

    }

}
