import java.util.Scanner;

class MinimoBST {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTMin bst = new BSTMin();
        for (int i = 0; i < seq.length; i++) bst.add(Integer.parseInt(seq[i]));

        System.out.println(bst.min());
    }
    
}

class BSTMin {
    
    private Node root;

    public BSTMin() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        if (this.isEmpty()) this.root = new Node(element);
        else {
            Node aux = this.root;

            while (aux != null) {
                if (element < aux.value) {
                    if (aux.left == null) {
                        Node newNode = new Node(element);
                        newNode.parent = aux;
                        aux.left = newNode;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        Node newNode = new Node(element);
                        newNode.parent = aux;
                        aux.right = newNode;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public String min() {
        if (this.isEmpty()) return null;
        return this.min(this.root);
    }

    private String min(Node node) {
        if (node.left == null) return Integer.toString(node.value);
        else return Integer.toString(node.value) + " " + this.min(node.left);
    }
}

class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int value) {
        this.value = value;
    }
}

