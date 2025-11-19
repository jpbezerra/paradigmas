public class Acampamento implements Restauracao {
    private double eficiencia;

    public Acampamento(double eficienca) {
        this.eficiencia = eficienca;
    }

    @Override
    public void restaurar(Personagem personagem, double quantidadeRecuperada) throws EnergiaIncompativelException {
        if (personagem.getTipo() != TipoEnergia.ESTAMINA) {
            throw new EnergiaIncompativelException("Tipo de energia incompatível para restauração pelo acampamento.");
        }

        personagem.setEnergiaAtual(personagem.getEnergiaAtual() + quantidadeRecuperada);

        System.out.printf("Acampamento restaurou %.1f de energia.%n", quantidadeRecuperada);

        this.calcularDuracao(quantidadeRecuperada);
    }

    @Override
    public void calcularDuracao(double quantidadeRecuperada) {
        double duracao = quantidadeRecuperada / this.eficiencia;
        System.out.printf("Duração da restauração pelo acampamento: %.1f segundos.%n", duracao);
    }
}