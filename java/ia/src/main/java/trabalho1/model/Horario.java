package trabalho1.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import trabalho1.enums.HorarioDia;
import trabalho1.enums.HorarioHora;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Horario {

    @Getter
    private HorarioDia dia;

    @Getter
    private HorarioHora hora;

}
