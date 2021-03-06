package module.sort;

import edu.princeton.cs.algs4.StdIn;

public class Heap {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int k = N/2; k >=1; k--)
            sink(a, k, N);
        while(N > 1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public static void sink(Comparable[] a, int k, int N){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(a, j, j+1)) j++;
            if(!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    public static void show(Comparable[] a) {
        for (Comparable comparable : a)
            System.out.print(comparable + " ");
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a ,i, i - 1)) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
