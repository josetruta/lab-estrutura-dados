public class BST {
    
    private Node root;

    public BST() {
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

    public Node max() {
        if (this.isEmpty()) return null;
        return this.max(this.root);
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.left);
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

    public Node predecessor(Node node) {
        if (node == null) return null;
        if (node.left != null) return this.max(node.left);
        else {
            Node aux = node.parent;
            while (aux != null && aux.value > node.value) 
                aux = aux.parent;
            return aux;
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
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

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            this.preOrder(node.left);
            this.preOrder(node.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            this.inOrder(node.left);
            System.out.println(node.value);
            this.inOrder(node.right);
        }
    }

    public void posOrder() {
        this.posOrder(this.root);
    }

    private void posOrder(Node node) {
        if (node != null) {
            this.posOrder(node.left);
            this.posOrder(node.right);
            System.out.println(node.value);
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
