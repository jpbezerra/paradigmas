public class Banco {
    private Conta[] contas;
    private int indice;
    private double juros;

    public Banco() {
        this.contas = new Conta[100];
        this.indice = 0;
    }

    public boolean cadastrar(Conta conta) {
        if (this.indice >= contas.length) {
            System.out.println("Banco cheio: não é possível cadastrar mais contas.");
            return false;
        }

        this.contas[this.indice++] = conta;
        return true;
    }

    private int buscarIndice(int numero) {
        for (int i = 0; i < this.indice; i++) {
            if (this.contas[i] != null && this.contas[i].getNumero() == numero) {
                return i;
            }
        }

        return -1;
    }

    public boolean creditar(int numero, double valor) {
        int i = buscarIndice(numero);
        if (i == -1) {
            System.out.println("Conta não encontrada: " + numero);
            return false;
        }

        this.contas[i].creditar(valor);
        return true;
    }

    public boolean debitar(int numero, double valor) {
        int i = buscarIndice(numero);
        
        if (i == -1) {
            System.out.println("Conta não encontrada: " + numero);
            return false;
        }
        
        this.contas[i].debitar(valor);
        return true;
    }

    public double getSaldo(int numero) {
        int i = buscarIndice(numero);
        if (i == -1) {
            System.out.println("Conta não encontrada: " + numero);
            return 0.0;
        }

        return this.contas[i].getSaldo();
    }

    public void mostrarContas() {
        for (int i = 0; i < this.indice; i++) {
            if (this.contas[i] != null) this.contas[i].show();
        }
    }

    public void renderJuros(int numero, double taxa) {
        int i = buscarIndice(numero);
        if (i == -1) {
            System.out.println("Conta não encontrada: " + numero);
            return;
        }

        if (this.contas[i] instanceof Poupanca poupanca) {
            poupanca.renderJuros(taxa);
        } else {
            System.out.println("A conta número " + numero + " não é uma poupança.");
        }

        if (this.contas[i] instanceof ContaEspecial contaEspecial) {
            contaEspecial.renderBonus();
        } else {
            System.out.println("A conta número " + numero + " não é uma conta especial.");
        }
    }

    public void transferir(double valor, int numeroOrigem, int numeroDestino) {
        int iOrigem = buscarIndice(numeroOrigem);
        int iDestino = buscarIndice(numeroDestino);

        if (iOrigem == -1) {
            System.out.println("Conta de origem não encontrada: " + numeroOrigem);
            return;
        }

        if (iDestino == -1) {
            System.out.println("Conta de destino não encontrada: " + numeroDestino);
            return;
        }

        if (this.contas[iOrigem].getSaldo() < valor) {
            System.out.println("Saldo insuficiente na conta de origem: " + numeroOrigem);
            return;
        }

        this.contas[iOrigem].debitar(valor);
        this.contas[iDestino].creditar(valor);
    }
}