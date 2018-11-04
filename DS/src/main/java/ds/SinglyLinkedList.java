public class SinglyLinkedList {

    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public void insertNode(int nodeData) {

        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
        if(head == null) {
            head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }


    void printSinglyLinkedList(SinglyLinkedListNode node) {

        while (node!=null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    class SinglyLinkedListNode {


        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

    }


}
