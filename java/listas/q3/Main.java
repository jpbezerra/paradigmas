public class Main {

    public static void main(String[] args) {
        balcaoPequeno();
        // altaProducao();
        // altoConsumo();
    }

    public static void balcaoPequeno() {
        System.out.println("=== CENÁRIO 1: Balcão Pequeno ===");
        int capacidadeBalcao = 1;
        int produtividadeAprendiz = 1; 
        int consumoChefe = 1;

        iniciarSimulacao(capacidadeBalcao, produtividadeAprendiz, consumoChefe);
    }

    public static void altaProducao() {
        System.out.println("=== CENÁRIO 2: Alta Produção ===");
        int capacidadeBalcao = 10;
        int produtividadeAprendiz = 10; 
        int consumoChefe = 1;           

        iniciarSimulacao(capacidadeBalcao, produtividadeAprendiz, consumoChefe);
    }

    public static void altoConsumo() {
        System.out.println("=== CENÁRIO 3: Alto Consumo ===");
        int capacidadeBalcao = 10;
        int produtividadeAprendiz = 1;  
        int consumoChefe = 10;          

        iniciarSimulacao(capacidadeBalcao, produtividadeAprendiz, consumoChefe);
    }

    private static void iniciarSimulacao(int capacidade, int prod, int cons) {
        Balcao balcao = new Balcao(capacidade);

        Aprendiz aprendiz = new Aprendiz(balcao, prod);
        Thread tAprendiz = new Thread(aprendiz);

        Chefe chefe = new Chefe(balcao, cons);
        Thread tChefe = new Thread(chefe);

        tAprendiz.start();
        tChefe.start();
    }
}