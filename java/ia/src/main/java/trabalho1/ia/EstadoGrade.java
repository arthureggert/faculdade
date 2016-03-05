package trabalho1.ia;


import busca.Estado;
import trabalho1.model.Disciplina;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EstadoGrade implements Estado {

    private Disciplina[][] grade;

    private List<Disciplina> naoAprovadas;

    private List<Disciplina> aprovadas;

    public EstadoGrade(List<Disciplina> aprovadas, List<Disciplina> disciplinasNaoCursadas, Disciplina[][] grade) {
        this.aprovadas = aprovadas;
        this.naoAprovadas = disciplinasNaoCursadas;
        this.grade = grade;
    }

    @Override
    public boolean ehMeta() {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (grade[i][j] != null) {
                    total++;
                }
            }
        }
        return 6 == total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int total = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                Disciplina d = grade[i][j];
                if (d != null) {
                    sb.append("|").append(String.format("%s %" + d.getStringLenght() + "s", d.getNome(), ""));
                } else {
                    sb.append(String.format("|%s %25s", "LIVRE", ""));
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoGrade that = (EstadoGrade) o;

        if (!aprovadas.equals(that.aprovadas)) return false;
        if (!naoAprovadas.equals(that.naoAprovadas)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = naoAprovadas.hashCode();
        result = 31 * result + aprovadas.hashCode();
        return result;
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Estado> sucessores() {
        LinkedList<Estado> sucessores = new LinkedList<>();


        for (final Iterator<Disciplina> iterator = naoAprovadas.iterator(); iterator.hasNext(); ) {
            Disciplina disciplina = iterator.next();
            if (satisfazPreRequisitos(disciplina)) {
                if (satisfazHorarios(disciplina)) {
                    addGradeDisciplinaNaGrade(disciplina);
                    iterator.remove();
                    ArrayList<Disciplina> naoAprovadas2 = new ArrayList<Disciplina>(naoAprovadas);
                    naoAprovadas2.remove(disciplina);
                    Disciplina[][] novaGrade = clonaGradeDisciplina();
                    sucessores.add(new EstadoGrade(aprovadas, naoAprovadas2, novaGrade));
//                    break;
                }
            }
        }

        return sucessores;
    }

    public Disciplina[][] getGrade() {
        return grade;
    }

    private void addGradeDisciplinaNaGrade(Disciplina disciplina) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (disciplina.getGradeDisiplina()[i][j] == 1) {
                    grade[i][j] = disciplina;
                }
            }
        }
    }

    private Disciplina[][] clonaGradeDisciplina() {
        Disciplina[][] novaGrade = new Disciplina[5][2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                novaGrade[i][j] = grade[i][j];
            }
        }
        return novaGrade;
    }


    private boolean satisfazHorarios(Disciplina disciplina) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (grade[i][j] != null) {
                    if (disciplina.getGradeDisiplina()[i][j] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean satisfazPreRequisitos(Disciplina disciplina) {
        if (disciplina.getPrerequisito() != null) {
            Disciplina preRequisito = disciplina.getPrerequisito();
            if (!aprovadas.contains(preRequisito)) {
                return false;
            }
        }
        return true;
    }
}

