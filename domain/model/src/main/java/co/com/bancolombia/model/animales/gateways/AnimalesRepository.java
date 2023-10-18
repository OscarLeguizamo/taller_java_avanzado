package co.com.bancolombia.model.animales.gateways;

import co.com.bancolombia.model.animales.Animales;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AnimalesRepository {

    void create(Animales animal);
    Animales read(String nombre);

    default Animales update(String nombre, Animales animal) throws Exception {
        return animal;
    };


    void delete(String nombre);
    List<Animales> getAll();


}
