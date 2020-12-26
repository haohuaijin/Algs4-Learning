package ExerciseAnswer.C2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import module.sort.Insertion;

public class MergeOP {
    private static final int MaxInsertionNumber = 15;

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
            else                           dst[k] = src[i++];
        }
    }

    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        //1. 小数组用插入
        if (hi <= lo + MaxInsertionNumber) {
            Insertion.sort(dst, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        //3. 在递归中交换参数
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid])) { //2. 检测数组是不是已经有序,有序就将排序好的copy会dst数组
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        //3. 在递归中交换参数
        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    private static void show(Object[] a) {
        for (Object o : a) {
            StdOut.print(o + " ");
        }
    }

   public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }
}
