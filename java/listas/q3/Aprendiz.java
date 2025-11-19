public class Aprendiz implements Runnable{
    private Balcao balcao;
    private int desempenho;

    public Aprendiz(Balcao balcao, int desempenho){
        this.balcao = balcao;
        this.desempenho = desempenho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < this.desempenho; i++) {
                    Ingrediente ingrediente = new Ingrediente("Ingrediente_" + System.currentTimeMillis());
                    this.balcao.colocar(ingrediente);
                    Thread.sleep(500);
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}