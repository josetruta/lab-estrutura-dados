import java.util.Scanner;

class InvertePilhaIndex {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tam = Integer.parseInt(sc.nextLine());

        String[] seq = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(tam);
        for (int i = 0; i < seq.length; i++) pilha.push(Integer.parseInt(seq[i]));

        int index = Integer.parseInt(sc.nextLine());

        pilha.inverte(index);
        System.out.println("-");
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

    public void inverte(int index) {
        Fila aux = new Fila(this.size());

        int occ = 0;
        while (!this.isEmpty() && occ <= index) {
            aux.addLast(this.pop());
            occ += 1;
        }
        
        while (!aux.isEmpty()) {
            this.push(aux.removeFirst());
        }

    }
}

class Fila {

    private int[] queue;
    private int head;
    private int tail;
    private int size;

    public Fila(int capacidade) {
        this.queue = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.head == -1 && this.tail == -1);
    }

    public boolean isFull() {
        return (((this.tail + 1) % this.queue.length)) == this.head;
    }

    public void addLast(int valor) {
        if (this.isFull()) throw new RuntimeException("Full queue.");
        if (this.isEmpty()) this.head = 0;
        this.tail = (this.tail + 1) % this.queue.length;
        this.queue[this.tail] = valor;
        this.size += 1;
    }

    public int removeFirst() {
        if (this.isEmpty()) throw new RuntimeException("Empty queue.");

        int valor = this.queue[this.head];

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.queue.length;
        }
        
        this.size -= 1;
        return valor;
    }

    public int getFirst() {
        if (this.isEmpty()) throw new RuntimeException("Empty queue.");
        return this.queue[this.head];
    }

    public int getLast() {
        if (this.isEmpty()) throw new RuntimeException("Empty queue.");
        return this.queue[this.tail];
    }

    public int size() {
        return this.size;
    }

}