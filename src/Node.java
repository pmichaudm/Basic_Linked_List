public class Node {

    // Declaring the variables, element and next, which contain the value of the node and the pointer to the next node in the list.
    public int element;
    private Node next;


    /**
     * Constructor for the Node class.
     * This method takes in an element and sets the current Node's element to that value.
     * It also sets the next pointer to null.
     * @param element
     */
    public Node(int element) {
        this.element = element;
        this.next = null;
    }

    /**
     * This method sets the next pointer to the node passed in.
     * This method take in a node and sets the next pointer of that node.
     * @param node Takes in the node to which you want to set the pointer.
     */
    public void setNext(Node node) {
        this.next = node;
    }

    /**
     * This method returns the next pointer of the current node.
     * @return this.next
     */
    public Node getNext() {
        return this.next;
    }
}
