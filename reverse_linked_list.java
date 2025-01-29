public class reversell {
    class linkedlist{
        Node head;
        class Node{
            String data;
            Node next;
            Node(String data){
                this.data=data;
                this.next=null;
            }
        }
        public void reverse(){
            if(head==null || head.next==null){
                return;
            }
          Node prev=head;
          Node curr=head.next;
          while(curr!=null){
              Node next=curr.next;
              curr.next=prev;
              //update
              prev=curr;
              curr=next;
          }
          head.next=null;
          head=prev;
        }
        public void printlist(){
            Node curr=head;
            if(head==null){
                System.out.println("list is empty");
                return;
            }
            while(curr.next!=null){
                System.out.print(curr.data+"->");
                curr=curr.next;
            }
            System.out.println("null");
        }
        public static void main(String args[]){
           reversell ll=new reversell();
           ll.reverse();
           ll.printlist();
        }
    
}
}
