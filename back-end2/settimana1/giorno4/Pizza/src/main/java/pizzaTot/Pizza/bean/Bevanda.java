package pizzaTot.Pizza.bean;

import jakarta.persistence.Enumerated;
import lombok.Data;
import pizzaTot.Pizza.Enum.EnumGradoAl;
@Data
public class Bevanda {
    private String nome;
    private int lt;
    @Enumerated
    private EnumGradoAl gradoAlcohol;
}
