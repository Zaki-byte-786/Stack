class stack{
int [] array = new int[5];
int size = array.length;
int idx = 0;
void push(int x){
    if (idx == size){
        System.out.println("Stack is full!");
    }
    array[idx] = x;
    idx++;
}
int peek(){
    if (idx == 0){
        System.out.println("Stack is empty");
        return -1;
    }
    return array[idx - 1];
}
int pop(){
    if (idx == 0){
        System.out.println("Stack is empty!");
    }
    int top = array[idx - 1];
    array[idx - 1] = 0;
    idx--;
    return top;
}
void display(){
    if (idx == 0){
        System.out.println("stack is empty!");
    }
    for (int i = 0; i <= idx - 1 ; i++) {
        System.out.print(array[i]+" ");
    }
    System.out.println();
}
int size(){
    return idx;  // because the size is defined by the element present in stack e.g 1 2 3 0 0 so size = 3
}
boolean isEmpty(){
    if (idx == 0)return true;
    return false;
}
boolean isFull(){
    if (idx == array.length)return true;
    return false;
}

}
public class stackImplementationUsingArray {
    public static void main(String[] args) {
        stack s = new stack();
s.push(1);
s.display();
s.push(2);
s.display();
        s.push(3);
        s.display();
        s.push(4);
        s.display();
        s.pop();
        s.display();
        System.out.println(s.peek());




    }
}
