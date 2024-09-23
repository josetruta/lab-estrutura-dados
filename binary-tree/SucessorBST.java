import java.util.ArrayList;
import java.util.Scanner;

class SucessorBST {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTSuc bst = new BSTSuc();
        for (int i = 0; i < seq.length; i++) bst.add(Integer.parseInt(seq[i]));

        int target = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> arr = bst.sucessor(target);

        String ans = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) ans += "[";
            if (i != arr.size() - 1) ans += Integer.toString(arr.get(i)) + ", ";
            else ans += Integer.toString(arr.get(i)) + "]";
        }

        System.out.println(ans);
    }
    
}

class BSTSuc {
    
    private Node root;

    public BSTSuc() {
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

    public ArrayList<Integer> min() {
        if (this.isEmpty()) return null;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        this.min(this.root, ans);
        return ans;
    }

    private void min(Node node, ArrayList<Integer> arr) {
        if (node.left == null) arr.add(node.value);
        else {
            arr.add(node.value);
            this.min(node.left, arr);
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

    public ArrayList<Integer> sucessor(int element) {
        Node node = this.search(element);
        if (node == null) return null;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(node.value);
        if (node.right != null) {
            this.min(node.right, ans);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.value < node.value) {
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
