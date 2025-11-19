public class Fogueira implements Restauracao {
    private double eficiencia;

    public Fogueira(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public void restaurar(Personagem personagem, double quantidadeRecuperada) {
        personagem.setVidaAtual(personagem.getVidaAtual() + quantidadeRecuperada);

        System.out.printf("Fogueira restaurou %.1f de vida.%n", quantidadeRecuperada);

        this.calcularDuracao(quantidadeRecuperada);
    }

    @Override
    public void calcularDuracao(double quantidadeRecuperada) {
        double duracao = quantidadeRecuperada / this.eficiencia;
        System.out.printf("Duração da restauração pela fogueira: %.1f segundos.%n", duracao);
    }
}