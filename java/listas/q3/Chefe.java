public class Chefe implements Runnable{
    private Balcao balcao;
    private int desempenho;

    public Chefe(Balcao balcao, int desempenho){
        this.balcao = balcao;
        this.desempenho = desempenho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < this.desempenho; i++) {
                    this.balcao.retirar();
                    Thread.sleep(800);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}