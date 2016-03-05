package trabalho1.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import trabalho1.criadores.CriadorDisciplinas;

import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Aluno {

    @Getter
    private String nome;

    @Getter
    private List<Disciplina> aprovadas;

    public List<Disciplina> getNaoAprovadas() {
        List<Disciplina> naoAprovadas = CriadorDisciplinas.getDisplinas();
        naoAprovadas.removeAll(aprovadas);
        return naoAprovadas;
    }

}
