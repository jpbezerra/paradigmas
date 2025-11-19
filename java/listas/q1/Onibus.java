public class Onibus extends Viagem {
    public Onibus(String destino, double distanciaEmKm, double precoBase) {
        super(destino, distanciaEmKm, precoBase);
    }

    @Override
    public double calcularValor() {
        return this.precoBase + (this.distanciaEmKm * 0.3);
    }

    @Override
    public String tempoDeViagem() {
        int horas = (int) (this.distanciaEmKm / 80);
        return horas + " horas";
    }
}