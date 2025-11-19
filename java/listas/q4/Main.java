// Arquivo: Main.java
public class Main {
    public static void main(String[] args) {
        Personagem mago = new Personagem(100, 200, TipoEnergia.MANA);
        mago.setVidaAtual(50);
        mago.setEnergiaAtual(0);

        Personagem guerreiro = new Personagem(150, 100, TipoEnergia.ESTAMINA);
        guerreiro.setEnergiaAtual(0);

        Fogueira fogueira = new Fogueira(10.0);
        FonteMagica fonte = new FonteMagica(20.0);
        Acampamento acampamento = new Acampamento(5.0);

        System.out.println("=== INÍCIO DA SIMULAÇÃO JAVA SOULS ===\n");

        fogueira.restaurar(mago, 40); 
        System.out.println("Vida atual do Mago: " + mago.getVidaAtual() + "/" + mago.getVidaMaxima() + "\n");

        try {
            fonte.restaurar(mago, 100);
        } catch (EnergiaIncompativelException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Energia atual do Mago: " + mago.getEnergiaAtual() + "/" + mago.getEnergiaMaxima() + "\n");

        try {
            acampamento.restaurar(guerreiro, 50);
        } catch (EnergiaIncompativelException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Energia atual do Guerreiro: " + guerreiro.getEnergiaAtual() + "/" + guerreiro.getEnergiaMaxima() + "\n");


        System.out.println(">>> Tentando colocar o Guerreiro na Fonte Mágica...");
        try {
            fonte.restaurar(guerreiro, 50);
        } catch (EnergiaIncompativelException e) {
            System.out.println("EXCEÇÃO CAPTURADA: " + e.getMessage());
        }

        System.out.println("\n>>> Tentando colocar o Mago no Acampamento...");
        try {
            acampamento.restaurar(mago, 50);
        } catch (EnergiaIncompativelException e) {
            System.out.println("EXCEÇÃO CAPTURADA: " + e.getMessage());
        }
    }
}