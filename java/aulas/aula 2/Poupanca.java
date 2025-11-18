public class Poupanca extends Conta {
    public Poupanca(int numero) {
        super(numero);
    }

    public void renderJuros(double taxa) {
        double juros = this.getSaldo() * taxa / 100;
        this.creditar(juros);
    }
}