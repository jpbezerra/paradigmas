public class Programa {
    public static void main(String[] args) {
        // 1. Criamos a implementação concreta do repositório (Array)
        RepositorioContas repositorio = new RepositorioContasArray();

        // 2. Injetamos o repositório no Banco via construtor
        Banco banco = new Banco(repositorio);

        // --- TESTE 1: Poupança ---
        System.out.println("=== Teste Poupança ===");
        Poupanca poupanca = new Poupanca(1001);

        try {
            banco.cadastrar(poupanca);
        } catch (ContaJaCadastrarException e) {
            System.out.println(e.getMessage());
        }

        banco.creditar(1001, 1000.0);
        System.out.println("Saldo Poupanca antes dos juros: " + banco.getSaldo(1001));

        // O método renderJuros do Banco usa a taxa interna definida na classe Banco
        banco.renderJuros(1001); 
        System.out.println("Saldo Poupanca após os juros: " + banco.getSaldo(1001));

        // --- TESTE 2: Conta Especial (Bônus) ---
        System.out.println("\n=== Teste Conta Especial ===");
        ContaEspecial contaEspecial = new ContaEspecial(2001);

        try {
            banco.cadastrar(contaEspecial);
        } catch (ContaJaCadastrarException e) {
            System.out.println(e.getMessage());
        }

        // O crédito gera bônus internamente na conta especial
        banco.creditar(2001, 1000.0); 
        System.out.println("Saldo Conta Especial antes do bônus: " + banco.getSaldo(2001));

        banco.renderBonus(2001);
        System.out.println("Saldo Conta Especial após renderizar bônus: " + banco.getSaldo(2001));

        // --- TESTE 3: Conta Imposto (CPMF) ---
        System.out.println("\n=== Teste Conta Imposto ===");
        ContaImposto contaImposto = new ContaImposto(3001);

        try {
            banco.cadastrar(contaImposto);
        } catch (ContaJaCadastrarException e) {
            System.out.println(e.getMessage());
        }

        banco.creditar(3001, 1000.0);
        System.out.println("Saldo Conta Imposto inicial: " + banco.getSaldo(3001));

        // O débito deve cobrar o valor + o imposto CPMF (definido na classe ContaImposto)
        banco.debitar(3001, 100.0); 
        System.out.println("Saldo Conta Imposto após débito de 100.0: " + banco.getSaldo(3001));

        // --- TESTE 4: Transferência ---
        System.out.println("\n=== Teste Transferência ===");
        // Transferindo da Conta Especial (2001) para a Poupança (1001)
        System.out.println("Saldo Origem (Especial) antes: " + banco.getSaldo(2001));
        System.out.println("Saldo Destino (Poupanca) antes: " + banco.getSaldo(1001));
        
        banco.transferir(200.0, 2001, 1001);
        
        System.out.println("Saldo Origem (Especial) depois: " + banco.getSaldo(2001));
        System.out.println("Saldo Destino (Poupanca) depois: " + banco.getSaldo(1001));
    }
}