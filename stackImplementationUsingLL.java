class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class stackLLImplementation{
    Node head = null;
    int size = 0;
    void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }
    int pop(){
        if (head == null){
            System.out.println("Stack is empty!");
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }
    int peek(){
        if (head == null){
            System.out.println("Stack is empty!");
            return -1;
        }
        return head.data;
    }
    void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return size == 0;  //  or simply-> (size == 0) ? true : false;
    }
}
public class stackImplementationUsingLL {

    public static void main(String[] args) {
    stackLLImplementation s = new stackLLImplementation();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.display();
        System.out.println(s.size());
        s.pop();
        s.display();
        System.out.println(s.peek());

    }
}
