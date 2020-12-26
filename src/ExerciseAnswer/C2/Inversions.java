package ExerciseAnswer.C2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Inversions {
    private static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
        long inversions = 0;

        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j] < aux[i]) { a[k] = aux[j++]; inversions += (mid - i + 1); }
            else                        a[k] = aux[i++];
        }
        return inversions;
    }

    // return the number of inversions in the subarray b[lo..hi]
    // side effect b[lo..hi] is rearranged in ascending order
    private static long count(int[] a, int[] aux, int lo, int hi) {
        long inversions = 0;
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        inversions += count(a, aux, lo, mid);
        inversions += count(a, aux, mid+1, hi);
        inversions += merge(a, aux, lo, mid, hi);
        return inversions;
    }

    /**
     * Returns the number of inversions in the integer array.
     * The argument array is not modified.
     * @param  a the array
     * @return the number of inversions in the array. An inversion is a pair of
     *         indicies {@code i} and {@code j} such that {@code i < j}
     *         and {@code a[i] > a[j]}.
     */
    public static long count(int[] a) {
        int[] aux = new int[a.length];
        System.arraycopy(a, 0, aux, 0, a.length);
        return count(a, aux, 0, a.length - 1);
    }

    /**
     * Reads a sequence of integers from standard input and
     * prints the number of inversions to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        StdOut.println(Inversions.count(a));
    }
}