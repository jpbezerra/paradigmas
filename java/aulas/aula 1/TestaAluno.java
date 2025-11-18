public class TestaAluno {
    public static void main(String[] args) {
        Curso curso = new Curso("Ciência da Computação", "18");
        Aluno a = new Aluno("Sergio Soares", "239.234.111-98", 32, curso);

        System.out.println("Dados do aluno: " + a.getNome());
        System.out.println("CPF: " + a.getCpf());
        System.out.println("Idade: " + a.getIdade());

        Curso c = a.getCurso();
        System.out.println("Curso: " + c.getNome());

        a.setCpf("NOVO_CPF");
        a.setIdade(20);
        a.setNome("NOVO_NOME");

        curso = new Curso("Engenharia da Computação", "21");
        a.setCurso(curso);

        System.out.println("Dados do aluno: " + a.getNome());
        System.out.println("CPF: " + a.getCpf());
        System.out.println("Idade: " + a.getIdade());
        System.out.println("Curso: " + a.getCurso().getNome());
    }
}