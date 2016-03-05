package trabalho1.criadores;

import trabalho1.model.Horario;
import trabalho1.enums.HorarioDia;
import trabalho1.enums.HorarioHora;

public class CriaHorario {

    public static final Horario SEG1 = Horario.builder().dia(HorarioDia.SEGUNDA).hora(HorarioHora.PRIMEIRA).build();

    public static final Horario SEG2 = Horario.builder().dia(HorarioDia.SEGUNDA).hora(HorarioHora.SEGUNDA).build();

    public static final Horario TER1 = Horario.builder().dia(HorarioDia.TERCA).hora(HorarioHora.PRIMEIRA).build();

    public static final Horario TER2 = Horario.builder().dia(HorarioDia.TERCA).hora(HorarioHora.SEGUNDA).build();

    public static final Horario QUA1 = Horario.builder().dia(HorarioDia.QUARTA).hora(HorarioHora.PRIMEIRA).build();

    public static final Horario QUA2 = Horario.builder().dia(HorarioDia.QUARTA).hora(HorarioHora.SEGUNDA).build();

    public static final Horario QUI1 = Horario.builder().dia(HorarioDia.QUINTA).hora(HorarioHora.PRIMEIRA).build();

    public static final Horario QUI2 = Horario.builder().dia(HorarioDia.QUINTA).hora(HorarioHora.SEGUNDA).build();

    public static final Horario SEX1 = Horario.builder().dia(HorarioDia.SEXTA).hora(HorarioHora.PRIMEIRA).build();

    public static final Horario SEX2 = Horario.builder().dia(HorarioDia.SEXTA).hora(HorarioHora.SEGUNDA).build();


}
