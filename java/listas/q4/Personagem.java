public class Personagem {
    private double vidaAtual;
    private double vidaMaxima;
    private double energiaAtual;
    private double energiaMaxima;
    private TipoEnergia tipo;

    public Personagem(double vidaMaxima, double energiaMaxima, TipoEnergia tipo) {
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.energiaMaxima = energiaMaxima;
        this.energiaAtual = energiaMaxima;
        this.tipo = tipo;
    }

    public void setVidaAtual(double vidaAtual) {
        this.vidaAtual = Math.min(vidaAtual, this.vidaMaxima);
    }

    public double getVidaAtual() {
        return this.vidaAtual;
    }

    public void setEnergiaAtual(double energiaAtual) {
        this.energiaAtual = Math.min(energiaAtual, this.energiaMaxima);
    }

    public double getEnergiaAtual() {
        return this.energiaAtual;
    }

    public double getVidaMaxima() {
        return this.vidaMaxima;
    }

    public double getEnergiaMaxima() {
        return this.energiaMaxima;
    }

    public TipoEnergia getTipo() {
        return this.tipo;
    }
}