import java.util.ArrayList;
import java.util.Scanner;

class EncaminhamentosBST {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTEnc bst = new BSTEnc();
        for (String s : seq) bst.add(Integer.parseInt(s));

        System.out.println(bst.toString("pre"));
        System.out.println(bst.toString("in"));
        System.out.println(bst.toString("pos"));
    }
    
}

class BSTEnc {
    
    private Node root;

    public BSTEnc() {
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

    public ArrayList<Integer> toArrayList(String order) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        switch (order) {
            case "pre":
                this.preOrderList(this.root, arr);
                break;
            case "in": 
                this.inOrderList(this.root, arr);
                break;
            default:
                this.postOrderList(this.root, arr);
                break;
        }
        return arr;
    }

    private void preOrderList(Node node, ArrayList<Integer> arr) {
        if (node != null) {
            arr.add(node.value);
            this.preOrderList(node.left, arr);
            this.preOrderList(node.right, arr);
        }
    }

    private void inOrderList(Node node, ArrayList<Integer> arr) {
        if (node != null) {
            this.inOrderList(node.left, arr);
            arr.add(node.value);
            this.inOrderList(node.right, arr);
        }
    }

    private void postOrderList(Node node, ArrayList<Integer> arr) {
        if (node != null) {
            this.postOrderList(node.left, arr);
            this.postOrderList(node.right, arr);
            arr.add(node.value);
        }
    }

    public String toString(String order) {
        if (this.isEmpty()) return "null";
        else {
            String ans = "";
            ArrayList<Integer> arr = this.toArrayList(order);
            for (int i = 0; i < arr.size(); i++) {
                if (i == 0) ans += "[";
                if (i != arr.size() - 1) ans += Integer.toString(arr.get(i)) + ", ";
                else ans += Integer.toString(arr.get(i)) + "]";
            } 
            return ans;
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
