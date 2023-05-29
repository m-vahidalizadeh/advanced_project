package advanced_java_programming;

public class ThreadMain {

    public static void main(String[] args){
        Thread threadOne=new ThreadExample();
        Thread threadTwo=new ThreadExample();
        threadOne.setName("First thread");
        threadTwo.setName("Second thread");
        threadOne.start();
        threadTwo.start();
    }

}
