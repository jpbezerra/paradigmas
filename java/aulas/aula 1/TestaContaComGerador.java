public class TestaContaComGerador {
    public static void main(String[] args) {
        ContaComGerador conta1 = new ContaComGerador(2000.00);
        System.out.println("Testando minha classe ContaComGerador:");
        conta1.show();

        ContaComGerador conta2 = new ContaComGerador(500.00);
        System.out.println("Testando minha classe ContaComGerador:");
        conta2.show();
    }
}