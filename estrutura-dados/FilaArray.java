import java.util.Scanner;

class FilaArray {

    private int[] fila;
    private int head;
    private int tail;
    private int size;

    public FilaArray(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    private boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    private boolean isFull() {
        return this.size == this.fila.length;
    }

    private void element() {
        if (isEmpty()) System.out.println("empty");
        else System.out.println(this.fila[this.head]);
    }

    public void add(int valor) {
        if (isFull()) System.out.println("full");
        else {
            if (isEmpty()) this.head = 0;
            this.tail = (this.tail + 1) % this.fila.length;
            this.fila[this.tail] = valor;
            this.size += 1;
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("empty");
            return -1;
        } else {
            int valor = this.fila[this.head];
            if (this.head == this.tail) {
                this.head = -1;
                this.tail = -1;
            } else {
                this.head = (this.head + 1) % this.fila.length;
            }
            this.size -= 1;
            return valor;
        }
    }

    public int size() {
        return this.size;
    }

    private void print() {
        if (isEmpty()) System.out.println("empty");
        else {
            FilaArray aux = new FilaArray(this.size);

            String out = "";
            while (!this.isEmpty()) {
                int valor = this.remove();
                out += Integer.toString(valor) + " ";
                aux.add(valor);
            }

            while (!aux.isEmpty()) this.add(aux.remove());

            System.out.println(out.trim());
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int tam = Integer.parseInt(sc.nextLine());
        FilaArray fila = new FilaArray(tam);

        String[] op = sc.nextLine().split(" ");

        while (!op[0].equals("end")) {
            if (op[0].equals("print")) fila.print();
            else if (op[0].equals("add")) fila.add(Integer.parseInt(op[1]));
            else if (op[0].equals("remove")) fila.remove();
            else if (op[0].equals("element")) fila.element();
            op = sc.nextLine().split(" ");
        }
    }
    
}
