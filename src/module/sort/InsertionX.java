package module.sort;

import edu.princeton.cs.algs4.StdIn;

public class InsertionX {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int min = 0;

        //使用哨兵
        for(int i = 1; i < N; i++)
            if(less(a[i], a[min])) min = i;
        exch(a, 0, min);

        //不需要交换的插入排序
        for(int i = 2; i < N; i++){
            Comparable now = a[i];
            int j = i - 1;
            while(less(now, a[j])){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = now;
        }
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
