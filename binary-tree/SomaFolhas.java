import java.util.ArrayList;
import java.util.Scanner;

class SomaFolhas {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTSf bst = new BSTSf();
        for (String s : seq) bst.add(Integer.parseInt(s));
    
        ArrayList<Node> arr = bst.preOrder();
        int sum = 0;

        for (Node n : arr) 
            if (n.isLeaf()) sum += n.value;

        System.out.println(sum);
    }
    
}

class BSTSf {
    
    private Node root;

    public BSTSf() {
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

    public ArrayList<Node> preOrder() {
        ArrayList<Node> arr = new ArrayList<Node>();
        this.preOrder(this.root, arr);
        return arr;
    }

    private void preOrder(Node node, ArrayList<Node> arr) {
        if (node != null) {
            arr.add(node);
            this.preOrder(node.left, arr);
            this.preOrder(node.right, arr);
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

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}

