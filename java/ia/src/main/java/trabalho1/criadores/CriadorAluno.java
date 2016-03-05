package trabalho1.criadores;

import trabalho1.model.Aluno;

public class CriadorAluno {

    private static Aluno aluno;

    public static Aluno criaAluno() {
        if(aluno == null) {
            aluno = Aluno.builder().nome("Arthur Henrique Eggert").aprovadas(CriadorDisciplinas.getDisplinasAprovadas()).build();
        }
        return aluno;
    }
}
