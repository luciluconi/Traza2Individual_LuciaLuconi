package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "categoria")   //  evitamos el ciclo
@ToString(exclude = "categoria")           //  evitamos el ciclo en imprimir
public class Articulo {
    private Long id;
    private String nombre;
    private Categoria categoria;
}
