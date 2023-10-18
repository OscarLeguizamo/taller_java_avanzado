package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animalescasos.AnimalesCasosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final AnimalesCasosUseCase animalesCasosUseCase;
//    private final MyUseCase useCase;


    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }

    @GetMapping(path = "/animal/{id}")
    public Animales read(@PathVariable String id){
        return animalesCasosUseCase.read(id);
    }

    @PostMapping(path = "/animal")
    public void create(@RequestBody Animales animal){
        animalesCasosUseCase.create(animal);
    }


    @PutMapping(path = "/animal/{id}")
    public void update(@PathVariable String id, @RequestBody Animales animal){
        try{
            animalesCasosUseCase.update(id, animal);
           }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(path = "/animal/{id}")
    public void delete(@PathVariable String id){
        animalesCasosUseCase.delete(id);
    }

    @GetMapping(path = "/allAnimals")
    public List<Animales> getAll() {return animalesCasosUseCase.getAll();}

}