package Linked_List;
import java.util.Scanner;
public class implementation {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class linkedlist{
        Node head = null, tail = null;
        int size = 0;
        void insertAtEnd(int item){
            Node temp = new Node(item);
            if(head==null){
                head = temp;
            }
            else{
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        void insertAtBeginning(int item){
            Node temp = new Node(item);
            if(head == null){
                insertAtEnd(item);
                return;
            }
            else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void insertAt(int index, int item){
            if(index == 0){
                insertAtBeginning(item);
                return;
            }
            else if(index==size){
                insertAtEnd(item);
                return;
            }
            else if(index<0 || index>size){
                System.out.println("Invalid index");
                return;
            }
            else{
                Node temp = new Node(item);
                int count=0;
                Node ptr = head;
                while(count<index-1){
                    ptr = ptr.next;
                    count++;
                }
                Node t = ptr.next;
                ptr.next = temp;
                temp.next = t;
            }
            size++;
        }

        int getElement(int index){
            if(index<0 || index>=size){
                System.out.println("Invalid index");
                return -1;
            }
            int count = 0;
            Node temp = head;
            while(count!=index){
                temp = temp.next;
                count++;
            }
            return temp.data;
        }

        void delElementAt(int index){
            if(index<0 || index>=size){
                System.out.println("Invalid index");
                return;
            }
            else if(index==0){
                head = head.next;
            }
            else if(index==size-1){
                Node t = head;
                int count = 0;
                while(count<index-1){
                    t = t.next;
                    count++;
                }
                tail = t;
                t.next = null;
            }
            else{
                Node t = head;
                int count = 0;
                while(count<index-1){
                    t = t.next;
                    count++;
                }
                t.next = t.next.next;
            }
            size--;
        }

        void display(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        linkedlist ll = new linkedlist();
        int conti = 1;
        do { 
            System.out.println("\n\nPress 1 to insert an element at the beginning");
            System.out.println("Press 2 to insert an element at the end");
            System.out.println("Press 3 to insert an element at any index");
            System.out.println("Press 4 to delete an element from any index");
            System.out.println("Press 5 to get an element at any index");
            System.out.println("Press 6 to get the size of the Linked List");
            System.out.println("Press 7 to display the Linked List");
            System.out.println("Press 0 to exit");
            int choice;
            System.out.print("\nEnter choice : ");
            choice = sc.nextInt();
            int item, pos;
            switch (choice) {
                case 1:
                    System.out.print("Enter item to be inserted : ");
                    item = sc.nextInt();
                    ll.insertAtBeginning(item);
                    break;
                case 2:
                    System.out.print("Enter item to be inserted : ");
                    item = sc.nextInt();
                    ll.insertAtEnd(item);
                    break;
                case 3:
                    System.out.print("Enter the index : ");
                    pos = sc.nextInt();
                    System.out.print("Enter item to be inserted : ");
                    item = sc.nextInt();
                    ll.insertAt(pos, item);
                    break;
                case 4:
                    System.out.print("Enter the index : ");
                    pos = sc.nextInt();
                    ll.delElementAt(pos);
                    break;
                case 5:
                    System.out.print("Enter the index : ");
                    pos = sc.nextInt();
                    System.out.println("Element at index " + pos + " = " + ll.getElement(pos));
                    break;
                case 6:
                    System.out.println("Size of the Linked List = " + ll.size);
                    break;
                case 7:
                    System.out.print("The Linked List is : ");
                    ll.display();
                    break;
                case 0:
                    conti = 0;
                    break;
                default:
                    System.out.println("WRONG CHOICE");
            }
        } while (conti == 1);
    }
}
