public class Viagem implements Transporte {
    protected String destino;
    protected double distanciaEmKm;
    protected double precoBase;

    public Viagem(String destino, double distanciaEmKm, double precoBase) {
        this.destino = destino;
        this.distanciaEmKm = distanciaEmKm;
        this.precoBase = precoBase;
    }

    @Override
    public double calcularValor() {
        return this.precoBase * this.distanciaEmKm;
    }

    @Override
    public String tempoDeViagem() {
        return "Tempo desconhecido";
    }

    public String getDestino() {
        return this.destino;
    }
}