package deep_dive;

public class BetterArrayListDemo {

    public static void main(String[] args) {
        BetterArrayList al = new BetterArrayList();
        al.add("Mohammad");
        al.add("Ali");
        al.add("Mahnaz");
        al.print();
        System.out.println(al.pop());
    }

}
