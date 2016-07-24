package enums;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.*;

public class EEstadoCivilTest {

    private ArrayList<EEstadoCivil> tipos;

    @Before
    public void setUp() throws Exception {
        for (String string : new String[]{"CASADO" , "SOLTEIRO" , "DIVORCIADO"} ) {
            if(Objects.isNull(this.tipos)) {
                this.tipos = new ArrayList<>();
            }
            this.tipos.add(EEstadoCivil.valueOf(string));
        }
    }

    @Test
    public void testGetDescricao() throws Exception {
        for (EEstadoCivil eEstadoCivil : this.tipos) {
            switch (eEstadoCivil) {
                case SOLTEIRO:
                    assertEquals(eEstadoCivil.getDescricao() , "Solteiro");
                    break;
                case CASADO:
                    assertEquals(eEstadoCivil.getDescricao() , "Casado");
                    break;
                case DIVORCIADO:
                    assertEquals(eEstadoCivil.getDescricao() , "Divorciado");
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}