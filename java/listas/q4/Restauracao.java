public interface Restauracao {
    void restaurar(Personagem personagem, double quantidadeRecuperada) throws EnergiaIncompativelException;
    void calcularDuracao(double quantidadeRecuperada);
}