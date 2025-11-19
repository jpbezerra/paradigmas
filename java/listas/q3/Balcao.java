import java.util.LinkedList;
import java.util.Queue;

public class Balcao {
    private int capacidade;
    private Queue<Ingrediente> fila;

    public Balcao(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new LinkedList<>();
    }

    public synchronized void colocar(Ingrediente ingrediente) throws InterruptedException {
        while (this.fila.size() >= this.capacidade) {
            System.out.println(Thread.currentThread().getName() + ": Balcão CHEIO! Esperando espaço...");
            wait();
        }

        this.fila.add(ingrediente);
        System.out.println(Thread.currentThread().getName() + " COLOCOU " + ingrediente.getNome() + 
                           ". [Balcão: " + this.fila.size() + "/" + this.capacidade + "]");
        
        notifyAll();
    }

    public synchronized void retirar() throws InterruptedException {
        while (this.fila.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + ": Balcão VAZIO! Esperando ingredientes...");
            wait();
        }

        Ingrediente ingrediente = this.fila.poll();
        System.out.println(Thread.currentThread().getName() + " RETIROU " + ingrediente.getNome() + 
                           ". [Balcão: " + this.fila.size() + "/" + this.capacidade + "]");
        
        notifyAll();
    }
}