package Entidades;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "articulos")   //  evitamos el ciclo
@ToString(exclude = "articulos")           // evitamos el ciclo
public class Categoria {
    private Long id;
    private String nombre;

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
}
