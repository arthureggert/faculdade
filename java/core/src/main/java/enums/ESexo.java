package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ESexo {

    MASC("Masculino" , 'M'),
    FEM("Feminino" , 'F');

    @Getter
    private String descricao;

    @Getter
    private char abreviacao;
}
