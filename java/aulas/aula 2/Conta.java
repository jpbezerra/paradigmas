public class Conta extends ContaAbstrata {
    public Conta(int numero) {
        super(numero);
    }

    @Override
    public void debitar(double valor) {
        if (valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente para débito.");
        }
    }
}