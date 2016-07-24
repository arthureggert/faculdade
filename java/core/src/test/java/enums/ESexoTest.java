package enums;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class ESexoTest {

    private List<ESexo> tipos;

    @Before
    public void setUp() {
        for (String string : new String[]{"MASC" , "FEM"} ) {
            if(Objects.isNull(this.tipos)) {
                this.tipos = new ArrayList<>();
            }
            this.tipos.add(ESexo.valueOf(string));
        }
    }

    @After
    public void setDown() {
        this.tipos = null;
    }

    @Test
    public void testGetDescricao() {
        for (ESexo eSexo : this.tipos) {
            switch (eSexo) {
                case FEM:
                    assertEquals(eSexo.getDescricao() , "Feminino");
                    break;
                case MASC:
                    assertEquals(eSexo.getDescricao() , "Masculino");
                    break;
            }
        }
    }

    @Test
    public void testGetAbreviacao() {
        for (ESexo eSexo : this.tipos) {
            switch (eSexo) {
                case FEM:
                    assertEquals(eSexo.getAbreviacao() , 'F');
                    break;
                case MASC:
                    assertEquals(eSexo.getAbreviacao() , 'M');
                    break;
            }
        }
    }

    @Test()
    public void testGetDescricaoWithFailure() {
        for (ESexo eSexo : this.tipos) {
            switch (eSexo) {
                case FEM:
                    assertNotEquals(eSexo.getDescricao() , "Feminina");
                    break;
                case MASC:
                    assertNotEquals(eSexo.getDescricao() , "Masculin");
                    break;
            }
        }
    }

    @Test
    public void testGetAbreviacaoWithFailure() {
        for (ESexo eSexo : this.tipos) {
            switch (eSexo) {
                case FEM:
                    assertNotEquals(eSexo.getAbreviacao() , 'M');
                    break;
                case MASC:
                    assertNotEquals(eSexo.getAbreviacao() , 'F');
                    break;
            }
        }
    }
}