public class RepositorioContasArray implements RepositorioContas {
    private ContaAbstrata[] contas;
    private int indice;

    public RepositorioContasArray() {
        this.contas = new ContaAbstrata[100];
        this.indice = 0;
    }

    private int getIndice(String numero) {
        for (int i = 0; i < this.indice; i++) {
            if (String.valueOf(this.contas[i].getNumero()).equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void inserir(ContaAbstrata conta) {
        if (this.indice < this.contas.length) {
            this.contas[this.indice] = conta;
            this.indice++;
        } else {
            System.out.println("Erro: Repositório cheio.");
        }
    }

    @Override
    public ContaAbstrata procurar(String numero) {
        int i = this.getIndice(numero);
        if (i != -1) {
            return this.contas[i];
        } else {
            return null;
        }
    }

    @Override
    public void remover(String numero) {
        int i = this.getIndice(numero);
        if (i != -1) {
            this.contas[i] = this.contas[this.indice - 1];
            
            this.contas[this.indice - 1] = null;
            this.indice--;
            System.out.println("Conta " + numero + " removida.");
        } else {
            System.out.println("Conta não encontrada para remoção.");
        }
    }

    @Override
    public void atualizar(ContaAbstrata conta) {
        String numeroStr = String.valueOf(conta.getNumero());
        int i = this.getIndice(numeroStr);
        
        if (i != -1) {
            this.contas[i] = conta;
        } else {
            System.out.println("Erro ao atualizar: Conta não encontrada.");
        }
    }

    @Override
    public boolean existe(String numero) {
        int i = this.getIndice(numero);
        return (i != -1);
    }
}