package Entidades;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadMedida {
    private Long id;
    private String nombre;   // Kilogramos, Litros, Gramos
    private String simbolo;  // kg, L, g
}
