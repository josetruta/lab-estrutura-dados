import java.util.Scanner;

class MaxPilhaIndex {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(seq.length);
        for (int i = 0; i < seq.length; i++) pilha.push(Integer.parseInt(seq[i]));

        int index = sc.nextInt();

        System.out.println(pilha.maiorValor(index));
    }
    
}

class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    private boolean isEmpty() {
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

    public int maiorValor(int index) {
        if (index > this.topo) throw new IndexOutOfBoundsException();

        Pilha aux = new Pilha(this.size());

        int max = this.peek();
        int occ = 0;
        while (!this.isEmpty() && occ <= index) {
            int valor = this.pop();
            aux.push(valor);
            if (valor > max) max = valor;
            occ += 1;
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return max;
    }
}
