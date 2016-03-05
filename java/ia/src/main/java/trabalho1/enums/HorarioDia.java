package trabalho1.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HorarioDia {

    SEGUNDA(0),
    TERCA(1),
    QUARTA(2),
    QUINTA(3),
    SEXTA(4);

    int dia;

    public int asInt() {
        return dia;
    }
}
