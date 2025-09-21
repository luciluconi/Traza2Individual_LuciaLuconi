package Entidades;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imagen {
    private Long id;   // 👈 necesario para poder hacer .id(1L)
    private String nombreArchivo;
    private String url;
}
