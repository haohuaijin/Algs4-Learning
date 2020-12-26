package module; //如果要用命令行运行, 去掉这行

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class UF{
    private final int[] id;
    private final int[] sz;
    private int count;

    public UF(int N){
        count = N;
        id = new int[N];
        for(int i=0; i<N; i++) id[i] = i;
        sz = new int[N];
        for(int i=0; i<N; i++) sz[i] = 1;
    }
    public int count(){
        return count;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int find(int p){
        int temp = p;
        while(id[p] != p) p = id[p];
        //路径压缩
        while(id[temp] != temp) {
            int t = temp;
            temp = id[temp];
            id[t] = p;
        }
        return p;
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);

        if(i == j) return;
        if(sz[i] >= sz[j])   { id[j] = i; sz[i] += sz[j]; }
        else                { id[i] = j; sz[j] += sz[i]; }
        count--;
    }
    public void showID(){
        for(int j : id) StdOut.println(j);
    }
    public static void main(String[] args){
        int N = StdIn.readInt();
        UF uf = new UF(N);
        Stopwatch timer = new Stopwatch();
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        double time = timer.elapsedTime();
        System.out.println("the total time is " + time);
        StdOut.println(uf.count() + " components");
        /*
        uf.showID();
         */
    }
}

//路径为4，使用路径压缩的quick-union算法
//旁敲侧击
//9
//1 2
//3 4
//2 3
//5 6
//7 8
//6 7
//2 6

// 0 1 2 3 4 5 6 7 8
// 0 1 1 1 3 1 5 5 7
