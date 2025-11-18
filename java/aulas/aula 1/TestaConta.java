public class TestaConta {
    public static void main(String[] args) {
        Conta c1 = new Conta("12345-6", 1000.00);

        System.out.println("Testando minha classe Conta:");
        c1.show();

        c1.creditar(500.00);
        System.out.println("Após crédito de 500.00:");
        c1.show();

        c1.debitar(200.00);
        System.out.println("Após débito de 200.00:");
        c1.show();

        System.out.println("Número da conta: " + c1.getNumero());
        System.out.println("Saldo da conta: " + c1.getSaldo());
    }
}