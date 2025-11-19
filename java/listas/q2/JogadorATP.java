public class JogadorATP {
    private double pontos;
    private String nome;

    public JogadorATP(String nome, double pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public synchronized void adicionarPontos(double valor) {
        this.pontos += valor;
        System.out.printf("[%s] adicionou %.1f pontos. Total: %.1f%n", 
            Thread.currentThread().getName(), valor, this.pontos);
    }

    public synchronized void removerPontos(double valor) throws PontosInsuficientesException {
        if (valor > this.pontos) {
            throw new PontosInsuficientesException(
                "[" + Thread.currentThread().getName() + "] ERRO: Tentativa de remover " + 
                valor + " mas saldo é apenas " + this.pontos
            );
        }

        this.pontos -= valor;
        System.out.printf("[%s] removeu %.1f pontos. Total: %.1f%n", 
                Thread.currentThread().getName(), valor, this.pontos);
    }

    public double getPontos() {
        return this.pontos;
    }

    public String getNome() {
        return this.nome;
    }
}