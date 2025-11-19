public class Carro extends Viagem {
    public Carro(String destino, double distanciaEmKm, double precoBase) {
        super(destino, distanciaEmKm, precoBase);
    }

    @Override
    public double calcularValor() {
        return this.precoBase + (this.distanciaEmKm * 0.5);
    }

    @Override
    public String tempoDeViagem() {
        int horas = (int) (this.distanciaEmKm / 100);
        return horas + " horas";
    }
}