public class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero, double valor) {
        this.numero = numero;
        this.saldo = valor;
    }

    // Construtor que define só o número e começa com saldo 0.0
    public Conta(String numero) {
        this(numero, 0.0); // this chama o outro construtor
    }

    public void creditar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void debitar(double valor) {
        this.saldo = this.saldo - valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void show() {
        System.out.printf("Número da conta: %s, Saldo da conta: %.2f%n", this.numero, this.saldo);
    }
}