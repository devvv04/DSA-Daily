package LinkedList;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class SinglyLL_Intro {
     Node head;
    Node tail;
    int size = 0;
    public int get(int index) {
    if(index<0 || index>size-1) return -1;
      Node temp = head;
         for(int i =0;i<index;i++){
             temp = temp.next;
         }
    return temp.val;
     }
    public void InsertAtHead(int val){
     Node newnode = new Node(val);
     if(size==0){
         head = newnode;
         tail = newnode;
         size=1;
     }
     else{
     newnode.next = head;
     head = newnode;
     size++;
     }
    }
    public void InsertAtEnd(int val){
        Node newnode = new Node(val);
        if(size==0) head = tail = newnode;
        else{
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }
    public void InsertAtIndex(int val , int index){
        if(index==0){
            InsertAtHead(val);
            return;
        }
        else if(index == size){
            InsertAtEnd(val);
            return;
        }
        else{
        Node temp = head;
        Node nn = new Node(val);
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        nn.next = temp.next;
        temp.next = nn;
        size++;
        }
    }
 
    public void deleteAtHead(){
        if(size==0) return;
        if(size==1){
            head = tail = null;
            size = 0;
            return;
        }
        head =  head.next;
        size--;
    }
    public void deleteAtTail(){
        if(size==0) return;
        if(size==1){
          head = tail = null;
          size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<size-2;i++){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }
    }
    public void deleteAtIndex(int index){
        if(index<0 || index >= size) return;
        if(index == 0){
            deleteAtHead();
            return;
        }
        if(index == size-1){
            deleteAtTail();
            return;
        }
        else{
            Node temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
                }
                temp.next = temp.next.next;
        }
    }
    public void display(){
       Node temp = head;
       while(temp != null){
           System.out.println(temp.val);
           temp = temp.next;
       }
    }
}


class Main {
    public static void main(String[] args) {
        // Box x = new Box();
        // x.value = 2;
        // Box y = new Box();
        // y.value = x.value;
        // System.out.println(y);
        SinglyLL_Intro list = new SinglyLL_Intro();
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        list.InsertAtEnd(40);
        // int ans = list.get(3);
        // System.out.println(ans);
        // list.InsertAtHead(5);
        // int ans1 = list.get(0);
        // System.out.println(ans1);
        // System.out.println();
        // list.display();
        // list.InsertAtIndex(15,2);
        //  System.out.println();
        // list.display();
        // list.deleteAtHead();
        // System.out.println();
        // list.display();
        // list.deleteAtTail();
        list.display();
        System.out.println();
        list.deleteAtIndex(3);
        list.display();      
        // MyLinkedList list2 = new MyLinkedList();
        // int[] arr = {2,3,6,8};
        // for(int i=0;i<arr.length;i++){
        //     list2.InsertAtEnd(arr[i]);
        // }
        // list2.display();
        
    }
}
