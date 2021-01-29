package ExerciseAnswer.C2;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    private Key min;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    //modify
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
        if(N == 1) min = v;
        else if(less(v, min)) min = v;
    }

    //modify
    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if(N == 0) min = null;
        return max;
    }
    //modify
    public Key min(){
        return min;
    }

    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(Key i, Key j){
        return i.compareTo(j) < 0;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> heap = new MaxPQ<>(10);
        for(int i=1; i<10; i++)
            heap.insert(i);
        StdOut.println(heap.min());
    }
}

