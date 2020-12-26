package ExerciseAnswer.C2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SentinelQuick{
    public static void sort(Comparable[] a){
        //StdRandom.shuffle(a);
        int N = a.length, index = 0;
        //通过将数组的最大元素放到数组的最后面可以(哨兵),可以使免去while里面的判断条件
        //内部子数组的右边界可以用左子数组的左边界充当哨兵
        Comparable max = a[0];
        for(int i=0; i < N; i++)
            if(less(max, a[i])) {max = a[i]; index = 0;}
//        StdOut.println("the max is " + max + ", index is " + index);
        exch(a, index, N-1);
        show(a);
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, 0, j-1);
        sort(a, j+1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];
//        StdOut.println("the v is " + v + ", the lo is " + lo);
        while(true){
            while(less(a[++i], v));// if(i == hi) break;
            while(less(v, a[--j]));
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a) {
        for (Comparable comparable : a)
            System.out.print(comparable + " ");
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}





