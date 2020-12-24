import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stopwatch;

public class Main {
    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        Bag<String> str = new Bag<>();
        str.add("world!\n");
        str.add("hello, ");
        for(String s : str)
            System.out.print(s);
        System.out.println(new Date(12, 15, 2020));
        double time = timer.elapsedTime();
        System.out.println(time);
    }
}
