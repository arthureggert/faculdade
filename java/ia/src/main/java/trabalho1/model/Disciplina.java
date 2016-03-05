package trabalho1.model;

import lombok.*;
import trabalho1.enums.Area;
import trabalho1.enums.Semestre;

@Builder
@EqualsAndHashCode(of = {"nome"})
@ToString(of = {"nome"})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Disciplina {

    @Getter
    private String nome;

    @Getter
    private Disciplina prerequisito;

    @Getter
    private int qtdCreditos;

    @Getter
    private Semestre semestre;

    @Getter
    private Area areaConhecimento;

    @Getter
    private Horario[] horarios = new Horario[2];


    public int[][] getGradeDisiplina() {
        int[][] grade = new int[5][2];

        Horario tmp = getHorarios()[0];
        grade[tmp.getDia().asInt()][tmp.getHora().asInt()] = 1;

        if (getQtdCreditos() > 2) {
            tmp = getHorarios()[1];
            grade[tmp.getDia().asInt()][tmp.getHora().asInt()] = 1;
        }

        return grade;
    }

    public int getStringLenght() {
        return getNome().length() - 30;
    }
}
