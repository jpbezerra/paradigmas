public class AtualizacaoRanking extends Thread {
    private JogadorATP jogador;
    private boolean ehGanho;
    private double valor;

    public AtualizacaoRanking(JogadorATP jogador, boolean ehGanho, double valor, String nomeThread) {
        super(nomeThread);
        this.jogador = jogador;
        this.ehGanho = ehGanho;
        this.valor = valor;
    }

    @Override
    public void run() {
        try {
            if (this.ehGanho) {
                this.jogador.adicionarPontos(this.valor);
            } else {
                this.jogador.removerPontos(this.valor);
            }
        } catch (PontosInsuficientesException e) {
            System.out.println(e.getMessage());
        }
    }
}