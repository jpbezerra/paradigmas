public class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public void debitar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para débito.");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void show() {
        System.out.println("Conta Número: " + this.numero + ", Saldo: " + this.saldo);
    }
}