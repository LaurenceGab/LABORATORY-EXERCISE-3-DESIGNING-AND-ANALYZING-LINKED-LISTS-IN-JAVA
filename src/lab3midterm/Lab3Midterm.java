package lab3midterm;

public class Lab3Midterm {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(2);
        list.addLast(3);
        list.addFirst(1);
        System.out.println("After adding 1, 2, 3: ");
        printList(list);

        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last: ");
        printList(list);

        list.addLast(1);
        list.insertAtIndex(1, 2);
        System.out.println("After inserting 2 at index 1: ");
        printList(list);

        list.deleteAtIndex(1);
        System.out.println("After deleting index 1: ");
        printList(list);

        System.out.println("Value at index 0: " + list.get(0));
        System.out.println("Contains 1: " + list.contains(1));

        System.out.println("Size: " + list.size());

        list.addLast(2);
        list.addLast(3);
        list.reverse();
        System.out.println("After reversing: ");
        printList(list);

        list.swapNodes(0, 2);
        System.out.println("After swapping index 0 and 2: ");
        printList(list);
    }

    public static void printList(DoublyLinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
