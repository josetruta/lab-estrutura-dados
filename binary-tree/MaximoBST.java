import java.util.Scanner;

class MaximoBST {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTMax bst = new BSTMax();
        for (int i = 0; i < seq.length; i++) bst.add(Integer.parseInt(seq[i]));

        System.out.println(bst.max());
    }
}

class BSTMax {
    
    private Node root;

    public BSTMax() {
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

    public String max() {
        if (this.isEmpty()) return null;
        return this.max(this.root);
    }

    private String max(Node node) {
        if (node.right == null) return Integer.toString(node.value);
        else return Integer.toString(node.value) + " " + this.max(node.right);
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


