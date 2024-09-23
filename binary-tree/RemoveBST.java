import java.util.ArrayList;
import java.util.Scanner;

class RemoveBST {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTRem bst = new BSTRem();
        for (String s : seq) bst.add(Integer.parseInt(s));

        String[] toRemove = sc.nextLine().split(" ");

        for (String s : toRemove) {
            Node nodeToRemove = bst.search(Integer.parseInt(s));
            if (nodeToRemove == null) System.out.println(bst.toString());
            else {
                bst.remove(nodeToRemove);
                System.out.println(bst.toString());
            }
        }

    }
    
}

class BSTRem {
    
    private Node root;

    public BSTRem() {
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

    public Node search(int element) {
        Node aux = this.root;

        while (aux != null) {
            if (aux.value == element) return aux;
            if (element < aux.value) aux = aux.left;
            else aux = aux.right;
        }

        return null;
    }

    public Node min() {
        if (this.isEmpty()) return null;
        return this.min(this.root);
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    public Node sucessor(Node node) {
        if (node == null) return null;
        if (node.right != null) return this.min(node.right);
        else {
            Node aux = node.parent;
            while (aux != null && aux.value < node.value) 
                aux = aux.parent;
            return aux;
        }
    }

    public void remove(Node node) {
        if (node == null) return;
        if (node.isLeaf()) {
            if (node == this.root) this.root = null;
            else {
                if (node.value < node.parent.value) node.parent.left = null;
                else node.parent.right = null;
            }
        } else if (node.hasOnlyLeftChild()) {
            if (node == this.root) {
                this.root = node.left;
                this.root.parent = null;
            } else {
                node.left.parent = node.parent;
                if (node.value < node.parent.value) node.parent.left = node.left;
                else node.parent.right = node.left;
            }
        } else if (node.hasOnlyRightChild()) {
            if (node == this.root) {
                this.root = node.right;
                this.root.parent = null;
            } else {
                node.right.parent = node.parent;
                if (node.value < node.parent.value) node.parent.left = node.right;
                else node.parent.right = node.right;
            }
        } else {
            Node sucessor = this.sucessor(node);
            node.value = sucessor.value;
            this.remove(sucessor);
        }
    } 

    private ArrayList<Integer> toArrayList() {
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

    public String toString() {
        if (this.isEmpty()) return "null";
        else {
            String ans = "";
            ArrayList<Integer> arr = this.toArrayList();
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

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasOnlyLeftChild() {
        return this.left != null && this.right == null;
    }

    public boolean hasOnlyRightChild() {
        return this.left == null && this.right != null;
    }
}

