public class Aviao extends Viagem {
    public Aviao(String destino, double distanciaEmKm, double precoBase) {
        super(destino, distanciaEmKm, precoBase);
    }

    @Override
    public double calcularValor() {
        return this.precoBase + (this.distanciaEmKm * 1.0);
    }

    @Override
    public String tempoDeViagem() {
        double horas = (double) (this.distanciaEmKm / 800);
        return String.format("%.1f", horas) + " horas";
    }
}