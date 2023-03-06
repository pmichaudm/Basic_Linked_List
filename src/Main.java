public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        MyLinkedList temp;
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list.compare(list, list2));
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        list.addInOrder(4);
        System.out.println(list.toString());
        System.out.println(list.contains(7));
    }
    /*
      I made this method before I realized we needed to make a toString method.

      public static void printList(MyLinkedList list) {

            *   I tried assigning a temps list. But it didn't work. It would only print once as I was losing the pointer.
            Here is the code I first had here:

            MyLinkedList temp = list;
            while(temp.head != null) {
                System.out.print(temp.head.element + "->");
                temp.head = temp.head.getNext();
            }
            Node tempHead = list.head;
            while(tempHead != null) {
                System.out.print(tempHead.element + "->");
                tempHead = tempHead.getNext();
            }
            System.out.println();
    }
    */
}