public class ContaImposto extends ContaAbstrata {
    private static final double CPMF = 0.001;

    public ContaImposto(int numero) {
        super(numero);
    }

    @Override
    public void debitar(double valor) {
        double imposto = valor * ContaImposto.CPMF;
        double totalDebitar = valor + imposto;

        if (totalDebitar <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - totalDebitar);
            System.out.printf("Débito com imposto (CPMF %.3f%%) realizado. Total debitado: %.2f%n", ContaImposto.CPMF * 100, totalDebitar);
        } else {
            System.out.println("Saldo insuficiente para débito com imposto.");
        }
    }
}