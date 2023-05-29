package advanced_java_programming;

public class ThreadExample extends Thread{

    @Override
    public void run(){
        System.out.println("Hello world from "+this.getName());
    }

}
