package random;

public class _AddTwoSortedLists {
    public static void main(String[] args) {
        LinkedListDummy l1 = new LinkedListDummy();
        LinkedListDummy l2 = new LinkedListDummy();
        l1.addNumbers(new int[]{1, 3, 5, 7});
        l2.addNumbers(new int[]{2, 4, 6, 8});

        l1.printList();
        l2.printList();

        LinkedListDummy mergeList = addTwoSortedLists(l1, l2);
        mergeList.printList();
    }

    public static LinkedListDummy addTwoSortedLists(LinkedListDummy l1, LinkedListDummy l2){

        LinkedListDummy merged = new LinkedListDummy();
        Node current1 = l1.head.next;
        Node current2 = l2.head.next;
        Node current = new Node(0);
        merged.head = current;

        System.out.println();
        while (current1 != null && current2 != null) {
            //System.out.println("Inside loop :-> "+current1.data +"<"+current2.data);
            if (current1.data < current2.data) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }

        while (current1 != null) {
            //System.out.println("List1 uncompleted loop :-> "+current.data);
            current.next = current1;
            current1 = current1.next;
            current = current.next;
        }

        while (current2 != null) {
            //System.out.println("List2 uncompleted loop :-> "+current.data);
            current.next = current2;
            current2 = current2.next;
            current = current.next;
        }

        return merged;
    }
}

class LinkedListDummy{

    Node head;
    int size;

    LinkedListDummy(){
        this.head = new Node(0);
    }

    public void addNumbers(int[] nums){
        //System.out.println("Adding nums to list");
        Node current = head;

        for(int i = 0; i < nums.length; i++){
            current.next = new Node(nums[i]);
            current = current.next;
            ++size;
        }
    }

    public void printList() {
        Node current = head.next;
        System.out.println("\nTraversing List");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public int getSizeOfLinkedList(){
        return this.size;
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}