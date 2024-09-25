import java.util.Scanner;

class BalanceBST {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTBal bst = new BSTBal();
        for (String s : seq) bst.add(Integer.parseInt(s));

        bst.preOrder();    
        
        System.out.println(bst.text.trim());
    }
}

class BSTBal {
    
    private Node root;
    public String text;

    public BSTBal() {
        this.root = null;
        this.text = "";
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

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            int balance = this.height(node.left) - this.height(node.right);
            this.text += node.value + "," + balance + " ";
            this.preOrder(node.left);
            this.preOrder(node.right);
        }
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