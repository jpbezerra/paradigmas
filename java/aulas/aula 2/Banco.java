public class Banco {
    private RepositorioContas contas; 
    private double taxaJuros = 0.01;

    public Banco(RepositorioContas rep) {
        this.contas = rep;
    }

    public boolean cadastrar(ContaAbstrata conta) {
        String numeroStr = String.valueOf(conta.getNumero());
        
        if (!this.contas.existe(numeroStr)) {
            this.contas.inserir(conta);
            System.out.println("Conta " + conta.getNumero() + " cadastrada com sucesso.");
            return true;
        } else {
            System.out.println("Erro: Conta " + conta.getNumero() + " já existe.");
            return false;
        }
    }

    public boolean creditar(int numero, double valor) {
        String numeroStr = String.valueOf(numero);
        ContaAbstrata c = this.contas.procurar(numeroStr);

        if (c == null) {
            System.out.println("Conta não encontrada: " + numero);
            return false;
        }

        c.creditar(valor);
        this.contas.atualizar(c);
        return true;
    }

    public boolean debitar(int numero, double valor) {
        String numeroStr = String.valueOf(numero);
        ContaAbstrata c = this.contas.procurar(numeroStr);

        if (c == null) {
            System.out.println("Conta não encontrada: " + numero);
            return false;
        }

        c.debitar(valor); 
        this.contas.atualizar(c);
        return true;
    }

    public double getSaldo(int numero) {
        String numeroStr = String.valueOf(numero);
        ContaAbstrata c = this.contas.procurar(numeroStr);

        if (c == null) {
            System.out.println("Conta não encontrada: " + numero);
            return 0.0;
        }

        return c.getSaldo();
    }

    public void renderJuros(int numero) {
        String numeroStr = String.valueOf(numero);
        ContaAbstrata c = this.contas.procurar(numeroStr);

        if (c instanceof Poupanca) {
            ((Poupanca) c).renderJuros(this.taxaJuros);
            this.contas.atualizar(c); 
            System.out.printf("Juros aplicados na Poupança %d.%n", numero);
        } else {
            System.out.println("Operação falhou: A conta " + numero + " não é uma Poupança ou não existe.");
        }
    }

    public void renderBonus(int numero) {
        String numeroStr = String.valueOf(numero);
        ContaAbstrata c = this.contas.procurar(numeroStr);

        if (c instanceof ContaEspecial) {
            ((ContaEspecial) c).renderBonus();
            this.contas.atualizar(c); 
            System.out.println("Bônus renderizado na Conta Especial " + numero);
        } else {
            System.out.println("Operação falhou: A conta " + numero + " não é uma Conta Especial ou não existe.");
        }
    }

    public void transferir(double valor, int numeroOrigem, int numeroDestino) {
        String numOrigemStr = String.valueOf(numeroOrigem);
        String numDestinoStr = String.valueOf(numeroDestino);

        ContaAbstrata origem = this.contas.procurar(numOrigemStr);
        ContaAbstrata destino = this.contas.procurar(numDestinoStr);

        if (origem == null || destino == null) {
            System.out.println("Transferência cancelada: Conta de origem ou destino inexistente.");
            return;
        }

        origem.debitar(valor);
        
        destino.creditar(valor);

        this.contas.atualizar(origem);
        this.contas.atualizar(destino);

        System.out.printf("Transferência de %.2f realizada de %d para %d.%n", valor, numeroOrigem, numeroDestino);
    }
}