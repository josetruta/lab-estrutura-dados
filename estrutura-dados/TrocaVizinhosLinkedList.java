class TrocaVizinhosLinkedList {
    
}

class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size += 1;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size += 1;
    }

    public void add(int index, int value) {
        if (index == 0) this.addFirst(value);
        else if (index == this.size - 1) this.addLast(value);
        else {
            Node newNode = new Node(value);
            Node aux = this.head;

            for (int i = 0; i < index - 1; i++) aux = aux.next;

            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;
            
            this.size += 1;
        }
    }

    public int getFirst() {
        return this.head.value;
    }

    public int getLast() {
        return this.tail.value;
    }

}

class Node {

    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}