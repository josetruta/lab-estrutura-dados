import java.util.Scanner;

class ElementoPilha {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(seq.length);
        for (int i = 0; i < seq.length; i++) pilha.push(Integer.parseInt(seq[i]));

        int index = sc.nextInt();

        index = pilha.size() - 1 - index;

        try {
            int valor = pilha.get(index);
            System.out.println(valor);
        } catch (Exception e) {
            System.out.println("indice invalido");
        }
    }

}

class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    private boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    public int peek() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.topo];
    }

    public void push(int valor) {
        if (this.isFull()) throw new RuntimeException("Pilha cheia.");
        this.pilha[++this.topo] = valor;
    }

    public int pop() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.topo--];
    }

    public int size() {
        return this.topo + 1;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();

        Pilha aux = new Pilha(this.size());

        int occ = 0;
        while (!this.isEmpty() && occ <= index) {
            aux.push(this.pop());
            occ += 1;
        }

        int valor = aux.peek();

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return valor;
    }

}
