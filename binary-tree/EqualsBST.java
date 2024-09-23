import java.util.ArrayList;
import java.util.Scanner;

class EqualsBST {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq1 = sc.nextLine().split(" ");
        String[] seq2 = sc.nextLine().split(" ");

        BSTEq bst1 = new BSTEq();
        for (String s : seq1) bst1.add(Integer.parseInt(s));

        BSTEq bst2 = new BSTEq();
        for (String s : seq2) bst2.add(Integer.parseInt(s));

        if (bst1.equals(bst2)) System.out.println("true");
        else System.out.println("false");
    }
    
}

class BSTEq {
    
    private Node root;

    public BSTEq() {
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

    public ArrayList<Integer> toArrayList() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        this.preOrderList(this.root, arr);
        return arr;
    }

    private void preOrderList(Node node, ArrayList<Integer> arr) {
        if (node != null) {
            arr.add(node.value);
            this.preOrderList(node.left, arr);
            this.preOrderList(node.right, arr);
        }
    }

    public boolean equals(BSTEq other) {
        ArrayList<Integer> arr = this.toArrayList();
        ArrayList<Integer> other_arr = other.toArrayList();

        for (int i = 0; i < arr.size(); i++)
            if (arr.get(i) != other_arr.get(i)) return false;
        
        return true;
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
