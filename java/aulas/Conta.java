public class Conta {
    private String numero;
    private double saldo;

    public void Conta(String numero, double valor) {
        this.numero = numero;
        this.saldo = valor;
    }

    public void creditar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void debitar(double valor) {
        this.saldo = this.saldo - valor;
    }

    public void show() {
        System.out.printf("Número da conta: %s, Saldo da conta: %.2f%n", this.numero, this.saldo);
    }
}