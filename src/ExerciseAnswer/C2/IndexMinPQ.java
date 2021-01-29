package ExerciseAnswer.C2;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private int N;          //PQ中的元素数量
    private int[] pq;       //索引二叉堆，由1开始,连续存放； 堆的索引，堆的元素存放在key中
    private int[] qp;       //逆序：qp[pq[i]] = pq[qp[i]] = i; 通过索引反向找到，元素在索引二叉堆(pq)中的位置；
    private Key[] keys;     //有优先级之分的元素；根据索引可以直接查找元素

    /*
     * 在堆中的操作，使用的都是pq数组，索引二叉堆；
     * 如果只知道索引 k 的话，需要使用qp[k]，找到索引对应的元素在二叉堆里面的位置(函数change，delete)。
     * qp[i] == -1，说明索引 i 在(索引)二叉堆中没有位置， 也就是没有这个索引。
     * 传入swim和skin里面的参数，都是qp[k]或N。
     */

    public IndexMinPQ(int maxN){
        keys = (Key[]) new Comparable[maxN+1];
        pq = new int[maxN+1];
        qp = new int[maxN+1];
        for(int i=0; i<=maxN; i++) qp[i] = -1;
    }

    public boolean isEmpty() { return N == 0; }
    public boolean contains(int k) { return qp[k] != -1; }

    public void insert(int k, Key key){
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }
    public void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    public void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    public Key min() { return keys[pq[1]]; }
    public int delMin(){
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }
    public int minIndex() { return pq[1]; }
    public void change(int k, Key item){
        keys[k] = item;
        swim(qp[k]);
        sink(qp[k]);
    }
    public void delete(int k){
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    public Key look(int k){
        return keys[k];
    }

    public static void main(String[] args) {
        IndexMinPQ<String> indexMinPQ = new IndexMinPQ<>(10);
        indexMinPQ.insert(4, "A");
        indexMinPQ.insert(8, "Z");
        indexMinPQ.insert(2, "B");
        if (indexMinPQ.contains(2)) {
            indexMinPQ.change(2, "Q");
        }
        System.out.println(indexMinPQ.min());
        System.out.println(indexMinPQ.delMin());
        System.out.println(indexMinPQ.minIndex());
        System.out.println("the index 2 is " + indexMinPQ.look(2));
        indexMinPQ.delete(2);
    }
}
