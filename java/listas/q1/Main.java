// Arquivo: Main.java
public class Main {
    public static void main(String[] args) {
        // Dados da viagem
        String destino = "Salvador";
        double distancia = 900.0;

        Viagem viagemOnibus = new Onibus(destino, distancia, 50.0);
        Viagem viagemAviao = new Aviao(destino, distancia, 200.0);
        Viagem viagemCarro = new Carro(destino, distancia, 100.0);

        mostrarDetalhes(viagemOnibus, "Ônibus");
        mostrarDetalhes(viagemAviao, "Avião");
        mostrarDetalhes(viagemCarro, "Carro");
    }

    public static void mostrarDetalhes(Viagem v, String tipo) {
        System.out.println("-----------------------------");
        System.out.println("Transporte: " + tipo);
        System.out.println("Destino: " + v.getDestino());
        System.out.printf("Preço da viagem: R$%.2f%n", v.calcularValor());
        System.out.println("Tempo estimado: " + v.tempoDeViagem());
    }
}