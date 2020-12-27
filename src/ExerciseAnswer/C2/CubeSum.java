package ExerciseAnswer.C2;

import edu.princeton.cs.algs4.StdOut;
import module.sort.MinPQ;

public class CubeSum {
    static class Node implements Comparable<Node>{
        int value;
        int i;
        int j;
        public Node(int i, int j){
            this.value = i*i*i + j*j*j;
            this.i = i;
            this.j = j;
        }
        public String toString() {
            return value + " = " + i + "^3" + " + " + j + "^3";
        }
        @Override
        public int compareTo(Node a) {
            return Integer.compare(this.value, a.value);
        }
    }
    //打印a^3+b^3
    public static void cubeSum(int N){
        MinPQ<Node> heap = new MinPQ<>(N);
        for(int i=0; i<N; i++)
            heap.insert(new Node(i, i)); //避免重复

        while(!heap.isEmpty()){
            Node t = heap.delMin();
            StdOut.println("( " + t.value + ", " + t.i + ", " + t.j + " )");
            if(t.j < N)
                heap.insert(new Node(t.i, t.j+1));
        }
    }
    public static void findEq(){
        int N = 1000;
        MinPQ<Node> heap = new MinPQ<>(N);
        for(int i=0; i<N; i++)
            heap.insert(new Node(i, i)); //避免重复
        Node first, second;
        second = heap.delMin();
        while(!heap.isEmpty()){
            first = heap.delMin();
            //StdOut.println("( " + first.value + ", " + first.i + ", " + first.j + " )");
            if(first.j < N)
                heap.insert(new Node(first.i, first.j+1));
            if(first.value == second.value){
                StdOut.println(first);
                StdOut.println(second);
                StdOut.println("***************************");
            }
            second = first;
        }
    }
    public static void main(String[] args){
//        cubeSum(3);
        findEq();
    }
}












