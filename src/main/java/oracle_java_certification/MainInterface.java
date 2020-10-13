package oracle_java_certification;

interface MainInterface {

    default String message() {
        return "Hello!";
    }

    static void print() {
        System.out.println("Hello!");
    }

    abstract void print2();

}
