package oracle_java_certification;

public class DecisionConstructsDemo {

    public static void main(String[] args) {
        // Example 1
        int score = 65;
        if (score >= 60) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        // Example 2
        boolean x = false;
        if (x = false) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
        // Example 3
        score = 4;
        String message = null;
        if (score >= 4) {
            message = "Good job!";
        } else if (score < 4) {
            message = "Decent job.";
        }
        System.out.println(message);
        // Example 4
        score = 2;
        String comment = score >= 4 ? "Excellent job!" : score >= 3 ? "Good job!" : "Good try!";
        System.out.println(comment);
        // Example 5
        Integer[] a = {1, 3, 5, null, 7};
        Integer[] b = {null, 12, 11, 10, 7};
        boolean result = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                if (b[i] == null) result = true;
            } else {
                result = a[i].equals(b[i]);
            }
        }
        System.out.println(result);
        // Example 6
        Character c = 'A';
        switch (c) {
            case 'A':
                System.out.println("Excellent job!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            default:
                System.out.println("Decent job!");
        }
        // Example 7
        int days = 0, month = 6;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 6:
            case 7:
                days = 31;
                break;
            case 2:
                days = 28;
                break;
            default:
                days = 30;
        }
        System.out.println(days);
    }

}
