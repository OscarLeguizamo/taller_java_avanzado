package co.com.bancolombia.jpa;


import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaAnimalImpl implements AnimalesRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Animales animal){
        jpaRepositoryAdapter.save(animal);
    }

    @Override
    public Animales read(String nombre) {
        return jpaRepositoryAdapter.findById(nombre);
    }

    @Override
    public Animales update(String nombre, Animales animal) throws Exception{
        Animales animalesDb = jpaRepositoryAdapter.findById(nombre);

        if (animalesDb == null) throw new Exception("Animal Not Found: " + nombre);

        animalesDb.setN_patas(animal.getN_patas());
        animalesDb.setGenero(animal.getGenero());
        animalesDb.setEspecie(animal.getEspecie());
        animalesDb.setHabitat(animal.getHabitat());
        animalesDb.setDomestico(animal.getDomestico());

        jpaRepositoryAdapter.save(animalesDb);
        return animalesDb;

    }

    @Override
    public void delete(String nombre){
        jpaRepositoryAdapter.deleteById(nombre);
    }

    @Override
    public List<Animales> getAll(){
        return jpaRepositoryAdapter.findAll();
    }
}
