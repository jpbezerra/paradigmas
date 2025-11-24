public class Conta extends ContaAbstrata {
    public Conta(int numero) {
        super(numero);
    }

    @Override
    public void debitar(double valor) throws SaldoInsuficienteException {
        if (valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para débito.");
        }
    }
}