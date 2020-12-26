package ExerciseAnswer.C2;
import edu.princeton.cs.algs4.StdOut;
public class BestCaseForQuick {
    public static int[] generateArray(int N){
        int[] res = new int[N];
        for(int i=0; i<N; i++)
            res[i] = i;
        randomArray(res, 0, N-1);
        return res;
    }
    public static void randomArray(int[] arr, int lo, int hi){
        if(hi - lo <= 0) return;
        int mid = lo + (hi - lo)/2;
        randomArray(arr, lo, mid-1);
        randomArray(arr, mid+1, hi);
        //将每一次切分的元素放到第一个
        exch(arr, lo, mid);
        /* 一个例子
         * 1 2 3 4
         * 2 1 3 4
         * 4 1 3 2
         * 2 1 3 4
         */
    }

    public static void exch(int[] arr, int i, int j){
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
    public static void main(String[] args){
        int[] res = generateArray(15);
        for(int i : res)
            StdOut.print(i + " ");
    }
}

