public class Curso {
    private String nome;
    private String codigo;

    public Curso(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return this.codigo;
    }
}