package co.com.bancolombia.usecase.animalescasos;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
public class AnimalesCasosUseCase {

    private AnimalesRepository animalesRepository;

    public void create(Animales animal){
        animalesRepository.create(animal);
    }

    public Animales read(String nombre) {return animalesRepository.read(nombre);}

    public void update(String nombre, Animales animal)throws Exception{
        animalesRepository.update(nombre, animal);}

    public void delete(String nombre) {animalesRepository.delete(nombre);}

    public List<Animales> getAll() {return animalesRepository.getAll();}


}
