public class MyLinkedList {

    // Declaring the head of the list with a head as null.
    public Node head = null;
    private int size = 0;


    /**
     * This method adds a node to the front of the list.
     *
     * @param element Takes in the value to be added to the node.
     */
    public void add(int element) {
        Node node = new Node(element); // Creating a new node with the value passed in.
        if (head == null) { // If the head is null, then the node is the head.
            head = node;
        } else { // If the head is not null, then the node is added to the front of the list.
            node.setNext(head);
            head = node;
        }
        size++;
    }

    /**
     * This method adds a node after a given value.
     *
     * @param element Takes in the value to be added to the node.
     * @param after   Takes in the value after which the node is to be added.
     */
    public void addAfter(int element, int after) {
        Node node = new Node(element);
        if (head == null) { // If the head is null, then the node is the head.
            head = node;
            return;
        }
        Node temp = head;
        while (temp != null) { // While the value is not null, loop through the list.
            if (temp.element == after) { // If the after value is found, then add the node after it.
                node.setNext(temp.getNext());
                temp.setNext(node);
                size++;
                break;
            }
            if (temp.getNext() == null) { // If the next value is null, after value is not found and print that the value is not found.
                System.out.println("Target element not found, adding to the end");
                temp.setNext(node);
                size++;
                return;
            } else {
                temp = temp.getNext(); // If the after value is not found, then move to the next node.
            }
        }
    }

    /**
     * This method removes a node from the list based on the value given.
     * If there are multiple nodes with the same value, it removes the first node.
     *
     * @param element value to be removed as a node.
     */
    public void remove(int element) {
        if (head == null) { // If the head is null, then the list is empty, print that the list is empty and return.
            System.out.println("List is empty");
            return;
        }
        Node temp = head; // Creating a temporary node to store the head.
        while (temp != null) { // While the value is not null, loop through the list.
            if (temp.element == element) { // If the value is found at the first element in the list, then remove it.
                head = temp.getNext();
                size--;
                break;
            }
            if (temp.getNext().element == element) { // If the next value is the value to be removed, then remove it.
                temp.setNext(temp.getNext().getNext());
                size--;
                break;
            }
            if (temp.getNext() == null) { // If the next value is null, then the value is not found and print that the value is not found.
                System.out.println("Target element not found");
                return;
            } else {
                temp = temp.getNext(); // If the value is not found and the next one is not null, then move to the next node.
            }
        }
    }

    /**
     * This method is used to get the size of the list (number of nodes).
     *
     * @return size returns the size of the list.
     */
    public int size() {
        /** I first had this method with a while loop. I then changed it to only return the size variable.
         * This is the better and faster way to do it.
         */
//        int size = 0; // Declaring the size of the list.
//        Node temp = head; // Creating a temporary node to store the head.
//        while (temp != null) { // While the value is not null, loop through the list and increment the size.
//            size++;
//            temp = temp.getNext();
//        }
        return size; // Return the size of the list.
    }

    /**
     * This method is used to check if the list is empty.
     *
     * @param value value to be checked in the list.
     * @return true if the list contains the given value, false if list does not contain the value.
     */
    public boolean contains(int value) {
        if (head == null) { // If the head is null, then the list is empty and return false.
            return false;
        }
        Node temp = head; // Creating a temporary node to store the head.
        while (temp != null) { // While the value is not null, loop through the list.
            if (temp.element == value) { // If the value is found, then return true.
                return true;
            }
            temp = temp.getNext();
        }
        return false; // If the value is not found, then return false.
    }

    /**
     * This method is used to print out the list using the toString method.
     *
     * @return value the value of the list in string format.
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(); // Declaring the result stringbuilder.
        if (head == null) { // If the head is null, then the list is empty and return an empty string.
            return "";
        }
        Node temp = head; // Creating a temporary node to store the head.
        while (temp != null) { // While the value is not null, loop through the list and add the value to the result stringbuilder.
            result.append(temp.element).append("->");
            temp = temp.getNext();
        }
        return result.toString(); // Return the result stringbuilder.

        /* The code below was my first toString method but after reading the book (page 18, Data Structures and Algorithms in Java, 6th Edition),
         *I went for a StringBuilder method.
         * This is the better and faster way to do it.
         * It is easier on the memory.
         */
//        String result = ""; // Declaring the result string.
//        Node temp = head; // Creating a temporary node to store the head.
//        while (temp != null) { // While the value is not null, loop through the list and add the value to the result string.
//            result += temp.element + "->";
//            temp = temp.getNext();
//        }
//        return result; // Return the result string.
    }

    /**
     * This method is used to compare two lists.
     *
     * @param list  first list to be compared.
     * @param list2 second list to be compared.
     * @return true if the lists are equal, false if the lists are not equal.
     */
    public boolean compare(MyLinkedList list, MyLinkedList list2) {
        if (list.size() != list2.size() || list.head == null || list2.head == null) { // If the size of the lists are not equal or if lists are empty then return false.
            return false;
        }
        Node temp = list.head; // Creating a temporary node to store the head of the first list.
        Node temp2 = list2.head; // Creating a temporary node to store the head of the second list.
        while (temp != null) { // While the value is not null, loop through the list and compare the values.
            if (temp.element != temp2.element) { // If the values are not equal, then return false.
                return false;
            }
            temp = temp.getNext();
            temp2 = temp2.getNext();
        }
        return true; // If all the values are equal in the same order, then return true.
    }

    /**
     * This method is used to add a node in order.
     * The given value is added in the list in ascending order.
     *
     * @param value value to be added to the list.
     */
    public void addInOrder(int value) {
        Node node = new Node(value); // Creating a new node with the given value.
        if (head == null) { // If the head is null, then the node is the head.
            head = node;
        }
        Node temp = head; // Creating a temporary node to store the head.
        while (temp != null) { // While the value is not null, loop through the list.
            if ((temp.getNext() == null && node.element > temp.element) || (node.element >= temp.element && temp.getNext().element > node.element)) { // If the next value is null and the new value is bigger than the current, then add the node at the end.
                node.setNext(temp.getNext());
                temp.setNext(node);
                return;
            }
            if (node.element >= temp.element && temp.getNext().element > node.element) { // If the new value is bigger than or equal to the current and the next value is bigger than the new value, then add the node in between.
                node.setNext(temp.getNext());
                temp.setNext(node);
                return;
            }
            temp = temp.getNext(); // If the new value is not bigger than the current, then move to the next node.
        }
    }
}
