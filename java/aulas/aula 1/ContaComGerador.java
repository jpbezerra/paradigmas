public class ContaComGerador {
    private int numero;
    private double saldo;
    private static int proximo = 0;

    public ContaComGerador(double saldo) {
        this.numero = ContaComGerador.getProximo();
        this.saldo = saldo;
    }

    private static int getProximo() {
        proximo = proximo + 1;
        return proximo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void show() {
        System.out.printf("Número da conta: %d, Saldo da conta: %.2f%n", this.numero, this.saldo);
    }
}