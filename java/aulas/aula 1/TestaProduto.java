public class TestaProduto {
    public static void main(String[] args) {
        Produto p1 = new Produto("Teclado Mecânico", 150.00, 50);

        System.out.println("Testando minha classe Produto:");
        System.out.println(p1.getDescricao());
        System.out.println(p1.getValor());
        System.out.println(p1.getQuantidade());

        p1.setDescricao("Mouse Gamer");
        p1.setValor(120.00);
        p1.setQuantidade(30);

        System.out.println("Após alterações:");
        System.out.println(p1.getDescricao());
        System.out.println(p1.getValor());
        System.out.println(p1.getQuantidade());
    }
}