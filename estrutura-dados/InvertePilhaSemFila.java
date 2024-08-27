import java.util.Scanner;

class InvertePilhaSemFila {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tam = Integer.parseInt(sc.nextLine());

        String[] seq = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(tam);
        for (int i = 0; i < seq.length; i++) pilha.push(Integer.parseInt(seq[i]));

        pilha.inverte();
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
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

    public int[] getPilha() {
        return this.pilha;
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

    public void inverte() {
        Pilha primeiro = new Pilha(this.size());

        while (!this.isEmpty()) {
            primeiro.push(this.pop());
        }

        Pilha segundo = new Pilha(primeiro.size());
        
        while (!primeiro.isEmpty()) {
            segundo.push(primeiro.pop());
        }

        while (!segundo.isEmpty()) {
            this.push(segundo.pop());
        }

    }
}
