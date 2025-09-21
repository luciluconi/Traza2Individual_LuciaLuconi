package Entidades;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"articuloManufacturado", "insumo"})
@ToString(exclude = {"articuloManufacturado", "insumo"})
public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;
    private ArticuloInsumo insumo;
    private ArticuloManufacturado articuloManufacturado;
}
