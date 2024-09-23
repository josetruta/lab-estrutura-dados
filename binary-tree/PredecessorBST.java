import java.util.ArrayList;
import java.util.Scanner;

class PredecessorBST {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTPre bst = new BSTPre();
        for (int i = 0; i < seq.length; i++) bst.add(Integer.parseInt(seq[i]));

        int target = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> arr = bst.predecessor(target);

        String ans = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) ans += "[";
            if (i != arr.size() - 1) ans += Integer.toString(arr.get(i)) + ", ";
            else ans += Integer.toString(arr.get(i)) + "]";
        }

        System.out.println(ans);
    }
    
}

class BSTPre {
    
    private Node root;

    public BSTPre() {
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

    public ArrayList<Integer> max() {
        if (this.isEmpty()) return null;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        this.max(this.root, ans);
        return ans;
    }

    private void max(Node node, ArrayList<Integer> arr) {
        if (node.right == null) arr.add(node.value);
        else {
            arr.add(node.value);
            this.max(node.right, arr);
        } 
    }

    public Node search(int element) {
        Node aux = this.root;

        while (aux != null) {
            if (aux.value == element) return aux;
            if (element < aux.value) aux = aux.left;
            else aux = aux.right;
        }

        return null;
    }

    public ArrayList<Integer> predecessor(int element) {
        Node node = this.search(element);
        if (node == null) return null;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(node.value);
        if (node.left != null) {
            this.max(node.left, ans);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.value > node.value) {
                ans.add(aux.value);
                aux = aux.parent;
            }
            if (aux != null) ans.add(aux.value);
        }
        return ans;
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

