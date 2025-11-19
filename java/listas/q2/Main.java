import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JogadorATP nadal = new JogadorATP("Rafael Nadal", 100.0);
        System.out.println("--- Início da Simulação: " + nadal.getNome() + " (Pontos: " + nadal.getPontos() + ") ---");

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            threads.add(new AtualizacaoRanking(nadal, true, 10.0, "Juiz-Ganho-" + i));
            threads.add(new AtualizacaoRanking(nadal, false, 10.0, "Juiz-Perda-" + i));
        }

        threads.add(new AtualizacaoRanking(nadal, false, 200.0, "Juiz-Malvado"));

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Simulação finalizada.");
        System.out.println("Pontuação Final Esperada: 100.0");
        System.out.println("Pontuação Final Real: " + nadal.getPontos());
    }
}