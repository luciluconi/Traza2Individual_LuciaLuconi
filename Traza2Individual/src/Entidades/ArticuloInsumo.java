package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true, exclude = "unidadMedida")
@ToString(callSuper = true, exclude = "unidadMedida")
public class ArticuloInsumo extends Articulo {
    private boolean esParaElaborar;
    private UnidadMedida unidadMedida;
}
