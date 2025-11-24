public abstract class ContaAbstrata {
    private int numero;
    private double saldo;

    public ContaAbstrata(int numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public void creditar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    // protected setter para permitir que subclasses modifiquem o saldo, que é um atributo privado
    // private não permitiria isso, mas protected sim    
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void show() {
        System.out.println("Conta Número: " + this.getNumero() + ", Saldo: " + this.getSaldo());
    }

    public abstract void debitar(double valor) throws SaldoInsuficienteException;
}