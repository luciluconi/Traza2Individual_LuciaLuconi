import Entidades.*;
import Repositorios.ArticuloManufacturadoRepository;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ===== CATEGORÍAS =====
        Categoria catPizzas  = Categoria.builder().id(1L).nombre("Pizzas").build();
        Categoria catSand    = Categoria.builder().id(2L).nombre("Sandwich").build();
        Categoria catLomos   = Categoria.builder().id(3L).nombre("Lomos").build();
        Categoria catInsumos = Categoria.builder().id(4L).nombre("Insumos").build();

        // ===== UNIDADES DE MEDIDA =====
        UnidadMedida kg = UnidadMedida.builder().id(1L).nombre("Kilogramos").simbolo("kg").build();
        UnidadMedida l  = UnidadMedida.builder().id(2L).nombre("Litros").simbolo("L").build();
        UnidadMedida g  = UnidadMedida.builder().id(3L).nombre("Gramos").simbolo("g").build();

        // ===== INSUMOS (esParaElaborar = true) =====
        ArticuloInsumo sal    = ArticuloInsumo.builder().id(1L).nombre("sal")
                .esParaElaborar(true).unidadMedida(g).categoria(catInsumos).build();

        ArticuloInsumo aceite = ArticuloInsumo.builder().id(2L).nombre("aceite")
                .esParaElaborar(true).unidadMedida(l).categoria(catInsumos).build();

        ArticuloInsumo carne  = ArticuloInsumo.builder().id(3L).nombre("carne")
                .esParaElaborar(true).unidadMedida(kg).categoria(catInsumos).build();

        ArticuloInsumo harina = ArticuloInsumo.builder().id(4L).nombre("harina")
                .esParaElaborar(true).unidadMedida(kg).categoria(catInsumos).build();

        // Asociamos insumos a la categoría Insumos (uno por uno)
        catInsumos.getArticulos().add(sal);
        catInsumos.getArticulos().add(aceite);
        catInsumos.getArticulos().add(carne);
        catInsumos.getArticulos().add(harina);

        // ===== IMÁGENES (3 para pizza, 3 para lomo) =====
        Imagen imagen1 = Imagen.builder().id(1L).nombreArchivo("imagen1").build();
        Imagen imagen2 = Imagen.builder().id(2L).nombreArchivo("imagen2").build();
        Imagen imagen3 = Imagen.builder().id(3L).nombreArchivo("imagen3").build();

        Imagen imagen4 = Imagen.builder().id(4L).nombreArchivo("imagen4").build();
        Imagen imagen5 = Imagen.builder().id(5L).nombreArchivo("imagen5").build();
        Imagen imagen6 = Imagen.builder().id(6L).nombreArchivo("imagen6").build();

        // ===== DETALLES (insumos para cada manufacturado) =====
        ArticuloManufacturadoDetalle detallePizzaH1 = ArticuloManufacturadoDetalle.builder()
                .id(1L).cantidad(1).insumo(sal).build();

        ArticuloManufacturadoDetalle detallePizzaH2 = ArticuloManufacturadoDetalle.builder()
                .id(2L).cantidad(2).insumo(harina).build();

        ArticuloManufacturadoDetalle detallePizzaH3 = ArticuloManufacturadoDetalle.builder()
                .id(3L).cantidad(1).insumo(aceite).build();

        ArticuloManufacturadoDetalle detalleLomo1 = ArticuloManufacturadoDetalle.builder()
                .id(4L).cantidad(1).insumo(sal).build();

        ArticuloManufacturadoDetalle detalleLomo2 = ArticuloManufacturadoDetalle.builder()
                .id(5L).cantidad(1).insumo(aceite).build();

        ArticuloManufacturadoDetalle detalleLomo3 = ArticuloManufacturadoDetalle.builder()
                .id(6L).cantidad(1).insumo(carne).build();

        // ===== ARTÍCULOS MANUFACTURADOS =====
        ArticuloManufacturado pizzaHawaiana = ArticuloManufacturado.builder()
                .id(1L).nombre("Pizza Hawaiana").categoria(catPizzas)
                .imagenes(new HashSet<>(Arrays.asList(imagen1, imagen2, imagen3)))
                .detalles(new HashSet<>(Arrays.asList(detallePizzaH1, detallePizzaH2, detallePizzaH3)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .id(2L).nombre("Lomo Completo").categoria(catLomos)
                .imagenes(new HashSet<>(Arrays.asList(imagen4, imagen5, imagen6)))
                .detalles(new HashSet<>(Arrays.asList(detalleLomo1, detalleLomo2, detalleLomo3)))
                .build();

        // Back-references (opcional, para consistencia)
        detallePizzaH1.setArticuloManufacturado(pizzaHawaiana);
        detallePizzaH2.setArticuloManufacturado(pizzaHawaiana);
        detallePizzaH3.setArticuloManufacturado(pizzaHawaiana);

        detalleLomo1.setArticuloManufacturado(lomoCompleto);
        detalleLomo2.setArticuloManufacturado(lomoCompleto);
        detalleLomo3.setArticuloManufacturado(lomoCompleto);

        catPizzas.getArticulos().add(pizzaHawaiana);
        catLomos.getArticulos().add(lomoCompleto);

        // ===== REPOSITORIO =====
        ArticuloManufacturadoRepository repo = new ArticuloManufacturadoRepository();
        repo.save(pizzaHawaiana);
        repo.save(lomoCompleto);

        // ===== a) Mostrar todas las categorías =====
        System.out.println("\n[a] Categorías:");
        for (Categoria c : Arrays.asList(catPizzas, catSand, catLomos, catInsumos)) {
            System.out.println(" - " + c.getNombre());
        }

        // ===== b) Mostrar todos los Artículos que son insumos =====
        System.out.println("\n[b] Artículos Insumo (esParaElaborar=true):");
        for (Articulo a : catInsumos.getArticulos()) {
            ArticuloInsumo ai = (ArticuloInsumo) a;
            if (ai.isEsParaElaborar()) {
                System.out.println(" - " + ai.getNombre() + " (" + ai.getUnidadMedida().getSimbolo() + ")");
            }
        }

        // ===== c) Mostrar todos los Artículos que son Manufacturados =====
        System.out.println("\n[c] Artículos Manufacturados:");
        repo.findAll().forEach(am -> System.out.println(" - " + am.getNombre()));

        // ===== d) Buscar un Artículo Manufacturado por Id =====
        System.out.println("\n[d] Buscar manufacturado id=1:");
        repo.findById(1L).ifPresent(am -> System.out.println("   Encontrado: " + am.getNombre()));

        // ===== e) Actualizar un Artículo Manufacturado por Id =====
        System.out.println("\n[e] Actualizar manufacturado id=1 (renombrar a 'Pizza Hawaiana Especial'):");
        ArticuloManufacturado pizzaHawaianaActualizada = ArticuloManufacturado.builder()
                .id(1L)
                .nombre("Pizza Hawaiana Especial")
                .categoria(catPizzas)
                .imagenes(pizzaHawaiana.getImagenes())
                .detalles(pizzaHawaiana.getDetalles())
                .build();

        repo.update(1L, pizzaHawaianaActualizada);
        repo.findById(1L).ifPresent(am -> System.out.println("   Nuevo nombre: " + am.getNombre()));

        // ===== f) Eliminar un Artículo Manufacturado por Id =====
        System.out.println("\n[f] Eliminar manufacturado id=2 (Lomo Completo):");
        repo.delete(2L);
        System.out.println("   Restantes:");
        repo.findAll().forEach(am -> System.out.println("   - " + am.getNombre()));

        System.out.println("\nOK – Traza 2 completada.");
    }
}
