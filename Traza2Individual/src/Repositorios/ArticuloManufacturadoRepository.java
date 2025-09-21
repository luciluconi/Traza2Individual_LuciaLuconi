package Repositorios;

import Entidades.ArticuloManufacturado;
import java.util.*;

public class ArticuloManufacturadoRepository {
    private final Map<Long, ArticuloManufacturado> data = new HashMap<>();
    private long idCounter = 0;

    public ArticuloManufacturado save(ArticuloManufacturado am) {
        if (am.getId() == null) am.setId(++idCounter);
        else idCounter = Math.max(idCounter, am.getId());
        data.put(am.getId(), am);
        return am;
    }

    public Optional<ArticuloManufacturado> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<ArticuloManufacturado> findAll() {
        return new ArrayList<>(data.values());
    }

    public List<ArticuloManufacturado> findByNombre(String nombre) {
        List<ArticuloManufacturado> out = new ArrayList<>();
        for (ArticuloManufacturado a : data.values()) {
            if (a.getNombre().equalsIgnoreCase(nombre)) out.add(a);
        }
        return out;
    }

    public Optional<ArticuloManufacturado> update(Long id, ArticuloManufacturado nuevo) {
        if (!data.containsKey(id)) return Optional.empty();
        nuevo.setId(id);
        data.put(id, nuevo);
        return Optional.of(nuevo);
    }

    public Optional<ArticuloManufacturado> delete(Long id) {
        if (!data.containsKey(id)) return Optional.empty();
        return Optional.ofNullable(data.remove(id));
    }
}
