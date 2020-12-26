package module;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove() {}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
         Bag<Integer> bag = new Bag<>();
         bag.add(7);
         bag.add(4);
         bag.add(5);
         System.out.println(bag.size());
         System.out.println(bag.isEmpty());
         for(Integer num: bag){
             System.out.println(num);
         }
    }
}
