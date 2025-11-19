public class FonteMagica implements Restauracao {
    private double eficiencia;

    public FonteMagica(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public void restaurar(Personagem personagem, double quantidadeRecuperada) throws EnergiaIncompativelException {
        if (personagem.getTipo() != TipoEnergia.MANA) {
            throw new EnergiaIncompativelException("Tipo de energia incompatível para restauração pela fonte mágica.");
        }

        personagem.setEnergiaAtual(personagem.getEnergiaAtual() + quantidadeRecuperada);

        System.out.printf("Fonte mágica restaurou %.1f de energia.%n", quantidadeRecuperada);

        this.calcularDuracao(quantidadeRecuperada);
    }

    @Override
    public void calcularDuracao(double quantidadeRecuperada) {
        double duracao = quantidadeRecuperada / this.eficiencia;
        System.out.printf("Duração da restauração pela fonte mágica: %.1f segundos.%n", duracao);
    }
}