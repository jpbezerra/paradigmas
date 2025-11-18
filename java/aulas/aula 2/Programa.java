public class Programa {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Poupanca poupanca1 = new Poupanca(1001);
        banco.cadastrar(poupanca1);

        poupanca1.creditar(1000.0);
        System.out.println("Saldo antes dos juros: " + banco.getSaldo(1001));

        poupanca1.renderJuros(5.0);
        System.out.println("Saldo após os juros: " + banco.getSaldo(1001));

        Poupanca poupanca2 = new Poupanca(1002);
        banco.cadastrar(poupanca2);

        poupanca2.creditar(500.0);
        System.out.println("Saldo da segunda poupança: " + banco.getSaldo(1002));

        banco.mostrarContas();

        banco.transferir(200.0, 1001, 1002);
        System.out.println("Saldo da primeira poupança após transferência: " + banco.getSaldo(1001));
        System.out.println("Saldo da segunda poupança após transferência: " + banco.getSaldo(1002));

        ContaEspecial contaEspecial = new ContaEspecial(2001);
        banco.cadastrar(contaEspecial);

        contaEspecial.creditar(1000.0);
        System.out.println("Saldo da conta especial antes do bônus: " + banco.getSaldo(2001));

        banco.renderJuros(2001, 10.0);
        System.out.println("Saldo da conta especial após o bônus: " + banco.getSaldo(2001));

        banco.mostrarContas();

        banco.transferir(300.0, 2001, 1001);
        System.out.println("Saldo da conta especial após transferência: " + banco.getSaldo(2001));
        System.out.println("Saldo da primeira poupança após receber transferência: " + banco.getSaldo(1001));

        banco.mostrarContas();
    }
}