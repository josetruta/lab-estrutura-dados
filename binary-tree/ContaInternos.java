import java.util.Scanner;

class ContaInternos {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTCi bst = new BSTCi();
        for (String s : seq) bst.add(Integer.parseInt(s));
    
        System.out.println(bst.contInternos());
    }
    
}

class BSTCi {
    
    private Node root;

    public BSTCi() {
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

    public int contInternos() {
        return this.contInternos(this.root);
    }

    private int contInternos(Node node) {
        if (node != null) {
            if (!node.isLeaf()) return 1 + this.contInternos(node.left) + this.contInternos(node.right);
            return this.contInternos(node.left) + this.contInternos(node.right);
        }
        return 0;
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

