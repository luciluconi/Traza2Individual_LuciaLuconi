package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true, exclude = {"imagenes", "detalles"})
@ToString(callSuper = true, exclude = {"imagenes", "detalles"})
public class ArticuloManufacturado extends Articulo {
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();

    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();
}
