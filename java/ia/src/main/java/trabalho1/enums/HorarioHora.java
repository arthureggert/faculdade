package trabalho1.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HorarioHora {

    PRIMEIRA(0),
    SEGUNDA(1);

    int hora;

    public int asInt() {
        return hora;
    }
}
