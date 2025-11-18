public class ContaEspecial extends Conta {
    private double bonus;

    public ContaEspecial(int numero) {
        super(numero);
        this.bonus = 0.0;
    }

    @Override
    public void creditar(double valor) {
        super.creditar(valor);
        this.bonus = this.bonus + (valor * 0.01);
    }

    public void renderBonus() {
        super.creditar(this.bonus);
        this.bonus = 0.0;
    }

    public double getBonus() {
        return this.bonus;
    }
}