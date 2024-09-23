import java.util.Scanner;

class AlturaBST {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTHeight bst = new BSTHeight();
        for (int i = 0; i < seq.length; i++) bst.add(Integer.parseInt(seq[i]));

        System.out.println(bst.height());
    }
    
}

class BSTHeight {
    
    private Node root;

    public BSTHeight() {
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

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
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
