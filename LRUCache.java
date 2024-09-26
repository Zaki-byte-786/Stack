import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer,Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    class Node {
        Node prev,next;
        int key,val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    void put(int key,int val){
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        if (map.size() == capacity)remove(tail.prev);
        Node x = new Node(key,val);
        insert(x);
    }
    int get(int key){
        if (map.containsKey(key)){
            Node x = map.get(key);
        remove(x);
        insert(x);
       return x.val;
        }
        else return -1;
    }
    void insert(Node node){
        map.put(node.key,node);
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    void remove(Node node){
map.remove(node.key,node);
node.prev.next = node.next;
node.next.prev = node.prev;
    }
    public static void main(String[] args) {
        LRUCache lr = new LRUCache(2);
        lr.put(1,1);
        lr.put(2,2);
        System.out.println(lr.get(1)); // 1
        lr.put(3,3);
        System.out.println(lr.get(1)); // 1
        System.out.println(lr.get(2)); // -1
        lr.put(4,4);
        System.out.println(lr.get(3)); // -1
    }
}
