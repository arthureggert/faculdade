package trabalho1;

import busca.*;
import trabalho1.criadores.CriadorAluno;
import trabalho1.ia.EstadoGrade;
import trabalho1.model.Aluno;
import trabalho1.model.Disciplina;

public class App {

    public static void main(String[] args) {

        Aluno arthur = CriadorAluno.criaAluno();

        Disciplina[][] grade = new Disciplina[5][2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                grade[i][j] = null;
            }
        }

        EstadoGrade gradeAluno = new EstadoGrade(arthur.getAprovadas(), arthur.getNaoAprovadas(), grade);


//        Nodo s = new BuscaLargura(new MostraStatusConsole()).busca(gradeAluno);
        Nodo s = new BuscaRecursiva(new MostraStatusConsole()).busca(gradeAluno);
//        Nodo s = new BuscaProfundidade(25, new MostraStatusConsole()).busca(gradeAluno);

        System.out.println(gradeAluno);

    }

}
