# Traza2Individual_LuciaLuconi
TP Traza 2 – Desarrollo de Software Lucia Luconi 50985

Este proyecto implementa el trabajo práctico Traza 2, modelando las entidades solicitadas y ejecutando en el método main la lógica pedida paso a paso.
Estructura del proyecto

Paquete Entidades: contiene las clases de dominio del modelo.

Categoria: agrupa artículos (ejemplo: Pizzas, Lomos, Insumos).

UnidadMedida: representa unidades de medida (Kilogramos, Litros, Gramos).

Articulo: superclase base de los artículos.

ArticuloInsumo: hereda de Articulo y representa insumos básicos (sal, harina, carne, aceite).

ArticuloManufacturado: hereda de Articulo y representa productos elaborados (ejemplo: Pizza Hawaiana, Lomo Completo). Contiene imágenes y detalles.

ArticuloManufacturadoDetalle: relaciona un ArticuloManufacturado con un ArticuloInsumo y una cantidad.

Imagen: representa las fotos asociadas a los artículos manufacturados.

Paquete Repositorios:

ArticuloManufacturadoRepository: implementación en memoria de operaciones CRUD para artículos manufacturados.

Main.java: contiene la secuencia lógica definida en la consigna.

Principios aplicados

Encapsulación: todos los atributos son privados y se accede mediante getters y setters generados con Lombok.

Relaciones de cardinalidad:

Una Categoria contiene un conjunto de artículos.

Un ArticuloManufacturado contiene un conjunto de imágenes y un conjunto de detalles.

Un DetalleManufacturado relaciona un artículo manufacturado con un insumo y una cantidad.

Multiplicidad: las colecciones se implementan con HashSet como lo indica la consigna.

Lógica implementada en Main

Creación de categorías: Pizzas, Sandwich, Lomos, Insumos.

Creación de unidades de medida: Kilogramos (kg), Litros (L), Gramos (g).

Creación de artículos insumo: sal, aceite, carne y harina, todos con el atributo esParaElaborar = true.

Creación de imágenes:

Imagen 1 a 3 asociadas a la Pizza Hawaiana.
Imagen 4 a 6 asociadas al Lomo Completo.

Creación de detalles de manufacturados, asignando un insumo por detalle.
Creación de artículos manufacturados:

Pizza Hawaiana → imágenes 1 a 3 y detalles (sal, harina, aceite).
Lomo Completo → imágenes 4 a 6 y detalles (sal, aceite, carne).

Ejecución de operaciones CRUD sobre artículos manufacturados:

(a) Mostrar todas las categorías.
(b) Mostrar todos los artículos insumo.
(c) Mostrar todos los artículos manufacturados.
(d) Buscar un artículo manufacturado por Id.



(e) Actualizar un artículo manufacturado por Id.

(f) Eliminar un artículo manufacturado por Id.
