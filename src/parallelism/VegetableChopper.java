package parallelism;

public class VegetableChopper extends Thread {

    public int vegetable_count = 0;
    public static boolean chopping = true;

    public VegetableChopper(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        while(chopping){
            System.out.println(this.getName()+" chopped a vegetable!");
            vegetable_count++;
        }
    }
}
