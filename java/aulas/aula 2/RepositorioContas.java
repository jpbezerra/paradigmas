public interface RepositorioContas {
    void inserir(ContaAbstrata conta);
    ContaAbstrata procurar(String numero);
    void remover(String numero) throws ContaNaoEncontradaException;
    void atualizar(ContaAbstrata conta);
    boolean existe(String numero);
}